package com.kisssusha.service;

import com.kisssusha.DAO.dto.CatsDto;
import com.kisssusha.DAO.dto.OwnersDto;
import com.kisssusha.DAO.implemetations.CatsDao;
import com.kisssusha.DAO.implemetations.FriendshipDao;
import com.kisssusha.DAO.implemetations.OwnersDao;
import com.kisssusha.DAO.implemetations.ShelterDao;
import com.kisssusha.DAO.models.Cats;
import com.kisssusha.DAO.models.Owners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KotikiService {
    @Autowired
    CatsDao catDAO;
    @Autowired
    OwnersDao ownerDAO;
    @Autowired
    FriendshipDao friendshipDao;
    @Autowired
    ShelterDao shelterDao;

    public List<CatsDto> getCats(){
        return catDAO.findAll().stream().map(CatsDto::new).collect(Collectors.toList());
    }

    public boolean addCat(CatsDto catsDto){
        catDAO.save(new Cats(catsDto));
        return true;
    }

    @Transactional
    public boolean deleteCat(Long idCat){
        shelterDao.deleteAllByIdCat(idCat);
        friendshipDao.deleteAllByIdCatOrIdFriend(idCat, idCat);
        catDAO.deleteById(idCat);
        return true;
    }
    public List<OwnersDto> getOwners(){
        return ownerDAO.findAll().stream().map(OwnersDto::new).collect(Collectors.toList());
    }
    public boolean addOwner(OwnersDto ownersDto){
        ownerDAO.save(new Owners(ownersDto));
        return true;
    }
    @Transactional
    public boolean deleteOwner(Long idOwner){
        shelterDao.deleteAllByIdOwner(idOwner);
        ownerDAO.deleteById(idOwner);
        return true;
    }
}

