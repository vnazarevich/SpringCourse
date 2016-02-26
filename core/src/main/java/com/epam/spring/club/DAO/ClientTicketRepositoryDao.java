package com.epam.spring.club.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.DAO.interfaces.ClientTicketRepository;

public class ClientTicketRepositoryDao implements ClientTicketRepository {
    JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_TICKETS_FOR_CLIENT = "SELECT * FROM CLIENT_TICKETS WHERE CLIENT_ID=?";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getBookedTickets(String clientId) {
        List<String> tickets = new ArrayList<String>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_GET_TICKETS_FOR_CLIENT, new Object[]{clientId});
        for(Map row : rows){
            tickets.add(Integer.toString((Integer)row.get("TICKET_ID")));
        }
        return tickets;
    }

    public String addTicket(String clientId, String ticketId) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("CLIENT_TICKETS");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("CLIENT_ID", clientId);
        parameters.put("TICKET_ID", ticketId);
        jdbcInsert.execute(parameters);
        return ticketId;
    }
}