package net.javaguides.spring_react_application_backend.repository;

import net.javaguides.spring_react_application_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// RepositoryアノテーションはJpaRepositoryが使用しているinterfaceにすでについているから無くてもいいらしい
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
}
