package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId) {
        Long theIdl = (long) theId;
        Optional<Product> result = productRepository.findById(theIdl);
        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
            if (theProduct.getInv() > 0) {
                theProduct.setInv((theProduct.getInv())-1);
                productRepository.save(theProduct);
                return "/confirmationofpurchase";
            }
            else {
                return "/cannotpurchase";
            }
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

    }
}
