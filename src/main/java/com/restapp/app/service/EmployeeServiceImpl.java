package com.restapp.app.service;


import com.restapp.app.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<>();
    private static final AtomicInteger EMPLOYEE_ID_HOLDER = new AtomicInteger();

    public EmployeeServiceImpl() {
        Employee employee = new Employee();
        employee.setId(0);
        employee.setFirstName("Ivan");
        employee.setPosition("Stol");
        employee.setSecondName("Ivanovich");
        EMPLOYEE_MAP.put(0, employee);
    }

    @Override
    public void create(Employee employee) {
        final int employeeId = EMPLOYEE_ID_HOLDER.incrementAndGet();
        employee.setId(employeeId);
        EMPLOYEE_MAP.put(employeeId, employee);

    }

    @Override
    public List<Employee> readAll() {
        return new ArrayList<>(EMPLOYEE_MAP.values());
    }

    @Override
    public List<Employee> readByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Employee> readBySecondName(String secondName) {
        return null;
    }

    @Override
    public List<Employee> readByPosition(String position) {
        return null;
    }

    @Override
    public Employee read(Integer id) {
        return EMPLOYEE_MAP.get(id);
    }

}
