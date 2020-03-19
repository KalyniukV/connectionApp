package org.example.connectionApp.dao;

import org.example.connectionApp.model.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FirebirdDBDaoImpl implements DbDao {

    private JdbcTemplate jdbcTemplate;

    public FirebirdDBDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Data> getAll() {

        String sql = "SELECT * FROM RDB$FIELDS";
        List<Data> preferenceList = jdbcTemplate.query(sql, new RowMapper<Data>() {

            public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
                Data preference = new Data();
                preference.setKey(rs.getString("RDB$FIELD_NAME"));
                preference.setValue(rs.getString("RDB$QUERY_NAME"));
                return preference;
            }

        });
        return preferenceList;
    }
}


