package net.javaguides.spring_react_application_backend.controller;

import net.javaguides.spring_react_application_backend.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student(1, "Bob", "example@mail.com");
    }
}
