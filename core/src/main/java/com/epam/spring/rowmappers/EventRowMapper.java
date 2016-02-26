package com.epam.spring.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.EventRate;
import com.epam.spring.club.models.Event;

/**
 * Created by sadsevens on 2/22/16.
 */
public class EventRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event(resultSet.getString(2), resultSet.getInt(3), EventRate.valueOf(resultSet.getString(4)));
        event.setEventId(Integer.toString(resultSet.getInt(1)));
        return event;
    }
}
