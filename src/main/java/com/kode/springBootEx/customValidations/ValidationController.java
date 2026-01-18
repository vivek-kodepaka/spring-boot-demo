package com.kode.springBootEx.customValidations;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ValidationController {

    @PostMapping("/validate")
    public ResponseEntity<Student> validate(@Validated @RequestBody Student student){
        return ResponseEntity.ok(student);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handler(MethodArgumentNotValidException exp){

        Map<String,String> map = new LinkedHashMap<>();
        exp.getBindingResult().getFieldErrors().forEach(error -> {
            map.put(error.getField(),error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(map);

    }
}
