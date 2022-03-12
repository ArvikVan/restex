package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.Employee;
import rest.exception.EmployeeIncorrectData;
import rest.exception.NoEmployeeException;
import rest.repository.EmployeeRepository;
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
     * назначаем ответственного за обработку исключений
     * ResponseEntity обертка над HTTPresponse
     * в обощении тип объекта который добавляется в HTTP response body, когдавы брасывается наш ексепшн
     * EmployeeIncorrectData NoEmployeeException создать для обработки исключения
     */
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleExcepltion(NoEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    /**
     * обрабатываем остальные ексепшены
     * @param exception ексепшн
     * @return на выходе ответ ексепшена
     */
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleExcepltion(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
