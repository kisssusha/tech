package com.kisssusha.DAO.implemetations;

import com.kisssusha.DAO.models.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatsDao extends JpaRepository<Cats, Long> {
}
