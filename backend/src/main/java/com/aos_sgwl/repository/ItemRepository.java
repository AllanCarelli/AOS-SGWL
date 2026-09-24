package com.aos_sgwl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aos_sgwl.backend.model.Item;;
//Indica que essa interface atua como um repositório(Comunicação com o banco)
@Repository
//Estende a interface JpaRepository ao ItemRepository, que fornece métodos CRUD prontos:
//save(), findById(), findAll(), deleteById(), existsById, entre outros...
// O primeiro tipo é genérico da entidade(Item), o segundo é o tipo do ID(Long)
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}