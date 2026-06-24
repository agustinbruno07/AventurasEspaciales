package Modelo;
import Recursos.Recurso;
import Utilidades.Salida;
import enums.*;

import java.util.ArrayList;

public class Nave {

    private String nombre;
    private Velocidad velocidad;
    private int capacidadMaximaCarga;
    private int vida;
    private int cargaOcupada;
    private ArrayList<Recurso> bodega;

    public Nave(String nombre, Velocidad velocidad, int capacidadMaximaCarga) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.capacidadMaximaCarga = capacidadMaximaCarga;
        this.vida = 100;
        this.cargaOcupada = 0;
        this.bodega = new ArrayList<>();
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

    public boolean puedeGuardar(Recurso recurso){return cargaOcupada + recurso.getPeso() <= capacidadMaximaCarga;}

    public boolean agregarRecurso(Recurso recurso) {
        if (puedeGuardar(recurso)) {
            bodega.add(recurso);
            cargaOcupada += recurso.getPeso();
            return true;
        }
        return false;
    }

    public Recurso retirarRecurso(int indice) {
        if (indice >= 0 && indice < bodega.size()) {
            Recurso removido = bodega.remove(indice);
            cargaOcupada -= removido.getPeso();
            return removido;
        }
        return null;
    }

    public ArrayList<Recurso> vaciarBodega() {
        ArrayList<Recurso> copia = new ArrayList<>(bodega);
        bodega.clear();
        cargaOcupada = 0;
        return copia;
    }

    public String mostrarBodega() {
        if (bodega.isEmpty()) {
            return "La bodega esta vacia.";
        }

        String resultado = "Bodega:\n";
        for (int i = 0; i < bodega.size(); i++) {
            Recurso r = bodega.get(i);
            resultado += i + " - " + r.getNombre() + " (" + r.getPeso() + " t, " + r.getValor() + " cr)\n";
        }
        resultado += "Carga total: " + cargaOcupada + "/" + capacidadMaximaCarga + " t";
        return resultado;
    }

    public ArrayList<Recurso> getBodega() {
        return bodega;
    }

}