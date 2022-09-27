package com.credibanco.pruebacredibanco.repository;


import com.credibanco.pruebacredibanco.entity.CardEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends CrudRepository<CardEntity, Long> {

    void deleteByHash(String hash);

    CardEntity findByHash(String hash);

     CardEntity findByValidationNumber(int validationNumber);

    CardEntity findByHashAndValidationNumber(String hash, int validationNumber);
}
