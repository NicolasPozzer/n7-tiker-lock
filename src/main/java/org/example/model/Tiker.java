package org.example.model;

public class Tiker {
    private Integer id;
    private String symbol;
    private String nombre;
    private Boolean activo;

    public Tiker() {
    }

    public Tiker(Integer id, String symbol, String nombre, Boolean activo) {
        this.id = id;
        this.symbol = symbol;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

