package com.epam.spring.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.models.Ticket;

/**
 * Created by sadsevens on 2/22/16.
 */
public class TicketRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Ticket(Integer.toString(resultSet.getInt(1)), resultSet.getString(2), resultSet.getInt(3),
                                    resultSet.getBoolean(4), resultSet.getBoolean(5), resultSet.getInt(6));
    }
}
