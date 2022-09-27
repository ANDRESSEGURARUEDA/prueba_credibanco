package com.credibanco.pruebacredibanco.service;


import com.credibanco.pruebacredibanco.dto.CardDto;
import com.credibanco.pruebacredibanco.entity.CardEntity;

import com.credibanco.pruebacredibanco.repository.ICardRepository;
import com.credibanco.pruebacredibanco.repository.ICardTypeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@Transactional
public class CardService {
    @Autowired
    ICardRepository cardRepository;
    @Autowired
    ICardTypeRepository cardTypeRepository;

    @Value ("${inactive}")
    String inactive;


    public CardDto createCard(CardDto requestCardDTO) {
        try {
            CardEntity cardEntity = new CardEntity();
            cardEntity.setValidationNumber(new Random().nextInt(100));
            cardEntity.setPan(requestCardDTO.getPan());
            cardEntity.setHash(String.valueOf(MessageDigest.getInstance("MD5").digest(String.valueOf(requestCardDTO.getPan()).getBytes())));
            cardEntity.setFirstName(requestCardDTO.getFirstName());
            cardEntity.setLastName(requestCardDTO.getLastName());
            cardEntity.setCedula(requestCardDTO.getCedula());
            cardEntity.setTypeId(cardTypeRepository.findByType(requestCardDTO.getCardType()).getId());
            cardEntity.setPhoneNumber(requestCardDTO.getPhoneNumber());
            cardEntity.setCardStatus(inactive);
            cardEntity.setCreateDate(LocalDateTime.now());
            cardEntity.setLastModifiedDate(LocalDateTime.now());

            cardEntity = cardRepository.save(cardEntity);

            if (cardEntity.getId() != null) {
                CardDto responseCardDTO = new CardDto();
                responseCardDTO.setValidationNumber(cardEntity.getValidationNumber());
                responseCardDTO.setPan(getEncryptedPAN(cardEntity.getPan()));
                responseCardDTO.setHash(cardEntity.getHash());

                return responseCardDTO;
            }

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return null;
    }

    public boolean deleteCard(CardDto requestCardDTO) {
        try {
            cardRepository.deleteByHash(requestCardDTO.getHash());
            return true;
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return false;
    }
    public CardDto enrollCard(CardDto requestCardDTO) {
        try {
            CardEntity cardEntity = cardRepository.findByValidationNumber(requestCardDTO.getValidationNumber());
            cardEntity.setCardStatus("Active");
            cardEntity.setLastModifiedDate(LocalDateTime.now());
            cardRepository.save(cardEntity);
            CardDto responseCardDTO = new CardDto();
            responseCardDTO.setHash(cardEntity.getHash());
            return responseCardDTO;
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return null;
    }

    public CardDto consultCard(CardDto cardDto){
        try {
            CardEntity cardEntity = cardRepository.findByHashAndValidationNumber(cardDto.getHash(), cardDto.getValidationNumber());
            cardRepository.save(cardEntity);
            CardDto responseCardDto = new CardDto();
            responseCardDto.setPan(cardEntity.getPan());
            responseCardDto.setFirstName(cardEntity.getFirstName());
            responseCardDto.setLastName(cardEntity.getLastName());
            responseCardDto.setPhoneNumber(cardEntity.getPhoneNumber());
            return responseCardDto;
        } catch (Exception e) {
                System.out.print("Error: " + e.getMessage());
            }
        return null;
    }
    private String getEncryptedPAN(String pan) {
        String panA = pan.substring(0, 6);
        String panC = pan.substring(pan.length() - 5, pan.length() - 1);
        String panB = "";
        int cardPartialPan = panA.length() + panC.length();
        for (int i = cardPartialPan; i < pan.length(); i++) {
            panB += "*";
        }
        return panA + panB + panC;
    }
}
