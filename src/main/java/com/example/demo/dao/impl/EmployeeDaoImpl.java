package com.example.demo.dao.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createEmployee(EmployeeRequest employeeRequest) {
        String sql = "INSERT INTO employee (employeename, employeegender, employeebirthday, employeephone, remark, status) "
                   + "VALUES (:employeename, :employeegender, :employeebirthday, :employeephone, :remark, :status)";


        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("employeename", employeeRequest.getEmployeeName());
        params.addValue("employeegender", employeeRequest.getEmployeeGender());
        params.addValue("employeebirthday", employeeRequest.getEmployeeBirthday());
        params.addValue("employeephone", employeeRequest.getEmployeePhone());
        params.addValue("remark", employeeRequest.getRemark());
        params.addValue("status", "active");


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, params, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to retrieve generated key for employee");
        }

        return key.intValue();
        }
}