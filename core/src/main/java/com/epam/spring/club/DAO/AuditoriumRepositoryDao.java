package com.epam.spring.club.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.spring.club.DAO.interfaces.AuditoriumRepository;
import com.epam.spring.club.models.Auditorium;
import com.epam.spring.rowmappers.AuditoriumRowMapper;

public class AuditoriumRepositoryDao implements AuditoriumRepository {
    JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_AUDITORIUMS = "SELECT * FROM AUDITORIUM";


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Auditorium> getAuditoriumList() {
        List<Auditorium> auditoriums = jdbcTemplate.query(SQL_GET_AUDITORIUMS, new AuditoriumRowMapper());
        return auditoriums;
    }

    public Auditorium addAuditorium(String name, int seatsNumber, List<String> vipSeats) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("AUDITORIUM").usingGeneratedKeyColumns("AUDITORIUM_ID");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("NAME", name);
        parameters.put("SEATS", seatsNumber);
        parameters.put("VIP_SEATS", listToString(vipSeats));
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        Auditorium auditorium = new Auditorium(name, seatsNumber, vipSeats);
        auditorium.setAuditoriumId(id.toString());
        return auditorium;
    }

    private String listToString(List<String> strList){
        StringBuilder rString = new StringBuilder();

        String separator = (",");
        for (String each : strList) {
            if(rString.length() == 0){
                rString.append(each);
            }
            else {
                rString.append(separator).append(each);
            }
        }

        return rString.toString();
    }

    public void setAuditoriumList(List<Auditorium> auditoriumList) {
        for(Auditorium auditorium : auditoriumList){
            addAuditorium(auditorium.getName(), auditorium.getSeatsNumber(), auditorium.getVipSeats());
        }
    }
}
