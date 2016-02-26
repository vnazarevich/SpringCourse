package com.epam.spring.club.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.EventRate;
import com.epam.spring.club.DAO.interfaces.EventRepository;
import com.epam.spring.club.models.Event;
import com.epam.spring.rowmappers.EventRowMapper;

public class EventRepositoryDao implements EventRepository {
    JdbcTemplate jdbcTemplate;
    private static final String SQL_REMOVE_EVENT = "DELETE FROM EVENT WHERE EVENT_ID=:id";
    private static final String SQL_GET_EVENT_BY_NAME = "SELECT * FROM EVENT WHERE NAME=? FETCH FIRST ROW ONLY";
    private static final String SQL_GET_EVENTS = "SELECT * FROM EVENT";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Event createEvent(String eventName, int bacePrice, EventRate rate) {
        Event event = new Event(eventName, bacePrice, rate);
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("EVENT").usingGeneratedKeyColumns("EVENT_ID");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("NAME", eventName);
        parameters.put("PRICE", bacePrice);
        parameters.put("EVENT_RATE", rate);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        event.setEventId(id.toString());
        return event;
    }

    public Event remove(Event event) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", event.getEventId());
        int numRows = jdbcTemplate.update(SQL_REMOVE_EVENT, parameters);
        if(numRows > 0) {
            return event;
        }
        else {
            return null;
        }
    }

    public Event getByName(String eventName) {
        return (Event) jdbcTemplate.queryForObject(SQL_GET_EVENT_BY_NAME, new Object[] {eventName}, new EventRowMapper());
    }

    public List<Event> getAll() {
        return jdbcTemplate.query(SQL_GET_EVENTS, new EventRowMapper());
    }

	public Event createEvent(String eventName, int bacePrice) {
		// TODO Auto-generated method stub
		return null;
	}
}
