package rest.service;

import org.springframework.stereotype.Service;
import rest.dao.EmployeeDAO;
import rest.entity.Employee;
import rest.repository.EmployeeRepository;

import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 18.02.2022
 */
@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public List<Employee> getEmployeeList() {
        return  employeeDAO.getAllEmployees();
    }
}
