package com.restapp.app.service;


import com.restapp.app.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> readAll();

    List<Employee> readByFirstName(String firstName);

    List<Employee> readBySecondName(String secondName);

    List<Employee> readByPosition(String position);

    Employee read(Integer id);

}
