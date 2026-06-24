
import Lugares.BaseEspacial;
import Modelo.*;
import Utilidades.*;
import Naves.*;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Salida.imprimir("BIENVENIDO A AVENTURAS ESPACIALES!");
        Jugador jugador = crearJugador(entrada);
        mostrarMenuNaves();
        int opcionNave = entrada.ingresarEntero(1, 3);
        Nave naveElegida = elegirNave(opcionNave);
        jugador.setNaveElegida(naveElegida);
        mostrarDatosGenerales(jugador, naveElegida);

        BaseEspacial baseEspacial = new BaseEspacial(jugador, entrada);
        baseEspacial.iniciar();

    }
    private static void mostrarDatosGenerales(Jugador jugador, Nave naveElegida){
        Salida.imprimir("El nombre del jugador es: " + jugador.getNombre());
        Salida.imprimir("La energia Actual es:  " + jugador.getEnergia());
        Salida.imprimir("Los creditos espaciales son:" + jugador.getCreditos());
        Salida.imprimir("El nombre de la nave elegida es " + naveElegida.getNombre());
        Salida.imprimir( "La velocidad de la nave es: "+ naveElegida.getVelocidad());
        Salida.imprimir("La vida de la nave es: " + naveElegida.getVida());
        Salida.imprimir("La capacidad maxima de la nave es: " + naveElegida.getCapacidadMaxima());
        Salida.imprimir("La capacidad actualmente ocupada de la bodega es: " + naveElegida.getCargaOcupada());
    }
    private static Nave elegirNave(int opcionNave) {
        switch (opcionNave) {
            case 1:
                return new Fenix();
            case 2:
                return new Eclipse();
            case 3:
                return new Galaxian();
            default:
                return null;
        }
    }

    private static Jugador crearJugador(Entrada entrada){
        Salida.imprimir("Ingrese el nombre del jugador");
        return new Jugador(entrada.ingresarTexto());
    }
    private static void mostrarMenuNaves() {
        Salida.imprimir("Elija una nave:");
        Salida.imprimir("1. Fénix");
        Salida.imprimir("Velocidad: Alta");
        Salida.imprimir("Capacidad de carga: 50 toneladas");
        Salida.imprimir("2. Eclipse");
        Salida.imprimir("Velocidad: Media");
        Salida.imprimir("Capacidad de carga: 100 toneladas");
        Salida.imprimir("3. Galaxian");
        Salida.imprimir("Velocidad: Baja");
        Salida.imprimir("Capacidad de carga: 150 toneladas");

    }
}