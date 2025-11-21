package net.javaguides.spring_react_application_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.spring_react_application_backend.dto.EmployeeDto;
import net.javaguides.spring_react_application_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //おそらくRequestMappingナシで@GetMapping("/api/employees/")でも可
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
