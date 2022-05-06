package com.kisssusha.controller;

import com.kisssusha.DAO.dto.CatsDto;
import com.kisssusha.DAO.dto.FriendshipDto;
import com.kisssusha.service.KotikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    KotikiService service;

    @GetMapping("/find-all-cats")
    public List<CatsDto> findAllCats() {
        return service.getCats();
    }

    @PostMapping("/add-cat")
    public boolean addCat(@RequestBody CatsDto catsDto) {
        return service.addCat(catsDto);
    }

    @DeleteMapping("/delete-cat/{id}")
    public boolean deleteCat(@PathVariable("id") Long id) {
        return service.deleteCat(id);
    }

    @DeleteMapping("/break-friendship")
    public boolean breakFriendship(@RequestBody FriendshipDto friendshipDto) {
        return service.breakFriendship(friendshipDto.getIdCat(), friendshipDto.getIdFriend());
    }
    @PostMapping("/make-friendship")
    public boolean makeFriendship(@RequestBody FriendshipDto friendshipDto){
        return service.makeFriendship(friendshipDto);
    }
}
