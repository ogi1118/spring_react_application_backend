package net.javaguides.spring_react_application_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class EmployeeManagementAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
