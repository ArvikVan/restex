package rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.entity.Employee;

/**
 * @author ArvikV
 * @version 1.0
 * @since 18.02.2022
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
