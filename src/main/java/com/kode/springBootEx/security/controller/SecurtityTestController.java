package com.kode.springBootEx.security.controller;

import com.kode.springBootEx.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurtityTestController {

    public static List<Student> students = new ArrayList<>(List.of(
            Student.builder().age(29).name("kode").build(),
            Student.builder().name("vive").age(28).build()
    ));

    @GetMapping("students")
    public List<Student> getStudent(){

        return students;
    }

    @PostMapping("students")
    public List<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return students;
    }

    @GetMapping("session")
    public String getSession(HttpServletRequest servletRequest){
        return servletRequest.getRequestedSessionId();
    }

    @GetMapping("csrf")
    public CsrfToken getcsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
