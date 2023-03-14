package com.tms.kulinar.Mappers;

import com.tms.kulinar.domain.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Users users=new Users();
        users.setId(resultSet.getInt("id"));
        users.setFirst_name(resultSet.getString("first name"));
        users.setLast_name(resultSet.getString("last name"));
        users.setPhone(resultSet.getInt("phone"));
        users.setEmail(resultSet.getString("email"));
        users.setLevel(resultSet.getInt("level"));
        System.out.println("WORK WORK WORK");
        return users;
    }
}
