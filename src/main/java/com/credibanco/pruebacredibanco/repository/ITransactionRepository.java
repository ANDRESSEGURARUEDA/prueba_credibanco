package com.credibanco.pruebacredibanco.repository;

import com.credibanco.pruebacredibanco.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long> {

    TransactionEntity findByNumeroReferncia(String numeroReferncia);
}
