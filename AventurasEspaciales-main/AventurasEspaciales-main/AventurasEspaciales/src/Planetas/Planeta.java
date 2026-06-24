package Planetas;

import Recursos.Recurso;

import java.util.Random;

public class Planeta {

    protected String nombre;
    protected Random random;

    public Planeta(String nombre) {
        this.nombre = nombre;
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public Recurso minar() {
        return null;
    }
}