package com.demo.exceptionhandler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import org.springframework.data.annotation.Id;

@Entity
@Table(name = "employees")
public class Employee {
    @jakarta.persistence.Id
    private long id;

    @NotNull
    //@Size(min = 2, message = "First Name should have atleast 2 characters")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "Last Name should have atleast 2 characters")
    private String lastName;

    @Email
    @NotBlank
    private String emailId;

    @NotNull
    @Size(min = 2, message = "Passport should have atleast 2 characters")
   // private String passportNumber;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_id", nullable = false)
    public String getEmail() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
/*
    @Column(name = "passport_number", nullable = false)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }*/
}
