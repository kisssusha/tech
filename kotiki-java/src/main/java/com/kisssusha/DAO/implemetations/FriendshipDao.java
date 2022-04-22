package com.kisssusha.DAO.implemetations;

import com.kisssusha.DAO.models.Friendship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipDao extends JpaRepository<Friendship, Long> {
    void deleteAllByIdCatOrIdFriend(Long idCat, Long idFriend);
}
