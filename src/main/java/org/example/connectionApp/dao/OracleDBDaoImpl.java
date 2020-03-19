package org.example.connectionApp.dao;

import org.example.connectionApp.model.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OracleDBDaoImpl implements DbDao {

    private JdbcTemplate jdbcTemplate;

    public OracleDBDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Data> getAll() {
        String sql = "SELECT * FROM SYSTEM_PREFERENCE";
        List<Data> preferenceList = jdbcTemplate.query(sql, new RowMapper<Data>() {

            public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
                Data preference = new Data();
                preference.setKey(rs.getString("key"));
                preference.setValue(rs.getString("value"));
                return preference;
            }

        });
        return preferenceList;
    }
}
