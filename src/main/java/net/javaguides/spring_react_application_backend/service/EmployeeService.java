package net.javaguides.spring_react_application_backend.service;

import net.javaguides.spring_react_application_backend.dto.EmployeeDto;

import java.util.List;

// Serviceのinterfaceを定義し、Implの形で使用する形をとることで
// 後から仕様、実装を変更しても呼び出し元を修正しなくて良くなる場合がある
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getEmployees();

    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId);

}
