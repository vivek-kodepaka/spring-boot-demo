package com.kode.springBootEx.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ExceptionController {

    @GetMapping("/exp")
    public String getExp(){
        throw new RuntimeException("exception occured");
    }

    @GetMapping("/customExp")
    public String getExp1(){
        throw new CustomException("exception occured");
    }

   /* @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> exceptionHandler(CustomException exp){
        return ResponseEntity.status(400).body(exp.getMessage());
    }*/

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String,Object>> handleCustonExp(CustomException exp){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", 400);
        map.put("message", exp.getMessage());
        return ResponseEntity.status(400).body(map);

    }

}
