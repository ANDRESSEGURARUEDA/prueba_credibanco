package com.credibanco.pruebacredibanco.service;


import com.credibanco.pruebacredibanco.dto.TransactionDto;
import com.credibanco.pruebacredibanco.entity.CardEntity;
import com.credibanco.pruebacredibanco.entity.TransactionEntity;
import com.credibanco.pruebacredibanco.repository.ICardRepository;
import com.credibanco.pruebacredibanco.repository.ITransactionRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionService {

    @Autowired
    ITransactionRepository transactionRepository;

    @Autowired
    ICardRepository cardRepository;

    @Value ("${inactive}")
    String approved;

    public TransactionDto createtransaction(TransactionDto transactionDto) {

        try {
            CardEntity cardEntity = cardRepository.findByHash(transactionDto.getHash());
            if (cardEntity != null && cardEntity.getCardStatus().equals("Active")) {
                TransactionEntity transactionEntity = new TransactionEntity();

                transactionEntity.setNumeroReferncia(transactionDto.getNumeroReferncia());
                transactionEntity.setTotalCompra(transactionDto.getTotalCompra());
                transactionEntity.setDireccionCompra(transactionDto.getDireccionCompra());
                transactionEntity.setCardId(cardEntity.getId());
                transactionEntity.setCreateDate(LocalDateTime.now());
                transactionEntity.setLastModifiedDate(LocalDateTime.now());
                transactionEntity.setTransactionStatus(approved);

                transactionEntity = transactionRepository.save(transactionEntity);

                if (transactionEntity.getId() != null) {
                    TransactionDto responseDto = new TransactionDto();
                    responseDto.setNumeroReferncia(transactionEntity.getNumeroReferncia());
                    return responseDto;
                }
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return null;
    }

    public TransactionDto rejectTransaction(TransactionDto transactionDto) {
        try {
            TransactionEntity transactionEntity = transactionRepository.findByNumeroReferncia(transactionDto.getNumeroReferncia());
            if (transactionEntity != null && Duration.between(transactionEntity.getCreateDate(), LocalDateTime.now()).toMinutes() <= 5) {
                transactionEntity.setTransactionStatus("Cancel");
                transactionRepository.save(transactionEntity);

                TransactionDto responseDto = new TransactionDto();
                responseDto.setNumeroReferncia(transactionEntity.getNumeroReferncia());
                return responseDto;
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return null;
    }

}
