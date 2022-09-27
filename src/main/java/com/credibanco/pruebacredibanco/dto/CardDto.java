package com.credibanco.pruebacredibanco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {

    @JsonProperty ("pan")
    private String pan;
    @JsonProperty ("firstName")
    private String firstName;
    @JsonProperty ("lastName")
    private String lastName;
    @JsonProperty ("cedula")
    private String cedula;
    @JsonProperty ("cardType")
    private String cardType;
    @JsonProperty ("phoneNumber")
    private Long phoneNumber;
    @JsonProperty ("validationNumber")
    private int validationNumber;
    @JsonProperty ("hash")
    private String hash;


    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(int validationNumber) {
        this.validationNumber = validationNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "CardDto{" + "pan='" + pan + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", cedula='" + cedula + '\'' + ", cardType='" + cardType + '\'' + ", phoneNumber=" + phoneNumber + ", validationNumber=" + validationNumber + ", hash='" + hash + '\'' + '}';
    }
}
