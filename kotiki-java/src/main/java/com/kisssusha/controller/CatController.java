package com.kisssusha.controller;

import com.kisssusha.DAO.dto.CatsDto;
import com.kisssusha.service.KotikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    KotikiService service;

    @GetMapping("/findAllCats")
    public List<CatsDto> findAllCats() {
        return service.getCats();
    }

    @PostMapping("/addCat")
    public boolean addCat(@RequestBody CatsDto catsDto) {
        return service.addCat(catsDto);
    }

    @DeleteMapping("/deleteCat/{id}")
    public boolean deleteCat(@PathVariable("id") Long id){
        return service.deleteCat(id);
    }
}
