package net.javaguides.spring_react_application_backend.repository;

import net.javaguides.spring_react_application_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
