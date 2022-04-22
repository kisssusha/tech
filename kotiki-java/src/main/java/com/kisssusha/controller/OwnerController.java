package com.kisssusha.controller;

import com.kisssusha.DAO.dto.CatsDto;
import com.kisssusha.DAO.dto.OwnersDto;
import com.kisssusha.service.KotikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    KotikiService service;

    @GetMapping("/findAllOwner")
    public List<OwnersDto> findAllOwner() {
        return service.getOwners();
    }

    @PostMapping("/addOwner")
    public boolean addOwner(@RequestBody OwnersDto ownersDto) {
        return service.addOwner(ownersDto);
    }

    @DeleteMapping("/deleteOwner/{id}")
    public boolean deleteOwner(@PathVariable("id") Long id){
        return service.deleteOwner(id);
    }
}
