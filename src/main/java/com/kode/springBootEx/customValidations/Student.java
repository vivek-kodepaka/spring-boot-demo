package com.kode.springBootEx.customValidations;

import jakarta.validation.constraints.*;

public class Student {
    @NotBlank(message = "name should not be blank")
    @Size(min = 3,max = 10,message = "should be between 3 to 10 char")
    private String name;
    @Min(value = 15, message = "min 15 age")
    @Max(value = 30, message = "max is 30")
    private int age;
    @Email(message = "valid email pls")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be 10 digits and start with 6-9"
    )
    private String phoneNum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
