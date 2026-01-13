package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.model.Employee;
import com.example.demo.rowmapper.EmployeeRowMapper;


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
    
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        String sql = "SELECT idemployee, employeename, employeegender, employeebirthday, employeephone, remark, status FROM employee WHERE idemployee = :employeeId";
    
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", employeeId);
    
        List<Employee> list = namedParameterJdbcTemplate.query(sql, params, new EmployeeRowMapper());
    
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT idemployee, employeename, employeegender, employeebirthday, employeephone, remark, status FROM employee";
    
        return namedParameterJdbcTemplate.query(sql, new EmployeeRowMapper());
    }
}