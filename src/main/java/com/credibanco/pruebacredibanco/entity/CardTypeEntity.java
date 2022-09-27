package com.credibanco.pruebacredibanco.entity;

import javax.persistence.*;

@Entity
@Table(name = "CardType" )
public class CardTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "type")
    private String type;

    public CardTypeEntity() {
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
