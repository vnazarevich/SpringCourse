package com.epam.spring.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.club.models.User;


public class ClientRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    }
}
