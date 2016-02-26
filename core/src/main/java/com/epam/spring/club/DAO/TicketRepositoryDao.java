package com.epam.spring.club.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.DAO.interfaces.TicketRepository;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;
import com.epam.spring.rowmappers.TicketRowMapper;

public class TicketRepositoryDao implements TicketRepository {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_BOOKED_TICKETS_FOR_SHOW = "SELECT * FROM TICKET WHERE IS_FREE=false AND SHOW_ID=?";
    private static final String SQL_BOOK_TICKET = "UPDATE TICKET SET IS_FREE='false' WHERE TICKET_ID=?";
    private static final String SQL_GET_TICKET_BY_SHOWID_SEAT = "SELECT * FROM TICKET WHERE SHOW_ID=? AND SEAT=? FETCH FIRST ROW ONLY";
    private static final String SQL_GET_TICKET_BY_ID = "SELECT * FROM TICKET WHERE TICKET_ID=?";
    private static final String SQL_GET_BOOKED_TICKETS = "SELECT * FROM TICKET WHERE IS_FREE=false";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Ticket createTicket(String showId, int seat, boolean isVIP, boolean isFree, int price) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("TICKET").usingGeneratedKeyColumns("TICKET_ID");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IS_FREE", isFree);
        parameters.put("PRICE", price);
        parameters.put("SHOW_ID", showId);
        parameters.put("SEAT", seat);
        parameters.put("IS_VIP", isVIP);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Ticket(id.toString(), showId, seat, isVIP, isFree, price);
    }

    
    public Ticket getTicket(String showId, int seat) {
        return (Ticket) jdbcTemplate.queryForObject(SQL_GET_TICKET_BY_SHOWID_SEAT, new Object[] {showId, seat}, new TicketRowMapper());
    }

    public List<Ticket> getBookedTickets() {
        return jdbcTemplate.query(SQL_GET_BOOKED_TICKETS, new TicketRowMapper());
    }

    public List<Ticket> getBookedTicketsForShow(Show show) {
        return jdbcTemplate.query(SQL_GET_BOOKED_TICKETS_FOR_SHOW, new Object[] {show.getShowId()}, new TicketRowMapper());
    }
    public Ticket getTicketById(String id) {
        return (Ticket) jdbcTemplate.queryForObject(SQL_GET_TICKET_BY_ID, new Object[] {id}, new TicketRowMapper());
    }

    public Ticket bookTiket(String ticketId) {
        jdbcTemplate.update(SQL_BOOK_TICKET, ticketId);
        return getTicketById(ticketId);
    }

}
