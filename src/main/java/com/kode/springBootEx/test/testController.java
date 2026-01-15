package com.kode.springBootEx.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {
    @Value("${app.name}")
    private String appName;

    @GetMapping("/test/{id}")
    public String get(@PathVariable int id){
        return appName + " id is "+ id;
    }

    @GetMapping("/test2")
    public String get2(@RequestParam(name = "name") String id){
        return appName + " name is "+ id;
    }

    @PostMapping("/test3")
    public ResponseEntity<Employee> get3( @RequestBody Employee emp){
        return ResponseEntity.ok(emp);
    }
}
