package com.epam.spring.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.models.Auditorium;

public class AuditoriumRowMapper implements RowMapper{

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        List<String> vipSeats = Arrays.asList(resultSet.getString(4).split("\\s*,\\s*"));
        Auditorium auditorium = new Auditorium(resultSet.getString(2), resultSet.getInt(3), vipSeats);
        auditorium.setAuditoriumId(resultSet.getString(1));
        return auditorium;
    }
}
