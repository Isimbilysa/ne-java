package com.example.demo.Security;

import com.example.demo.Classes.Customer;
import com.example.demo.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService  implements UserDetailsService {
    private final CustomerRepository customerRepository;


    @Transactional
    public CustomerDetails loadByUserId(Long id) {
        Customer user = this.customerRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id: "+id));
        return CustomerDetails.create(user);
    }

    @Transactional
    public CustomerDetails loadUserByUsername(String username) {
        Optional<Customer> user = customerRepository.findByEmail(username);
        return user.map(CustomerDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found with email of "+username));

    }
}
