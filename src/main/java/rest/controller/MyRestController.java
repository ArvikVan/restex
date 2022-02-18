package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.Employee;
import rest.service.EmployeeService;

import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 17.02.2022
 */
@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployees = employeeService.getEmployeeList();
        return allEmployees;
    }
}
