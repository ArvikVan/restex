package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.Employee;
import rest.exception.NoEmployeeException;
import rest.service.EmployeeService;

import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 17.02.2022
 */
@RestController/*управляем запросами и ответами*/
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees") /*используем гет метод*/
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) { /*для получения переменной из запроса*/
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoEmployeeException("No employee with id " + id + " in DB");
        }
        return employee;
    }
}
