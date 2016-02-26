package com.epam.spring.club.DAO;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.epam.spring.club.DAO.interfaces.DiscountStatisticsRepository;



public class DiscountStatisticsRepositoryDao implements DiscountStatisticsRepository {
    JdbcTemplate jdbcTemplate;
    private static final String SQL_ADD_CLIENT = "INSERT INTO DISCOUNT_COUNTERS VALUES (?, ?)";
    private static final String SQL_GET_CLIENT_DISCOUNT_COUNTER = "SELECT COUNT FROM DISCOUNT_COUNTERS WHERE CLIENT_ID=?";
    private static final String SQL_UPDATE_CLIENT_DISCOUNT_COUNTER = "UPDATE DISCOUNT_COUNTERS SET COUNT=? WHERE CLIENT_ID=?";
    private static final String SQL_GET_TOTAL_DISCOUNT = "SELECT DISCOUNT_COUNT FROM TOTAL_DISCOUNTS";
    private static final String SQL_UPDATE_TOTAL_DISCOUNT = "UPDATE TOTAL_DISCOUNTS SET DISCOUNT_COUNT=?";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getDiscountCountByClient(String clientId) {
        try{
            return jdbcTemplate.queryForObject(SQL_GET_CLIENT_DISCOUNT_COUNTER, new Object[]{Integer.parseInt(clientId)}, Integer.class);
        }
        catch (EmptyResultDataAccessException e){
            return 0;
        }
    }

    public int getTotalDiscountsCount() {
        return jdbcTemplate.queryForObject(SQL_GET_TOTAL_DISCOUNT, Integer.class);
    }

    public void addDiscountCountByClient(String clientId) {
        try{
            int count = jdbcTemplate.queryForObject(SQL_GET_CLIENT_DISCOUNT_COUNTER, new Object[]{Integer.parseInt(clientId)}, Integer.class);
            count++;
            jdbcTemplate.update(SQL_UPDATE_CLIENT_DISCOUNT_COUNTER, count, Integer.parseInt(clientId));
        }
        catch (EmptyResultDataAccessException e){
            jdbcTemplate.update(SQL_ADD_CLIENT, Integer.parseInt(clientId), 1);
        }


    }

    public void addTotalDiscountsCount() {
        try{
            int count = jdbcTemplate.queryForObject(SQL_GET_TOTAL_DISCOUNT, Integer.class);
            count++;
            jdbcTemplate.update(SQL_UPDATE_TOTAL_DISCOUNT, count);
        }
        catch (EmptyResultDataAccessException e){
            jdbcTemplate.update(SQL_UPDATE_TOTAL_DISCOUNT, 1);
        }
    }
}
