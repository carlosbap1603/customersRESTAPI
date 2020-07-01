package com.amdocs.badillo.customers.controllers;

import com.amdocs.badillo.customers.entities.ServiceRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRequestsController {

    @GetMapping("/serviceRequests")
    public ServiceRequest requestService(@RequestParam(value="userId") long userId, @RequestParam(value="productId") long productId, @RequestParam(value="actionId") long actionId){
        return new ServiceRequest(userId, productId, actionId);
    }
}
