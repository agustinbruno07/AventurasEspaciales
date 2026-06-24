package Modelo;

public class Jugador {
    private final int energiaInicial = 100;
    private int energia;
    private final int creditosIniciales = 0;
    private int creditosEspaciales;
    private String nombre;
    private Nave naveElegida ;

    public Jugador(String nombre){
        this.energia = energiaInicial;
        this.creditosEspaciales = creditosIniciales;
        this.nombre = nombre;
    }
    public void restarCreditos(int monto){
        this.creditosEspaciales -= monto;
        if(creditosEspaciales<0) creditosEspaciales=0;
    }
    public void setNaveElegida(Nave naveElegida){
        this.naveElegida = naveElegida;
    }
    public Nave getNaveElegida(){
        return this.naveElegida;
    }
    public String getNombre(){
       return this.nombre;
    }
    public int getEnergia(){
        return this.energia;
    }
    public int getCreditos(){
        return this.creditosEspaciales;
    }

    public void descansar() {
        this.energia = energiaInicial;
    }

}
