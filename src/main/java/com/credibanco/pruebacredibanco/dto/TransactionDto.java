package com.credibanco.pruebacredibanco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import java.time.LocalDateTime;

@JsonInclude (JsonInclude.Include.NON_NULL)
public class TransactionDto {

    @JsonProperty ("numeroReferncia")
    private String numeroReferncia;

    @JsonProperty ("totalCompra")
    private String totalCompra;

    @JsonProperty ("direccionCompra")
    private String direccionCompra;

    @JsonProperty ("createDate")
    private LocalDateTime createDate;

    @JsonProperty ("lastModifiedDate")
    private LocalDateTime lastModifiedDate;
    @JsonProperty ("hash")
    private String hash;


    public String getNumeroReferncia() {
        return numeroReferncia;
    }

    public void setNumeroReferncia(String numeroReferncia) {
        this.numeroReferncia = numeroReferncia;
    }

    public String getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(String totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDireccionCompra() {
        return direccionCompra;
    }

    public void setDireccionCompra(String direccionCompra) {
        this.direccionCompra = direccionCompra;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
