package com.aos_sgwl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aos_sgwl.backend.model.Item;;

@Repository

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}