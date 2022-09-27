package com.credibanco.pruebacredibanco.repository;



import com.credibanco.pruebacredibanco.entity.CardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICardTypeRepository extends JpaRepository<CardTypeEntity, Long> {

    CardTypeEntity findByType(String type);
}
