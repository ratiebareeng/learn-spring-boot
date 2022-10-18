package com.example.validatingforminput.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {
    @NotNull(message = "Name is required") // Does not allow a null value
    @Size(min=2, max=30, message = "Name must be 2-30 characters long") // Allows names between 2 and 30 characters long.
    private  String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Must be 18+") // Does not allow the age to be less than 18
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}