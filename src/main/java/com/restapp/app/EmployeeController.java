package com.restapp.app;

import com.restapp.app.pojo.Employee;
import com.restapp.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class EmployeeController extends HttpServlet {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> readAll() {
        final List<Employee> employees = employeeService.readAll();

        return employees != null && !employees.isEmpty()
               ? new ResponseEntity<>(employees, HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> read(@PathVariable(name = "id") int id) {
        Employee employee = employeeService.read(id);

        return employee != null
               ? new ResponseEntity<>(employee, HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/index")
    public String sayHello(){
        return "hello from spring boot";
    }

}
