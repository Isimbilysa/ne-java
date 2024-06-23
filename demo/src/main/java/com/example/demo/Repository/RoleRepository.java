package com.example.demo.Repository;

import com.example.demo.Classes.Enums.ERole;
import com.example.demo.Classes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public  boolean existsByRoleName(ERole roleName);
    public Role findByRoleName(ERole roleName);
}
