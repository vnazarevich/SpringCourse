package com.epam.spring.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.models.Show;

public class ShowRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Show(Integer.toString(resultSet.getInt(1)), Integer.toString(resultSet.getInt(2)),
                             Integer.toString(resultSet.getInt(4)), resultSet.getDate(3));
    }
}
