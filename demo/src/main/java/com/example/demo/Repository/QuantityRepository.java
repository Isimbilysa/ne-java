package com.example.demo.Repository;

import com.example.demo.Classes.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity,Integer> {
}
