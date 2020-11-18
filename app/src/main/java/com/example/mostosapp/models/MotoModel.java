package com.example.mostosapp.models;

import java.io.Serializable;

public class MotoModel implements Serializable {
    private int id;
    private String marca;
    private String modelo;
    private String recorrido;
    private String precio;
    private int image;

    public MotoModel() {
    }

    public MotoModel(String marca, String modelo, String recorrido, String precio, int image) {
        this.marca = marca;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.precio = precio;

        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MotoModel{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", recorrido='" + recorrido + '\'' +
                ", precio='" + precio + '\'' +
                ", image=" + image +
                '}';
    }
}
