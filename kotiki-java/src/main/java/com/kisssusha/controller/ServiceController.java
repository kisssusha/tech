package com.kisssusha.controller;

import com.kisssusha.DAO.dto.OwnersDto;
import com.kisssusha.service.KotikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    KotikiService service;

    @GetMapping("")
    public String startPage(){
        return "Start page";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody OwnersDto owner) {
        service.addOwner(owner);
        return "Successful registration";
    }
}
