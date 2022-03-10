package rest.service;

import rest.dao.EmployeeDAO;
import rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 26.02.2022
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional/*открываем закрываем сессию*/
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional/*открываем закрываем сессию*/
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional/*открываем закрываем сессию*/
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional/*открываем закрываем сессию*/
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);

    }


}
