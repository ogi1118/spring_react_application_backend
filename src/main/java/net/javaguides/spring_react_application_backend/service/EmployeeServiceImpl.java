package net.javaguides.spring_react_application_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.spring_react_application_backend.dto.EmployeeDto;
import net.javaguides.spring_react_application_backend.entity.Employee;
import net.javaguides.spring_react_application_backend.mapper.EmployeeMapper;
import net.javaguides.spring_react_application_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // 動画では記述していたがまだ糸を拾えてない
public class EmployeeServiceImpl implements EmployeeService{

    //@Autowired
    // 動画では書いてなかった。調べたら
    // 書いてもいいけど無くても問題ない、らしい(by Gemini)
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
