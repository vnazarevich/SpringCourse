package com.epam.spring.club.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.DAO.interfaces.CountersRepository;
import com.epam.spring.club.models.Event;

public class CountersRepositoryDao implements CountersRepository{
    JdbcTemplate jdbcTemplate;
    private static final String SQL_CHECK_EVENT = "SELECT COUNT(*) FROM EVENT_COUNTERS WHERE EVENT_ID=?";
    private static final String SQL_ADD_EVENT = "INSERT INTO EVENT_COUNTERS VALUES (?, ?, ?, ?)";
    private static final String SQL_GET_BY_NAME_COUNTER = "SELECT BY_NAME FROM EVENT_COUNTERS WHERE EVENT_ID=?";
    private static final String SQL_GET_BY_TICKET_PRICE_COUNTER = "SELECT TICKET_PRICE FROM EVENT_COUNTERS WHERE EVENT_ID=?";
    private static final String SQL_GET_BY_BOOKED_TICKETS_COUNTER = "SELECT BOOKED_TICKETS FROM EVENT_COUNTERS WHERE EVENT_ID=?";
    private static final String SQL_UPDATE_BY_NAME_COUNTER = "UPDATE EVENT_COUNTERS SET BY_NAME=? WHERE EVENT_ID=?";
    private static final String SQL_UPDATE_TICKET_PRICE_COUNTER = "UPDATE EVENT_COUNTERS SET TICKET_PRICE=? WHERE EVENT_ID=?";
    private static final String SQL_UPDATE_BOOKED_TICKETS_COUNTER = "UPDATE EVENT_COUNTERS SET BOOKED_TICKETS=? WHERE EVENT_ID=?";
    private static final String SQL_GET_ALL_BY_NAME_COUNTER = "SELECT EVENT_ID, BY_NAME FROM EVENT_COUNTERS WHERE BY_NAME!=0";
    private static final String SQL_GET_ALL_TICKET_PRICE_COUNTER = "SELECT EVENT_ID, TICKET_PRICE FROM EVENT_COUNTERS WHERE TICKET_PRICE!=0";
    private static final String SQL_GET_ALL_BOOKED_TICKETS_COUNTER = "SELECT EVENT_ID, BOOKED_TICKETS FROM EVENT_COUNTERS WHERE BOOKED_TICKETS!=0";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCountEventRetrievedByName(String eventId) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        if(count == 0){
            jdbcTemplate.update(SQL_ADD_EVENT, Integer.parseInt(eventId), 0, 0, 0);
        }
        int countByName = jdbcTemplate.queryForObject(SQL_GET_BY_NAME_COUNTER, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        countByName++;
        jdbcTemplate.update(SQL_UPDATE_BY_NAME_COUNTER, countByName, Integer.parseInt(eventId));
    }

    public void addCountEventRetrivedByBookedTicket(String eventId) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        if(count == 0){
            jdbcTemplate.update(SQL_ADD_EVENT, Integer.parseInt(eventId), 0, 0, 0);
        }
        int countBookedTickets = jdbcTemplate.queryForObject(SQL_GET_BY_BOOKED_TICKETS_COUNTER, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        countBookedTickets++;
        jdbcTemplate.update(SQL_UPDATE_BOOKED_TICKETS_COUNTER, countBookedTickets, Integer.parseInt(eventId));
    }

    public void addCountEventRetrievedByTicketPrice(String eventId) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        if(count == 0){
            jdbcTemplate.update(SQL_ADD_EVENT, Integer.parseInt(eventId), 0, 0, 0);
        }
        int countTicketPrice = jdbcTemplate.queryForObject(SQL_GET_BY_TICKET_PRICE_COUNTER, new Object[]{Integer.parseInt(eventId)}, Integer.class);
        countTicketPrice++;
        jdbcTemplate.update(SQL_UPDATE_TICKET_PRICE_COUNTER, countTicketPrice, Integer.parseInt(eventId));
    }

    public int getCountEventRetrievedByName(Event event) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
        if(count == 0){
            return 0;
        }
        return jdbcTemplate.queryForObject(SQL_GET_BY_NAME_COUNTER, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
    }

    public int getCountEventRetrievedByTicketPrice(Event event) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
        if(count == 0){
            return 0;
        }
        return jdbcTemplate.queryForObject(SQL_GET_BY_TICKET_PRICE_COUNTER, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
    }

    public int getCountEventRetrivedByBookedTicket(Event event) {
        int count = jdbcTemplate.queryForObject(SQL_CHECK_EVENT, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
        if(count == 0){
            return 0;
        }
        return jdbcTemplate.queryForObject(SQL_GET_BY_BOOKED_TICKETS_COUNTER, new Object[]{Integer.parseInt(event.getEventId())}, Integer.class);
    }

    public Map<String, Integer> getAllCountersByName() {
        final Map<String, Integer> allByNameCounters = new HashMap<String, Integer>();
        jdbcTemplate.queryForObject(SQL_GET_ALL_BY_NAME_COUNTER, new RowMapper<Map<String, Integer>>() {
            public Map<String, Integer> mapRow(ResultSet resultSet, int i) throws SQLException {
                allByNameCounters.put(resultSet.getString(1), resultSet.getInt(2));
                return allByNameCounters;
            }
        });
        return allByNameCounters;
    }

    public Map<String, Integer> getAllCountersByTicketPrice() {
        final Map<String, Integer> allTicketPriceCounters = new HashMap<String, Integer>();
        jdbcTemplate.queryForObject(SQL_GET_ALL_TICKET_PRICE_COUNTER, new RowMapper<Map<String, Integer>>() {
            public Map<String, Integer> mapRow(ResultSet resultSet, int i) throws SQLException {
                allTicketPriceCounters.put(resultSet.getString(1), resultSet.getInt(2));
                return allTicketPriceCounters;
            }
        });
        return allTicketPriceCounters;
    }

    public Map<String, Integer> getAllCountersByBookedTicket() {
        final Map<String, Integer> allBookedTicketCounters = new HashMap<String, Integer>();
        jdbcTemplate.queryForObject(SQL_GET_ALL_BOOKED_TICKETS_COUNTER, new RowMapper<Map<String, Integer>>() {
            public Map<String, Integer> mapRow(ResultSet resultSet, int i) throws SQLException {
                allBookedTicketCounters.put(resultSet.getString(1), resultSet.getInt(2));
                return allBookedTicketCounters;
            }
        });
        return allBookedTicketCounters;
    }
}
