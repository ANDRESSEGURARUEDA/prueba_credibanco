package com.credibanco.pruebacredibanco.controller;

import com.credibanco.pruebacredibanco.dto.CardDto;
import com.credibanco.pruebacredibanco.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api")
@CrossOrigin (origins = "*")
public class CardController {

    @Value ("${badResponseCard}")
    String badResponse;
    @Value ("${badResponseCardDelete}")
    String badResponseCardDelete;
    @Value ("${badResponseCardEnroll}")
    String badResponseCardEnroll;
    @Value ("${badResponseCardConsult}")
    String badResponseCardConsult;

    @Autowired
    CardService cardService;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    //Method Create Card
    @PostMapping (path = "/create-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCard(@RequestBody CardDto requestCardDTO) {
        try {
            CardDto responseCardDTO = cardService.createCard(requestCardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCardDTO);
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponse);
    }


    //Method Delete Card
    @PostMapping (path = "/delete-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCard(@RequestBody CardDto requestCardDTO) {
        try {
            boolean delete = cardService.deleteCard(requestCardDTO);
            if (delete) {
                return ResponseEntity.status(HttpStatus.OK).body("00");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("01");
        } catch (Exception e) {
            System.out.println("Error al eliminar la tarjeta: " + e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponseCardDelete);
    }

    //Method Enroll Card
    @PostMapping (path = "/enRoll-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> enRollCard(@RequestBody String requestJson) {
        try {
            CardDto requestCardDTO = objectMapper.readValue(requestJson, CardDto.class);
            return ResponseEntity.status(HttpStatus.OK).body(cardService.enrollCard(requestCardDTO));
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponseCardEnroll);
    }

    //Method Consult Card
    @PostMapping (path = "/consult-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultCard(@RequestBody String requestJson) {
        try {
            CardDto requestCardDTO = objectMapper.readValue(requestJson, CardDto.class);
            return ResponseEntity.status(HttpStatus.OK).body(cardService.consultCard(requestCardDTO));
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponseCardConsult);
    }

}
