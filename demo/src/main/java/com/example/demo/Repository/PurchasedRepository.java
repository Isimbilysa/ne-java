package com.example.demo.Repository;

import com.example.demo.Classes.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PurchasedRepository extends JpaRepository<Purchased, Integer>{

}
