package com.credibanco.pruebacredibanco.controller;

import com.credibanco.pruebacredibanco.dto.TransactionDto;
import com.credibanco.pruebacredibanco.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/apis")
@CrossOrigin (origins = "*")
public class TransactionController {

    @Value ("${badResponseCard}")
    String badResponse;

    @Autowired
    TransactionService transactionService;


    private ObjectMapper objectMapper;

    public TransactionController() {
        objectMapper = new ObjectMapper();
    }

    //Method Creat Transaction
    @PostMapping (path = "/create-transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createTransaction(@RequestBody String requestJson){
        try{
            TransactionDto requestTransactionDto = objectMapper.readValue(requestJson, TransactionDto.class);
            TransactionDto responseTransactionDto = transactionService.createtransaction(requestTransactionDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseTransactionDto);
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponse);
    }

    //Method Cancel Transaction
    @PostMapping (path = "/reject-transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> rejectTransaction(@RequestBody String requestJson){
        try{
            TransactionDto requestTransactionDto = objectMapper.readValue(requestJson, TransactionDto.class);
            TransactionDto responseTransactionDto = transactionService.rejectTransaction(requestTransactionDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseTransactionDto);
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponse);
    }
}
