package com.example.demo;

import com.example.demo.Classes.Enums.ERole;
import com.example.demo.Classes.Role;
import com.example.demo.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@RequiredArgsConstructor
public class Ne2023Application {
	public final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ne2023Application.class, args);
	}

	@Bean
	public int initializeRoles(){
		List<ERole> roles = new ArrayList<>();
		roles.add(ERole.ADMIN);
		roles.add(ERole.CUSTOMER);
//        roles.add(ERole.TRADER);

		for(ERole roleName :roles) {
			if (!roleRepository.existsByRoleName(roleName)){
				Role role = new Role();
//                role.setId();
				role.setRoleName(roleName);
				roleRepository.save(role);
			}
		}
		return 0;
	}
}
