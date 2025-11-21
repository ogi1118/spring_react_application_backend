package net.javaguides.spring_react_application_backend.mapper;

import net.javaguides.spring_react_application_backend.dto.EmployeeDto;
import net.javaguides.spring_react_application_backend.entity.Employee;

// Mapperクラス。DBとやり取りする際にEntity-Dtoクラスの変換をするためのクラス
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee e){
        return new EmployeeDto(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto empDto){
        return new Employee(
                empDto.getId(),
                empDto.getFirstName(),
                empDto.getLastName(),
                empDto.getEmail()
        );
    }
}
