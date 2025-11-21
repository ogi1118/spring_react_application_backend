package net.javaguides.spring_react_application_backend.repository;

import net.javaguides.spring_react_application_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
}
