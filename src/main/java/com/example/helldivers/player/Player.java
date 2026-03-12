package com.example.helldivers.player;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name="") JPA lo que hace es ponerte el nombre de esta clase en minuscula, cuidado con eso
public class Player {

    @Id
    private Long id;
    private String username;

    public Player() {
    }

    public Player(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
