package com.kisssusha.DAO.implemetations;

import com.kisssusha.DAO.models.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersDao extends JpaRepository<Owners, Long> {

}
