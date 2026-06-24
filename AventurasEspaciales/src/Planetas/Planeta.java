package Planetas;

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

    public String minar() {
        return "";
    }
}