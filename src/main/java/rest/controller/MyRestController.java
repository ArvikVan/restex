package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    /**
     * прокидываем жсон в теле запроса с помощью постмаппинга
     * @param employee емплои который надо добавить
     * @return на выходе добавленый емплои
     * PostMapping связывает хттп запрос с методом контроллера
     * RequestBody связывает тело метода с параметром метода контроллера
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    /**
     * получаем жаваобъект который жсонов в ответе приходит
     * @param employee что на входе
     * @return на выходе жава объект
     * PutMapping связывает запрос с методом контроллера
     * Емплои помтоу что возвращаем емплои
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    /**
     * удаляем емплои
     * @param id ид по которому удалять будем
     * @return на выходе текст об удалении
     * String потому что возвращаем текст
     */
    @DeleteMapping("/employees/{id}")
    public String deleteEmloyee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoEmployeeException("No employee with id " + id + " in DB");
        }
        employeeService.deleteEmployee(id);
        return  "Employee with id " + id + " delete.";
    }
}
