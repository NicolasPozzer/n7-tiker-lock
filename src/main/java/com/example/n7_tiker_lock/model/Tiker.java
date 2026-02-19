package com.example.n7_tiker_lock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tikers_bloqueados") // mismo nombre de tabla
public class Tiker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mejor si viene de DB
    private Integer id;

    @Column(name = "symbol", unique = true, nullable = false, length = 100)
    private String symbol;

    @Column(name = "active")
    private Integer active;

    public Tiker() {
    }

    public Tiker(String symbol, Integer active) {
        this.symbol = symbol;
        this.active = active;
    }

    // getters y setters
    public Integer getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
