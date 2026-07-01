package Recursos;

public class Recurso {
    private String nombre;
    private int peso;
    private int valor;

    public Recurso(String nombre, int peso, int valor){
    this.nombre = nombre;
    this.peso = peso;
    this.valor = valor;
    }

    public int getPeso() {return peso;}
    public int getValor() {return valor;}
    public String getNombre() {return nombre;}
}
