package com.goncharovvlad.spring_mvc_hibernate_aop.entity.service;

import com.goncharovvlad.spring_mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
