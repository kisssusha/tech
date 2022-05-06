package com.kisssusha.DAO.implemetations;

import com.kisssusha.DAO.models.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterDao extends JpaRepository<Shelter, Long> {
    void deleteAllByIdCat(Long catId);
    void deleteAllByIdOwner(Long ownerId);
    void deleteAllByIdOwnerAndIdCat(Long ownerId, Long catId);
}