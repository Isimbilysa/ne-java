package com.example.demo.Services;

import com.example.demo.Classes.Quantity;
import com.example.demo.Repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityService {
    @Autowired
    private QuantityRepository quantityRepository;

    public void registerQuantity(Quantity quantity) {

        quantityRepository.save(quantity);
    }
}
