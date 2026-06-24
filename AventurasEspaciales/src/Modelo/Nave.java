package Modelo;
import enums.*;
public class Nave {

    private String nombre;
    private Velocidad velocidad;
    private int capacidadMaximaCarga;
    private int vida;
    private int cargaOcupada;

    public Nave(String nombre, Velocidad velocidad, int capacidadMaximaCarga) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.capacidadMaximaCarga = capacidadMaximaCarga;
        this.vida = 100;
        this.cargaOcupada = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Velocidad getVelocidad() {
        return this.velocidad;
    }

    public int getCapacidadMaxima() {
        return this.capacidadMaximaCarga;
    }

    public int getVida() {
        return this.vida;
    }

    public int getCargaOcupada() {
        return this.cargaOcupada;
    }

    public void reparar(int cantidad) {
        this.vida += cantidad;

        if (this.vida > 100) {
            this.vida = 100;
        }
    }
}