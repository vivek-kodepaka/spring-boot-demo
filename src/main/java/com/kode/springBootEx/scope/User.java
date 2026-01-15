package com.kode.springBootEx.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class User {
    private Address address;

    public User(Address address) {
        this.address = address;
    }

    @PostConstruct
    public void init(){
        System.out.println("post const called user");
        System.out.println(address);
    }

    @PreDestroy
    public void dest(){
        System.out.println("post const called user");
        System.out.println(address);
    }
}
