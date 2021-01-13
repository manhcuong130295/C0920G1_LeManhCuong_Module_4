package com.codegym.entity;

import com.codegym.validation.Age;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "User")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 5, max = 45, message = "first name must have minimum of 5 and maximum 45 character")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "wrong format for first name")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45, message = "first name must have minimum of 5 and maximum 45 character")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "wrong format for first name")
    private String lastName;

    @NotBlank
    @Size(min = 10,max = 11,message = "wrong format phone number")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",message = "wrong format phone number")
    private String numberPhone;
    @NotBlank
    @Age
    @Column(name = "birth_day" ,columnDefinition = "DATE")
    String birthDay;

    @NotBlank
    @Email(message = "wrong format email")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }


}
