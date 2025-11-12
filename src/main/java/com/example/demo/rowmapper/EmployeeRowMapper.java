package com.example.demo.rowmapper;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    @NonNull
    public Employee mapRow(@NonNull ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();    

        employee.setEmployeeId(resultSet.getInt("idemployee"));
        employee.setEmployeeName(resultSet.getString("employeename"));
        employee.setEmployeeGender(resultSet.getString("employeegender"));
        employee.setEmployeeBirthday(resultSet.getString("employeebirthday"));
        employee.setEmployeePhone(resultSet.getString("employeephone"));
        employee.setRemark(resultSet.getString("remark"));
        employee.setStatus(resultSet.getString("status"));

        return employee;
    }
}
