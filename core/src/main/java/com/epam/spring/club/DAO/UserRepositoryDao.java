package com.epam.spring.club.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.DAO.interfaces.UserRepository;
import com.epam.spring.club.models.User;
import com.epam.spring.rowmappers.ClientRowMapper;

public class UserRepositoryDao implements UserRepository {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_REMOVE_CLIENT = "DELETE FROM CLIENT WHERE CLIENT_ID=:id";
    private static final String SQL_GET_CLIENT_BY_ID = "SELECT * FROM CLIENT WHERE CLIENT_ID=?";
    private static final String SQL_GET_CLIENT_BY_EMAIL = "SELECT * FROM CLIENT WHERE EMAIL=? FETCH FIRST ROW ONLY";
    private static final String SQL_GET_CLIENT_BY_NAME = "SELECT * FROM CLIENT WHERE CLIENTNAME=? FETCH FIRST ROW ONLY";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String registerUser(String name, String email) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("CLIENT").usingGeneratedKeyColumns("CLIENT_ID");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("CLIENTNAME", name);
        parameters.put("EMAIL", email);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return id.toString();
   }

    public User removeUser(User user) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", user.getId());
        int numRows = jdbcTemplate.update(SQL_REMOVE_CLIENT, parameters);
        if(numRows > 0) {
            return user;
        }
        else {
            return null;
        }
    }

    public User getUserById(String id) {
        return (User) jdbcTemplate.queryForObject(SQL_GET_CLIENT_BY_ID, new Object[] {id}, new ClientRowMapper());
    }

    public User getUserByEmail(String email) {
        return (User) jdbcTemplate.queryForObject(SQL_GET_CLIENT_BY_EMAIL, new Object[] {email}, new ClientRowMapper());
    }

    public User getUserByName(String name) {
        try {
            return (User) jdbcTemplate.queryForObject(SQL_GET_CLIENT_BY_NAME, new Object[]{name}, new ClientRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
