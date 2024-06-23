package com.example.demo.Controllers;

import com.example.demo.Classes.Customer;
import com.example.demo.Exceptions.UserExistsException;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Services.CustomerService;
import com.example.demo.dto.LoginModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerRepository customerRepository;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody LoginModel loginModel) {

        try {
            customerService.registerUser(loginModel);
            return ResponseEntity.ok().build();
        }catch (UserExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginModel loginModel) {
        try {
            String token = customerService.loginUser(loginModel);
            if (token != null) {
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }}


