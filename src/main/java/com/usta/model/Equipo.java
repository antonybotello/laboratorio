package com.usta.model;

public class Equipo {
    String nombre;
    int cantidad;
    String numeroDeSerie;
    public Equipo siguiente;
    public Equipo(String nombre, int cantidad, String numeroDeSerie) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.numeroDeSerie = numeroDeSerie;
        this.siguiente=null;
    }
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
    
    public Equipo getSiguiente() {
        return siguiente;
    }
 

    
}
