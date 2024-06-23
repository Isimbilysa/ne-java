package com.example.demo.Services;

import com.example.demo.Classes.Purchased;
import com.example.demo.Repository.PurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedService {
    @Autowired
    private PurchasedRepository purchasedRepository;

    public void addPurchase(Purchased purchase) {
        purchase.setTotal(purchase.getQuantity() /* get product price */);
        purchasedRepository.save(purchase);
    }
}
