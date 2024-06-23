package com.example.demo.Security;

import com.example.demo.Classes.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails implements UserDetails {
    private Long id;

    private String firstName;

    private String phone;

    private String email;

    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomerDetails(Customer customer) {
    }


    public static CustomerDetails create(Customer user) {
        List<GrantedAuthority> authorities =user.getRoles().stream().
                map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toList());


        return new CustomerDetails(
                user.getId(),
                user.getFirstName(),
                user.getPhone(),
                user.getPassword(),
                user.getEmail(),

                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
