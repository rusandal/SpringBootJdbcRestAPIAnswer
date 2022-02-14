package com.example.springbootjdbc2.repository;

import com.example.springbootjdbc2.model.OrdersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class Orders{
    private static final String QUERY_FILE = "query.sql";

    /*@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;*/

    @PersistenceContext
    private EntityManager entityManager;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String myName){
        Query query = entityManager.createQuery(read(QUERY_FILE), String.class);
        query.setParameter("name", myName);
        return query.getResultList();
        //return namedParameterJdbcTemplate.queryForList(read(QUERY_FILE), Map.of("name", name), String.class);
    }
}
