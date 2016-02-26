package com.epam.spring.club.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.DAO.interfaces.ShowRepository;
import com.epam.spring.club.models.Auditorium;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.rowmappers.ShowRowMapper;

public class ShowRepositoryDao implements ShowRepository {
    JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_SHOW_BY_ID = "SELECT * FROM SHOW WHERE SHOW_ID=?";
    private static final String SQL_GET_SHOW_EVENT_DATE_AUDITORIUM = "SELECT * FROM SHOW WHERE EVENT_ID=? AND SHOW_DATE=? AND AUDITORIUM_ID=?";
    private static final String SQL_GET_SHOWS_BY_EVENT_DATE = "SELECT * FROM SHOW WHERE EVENT_ID=? AND SHOW_DATE=?";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Show createShow(Event event, Auditorium auditorium, Date date) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("SHOW").usingGeneratedKeyColumns("SHOW_ID");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("EVENT_ID", event.getEventId());
        parameters.put("SHOW_DATE", date);
        parameters.put("AUDITORIUM_ID", auditorium.getAuditoriumId());
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Show(id.toString(), event.getEventId(), auditorium.getAuditoriumId(), date);
    }

    public Show getShow(String eventId, String auditoriumId, Date date) {
        return (Show) jdbcTemplate.queryForObject(SQL_GET_SHOW_EVENT_DATE_AUDITORIUM, new Object[] {eventId, date, auditoriumId}, new ShowRowMapper());
    }

    public Show getShow(String showId) {
        return (Show) jdbcTemplate.queryForObject(SQL_GET_SHOW_BY_ID, new Object[] {showId}, new ShowRowMapper());
    }

    public List<Show> getShowForTheDate(String eventId, Date date) {
        return jdbcTemplate.query(SQL_GET_SHOWS_BY_EVENT_DATE, new Object[] {eventId, date}, new ShowRowMapper());
    }
}
