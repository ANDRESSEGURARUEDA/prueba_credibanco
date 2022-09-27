package com.credibanco.pruebacredibanco.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction" )
public class TransactionEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id", nullable = false)
    private Long id;

    @Column (name = "numeroreferncia")
    private String numeroReferncia;

    @Column (name = "totalcompra")
    private String totalCompra;

    @Column (name = "direccioncompra")
    private String direccionCompra;

    @Column (name = "createdate")
    private LocalDateTime createDate;

    @Column (name = "lastmodifieddate")
    private LocalDateTime lastModifiedDate;

    @Column (name = "idcard")
    private Long cardId;

    @Column (name = "transactionstatus")
    private String transactionStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
