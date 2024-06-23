package com.example.demo.Services;

import com.auth0.jwt.JWT;
import com.example.demo.Classes.Customer;
import com.example.demo.Classes.Role;
import com.example.demo.Exceptions.UserExistsException;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.dto.LoginModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service

public class CustomerService {
    private  final  EncryptionService encryptionService;
    private final  JWTService jwtService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;



    // Method to register a new customer
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    // Method to authenticate a customer
//    public boolean authenticate(String email, String password) {
//       Optional <Customer> customer = customerRepository.findByEmail(email);
//        return customer != null && customer.getPassword().equals(password);
//    }

    public CustomerService(CustomerRepository customerRepository, EncryptionService encryptionService,JWTService jwtService) {
        this.customerRepository = customerRepository;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;

    }
    public String loginUser(LoginModel loginModel) {

        Optional<Customer> opUser = customerRepository.findByEmail(loginModel.getEmail());

        if (opUser.isPresent()) {
            Customer user = opUser.get();
            if (encryptionService.verifyPassword(loginModel.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }


        }

        return null;

    }

    public Customer registerUser(LoginModel loginModel)  throws UserExistsException {

        if(customerRepository.findByEmailIgnoreCase(loginModel.getEmail()).isPresent()){
            throw new UserExistsException();
        };
        Customer user= new Customer();

        Role role= roleRepository.findByRoleName(loginModel.getRole());
        user.setFirstName(loginModel.getFirstname());
        user.setEmail(loginModel.getEmail());
        user.setPhone(String.valueOf(loginModel.getPhone()));
        user.setPassword(encryptionService.encryptPassword(loginModel.getPassword()));
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return customerRepository.save(user);


    }
}

