package com.kode.springBootEx.test;

import com.kode.springBootEx.scope.AppInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {
    @Value("${app.name}")
    private String appName;

    private AppInfo appInfo;

    public testController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    @GetMapping("/test/{id}")
    public String get(@PathVariable(required = false) int id){
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

    @GetMapping("/info")
    public ResponseEntity<AppInfo> get4(){
        return ResponseEntity.ok(appInfo);
    }
}
