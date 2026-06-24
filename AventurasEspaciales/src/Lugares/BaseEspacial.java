
package Lugares;

import Modelo.Jugador;
import Modelo.Nave;
import Utilidades.Entrada;
import Planetas.*;
import Utilidades.Salida;

public class BaseEspacial {

    private Jugador jugador;
    private Entrada entrada;
    private boolean salir;

    public BaseEspacial(Jugador jugador, Entrada entrada) {
        this.jugador = jugador;
        this.entrada = entrada;
        this.salir = false;
    }

    public void iniciar() {
        while (!salir) {
            mostrarMenuBase();
            int opcion = entrada.ingresarEntero(1, 8);
            ejecutarOpcion(opcion);
        }
    }

    private void mostrarMenuBase() {

        Salida.imprimir("===== BASE ESPACIAL =====");
        Salida.imprimir("1. Viajar a un planeta");
        Salida.imprimir("2. Ver bodega de carga");
        Salida.imprimir("3. Vender recursos");
        Salida.imprimir("4. Ver misiones disponibles");
        Salida.imprimir("5. Entregar recursos para una misión");
        Salida.imprimir("6. Reparar nave");
        Salida.imprimir("7. Descansar");
        Salida.imprimir("8. Salir del juego");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                viajarAPlaneta();
                break;

            case 2:
                verBodega();
                break;

            case 3:
                venderRecursos();
                break;

            case 4:
                verMisionesDisponibles();
                break;

            case 5:
                entregarRecursosParaMision();
                break;

            case 6:
                repararNave();
                break;

            case 7:
                descansar();
                break;

            case 8:
                salirDelJuego();
                break;

            default:
                Salida.imprimir("ES DEL 1 AL 8 BOBO");
                break;
        }
    }

    private void viajarAPlaneta() {

        Salida.imprimir("Elija un planeta:");
        Salida.imprimir("1. Planeta Rocoso");
        Salida.imprimir("2. Planeta Gaseoso");
        Salida.imprimir("3. Planeta Volcánico");

        int opcionPlaneta = entrada.ingresarEntero(1, 3);

        Planeta planetaActual = elegirPlaneta(opcionPlaneta);

        Salida.imprimir("Viajaste a: " + planetaActual.getNombre());

        menuPlaneta(planetaActual);
    }
    private Planeta elegirPlaneta(int opcionPlaneta) {
        switch (opcionPlaneta) {
            case 1:
                return new PlanetaRocoso();

            case 2:
                return new PlanetaGaseoso();

            case 3:
                return new PlanetaVolcanico();

            default:
                return null;
        }
    }
    private void menuPlaneta(Planeta planetaActual) {
        boolean volverBase = false;

        while (!volverBase) {

            Salida.imprimir("===== " + planetaActual.getNombre() + " =====");
            Salida.imprimir("1. Minar");
            Salida.imprimir("2. Viajar a otro planeta");
            Salida.imprimir("3. Volver a la base");

            int opcion = entrada.ingresarEntero(1, 3);

            switch (opcion) {
                case 1:
                    minarEnPlaneta(planetaActual);
                    break;

                case 2:
                    planetaActual = viajarAOtroPlaneta();
                    Salida.imprimir("Ahora estas en: " + planetaActual.getNombre());
                    break;

                case 3:
                    volverBase = true;
                    Salida.imprimir("Volviendo a la base espacial...");
                    break;
            }
        }
    }
    private void minarEnPlaneta(Planeta planetaActual) {
        String recursoEncontrado = planetaActual.minar();


        Salida.imprimir("Minaste en: " + planetaActual.getNombre());
        Salida.imprimir("Recurso encontrado: " + recursoEncontrado);
    }
    private Planeta viajarAOtroPlaneta() {

        Salida.imprimir("Elija otro planeta:");
        Salida.imprimir("1. Planeta Rocoso");
        Salida.imprimir("2. Planeta Gaseoso");
        Salida.imprimir("3. Planeta Volcánico");

        int opcionPlaneta = entrada.ingresarEntero(1, 3);

        Planeta nuevoPlaneta = elegirPlaneta(opcionPlaneta);

        return nuevoPlaneta;
    }
    private void verBodega() {

    }

    private void venderRecursos() {

    }

    private void verMisionesDisponibles() {

    }

    private void entregarRecursosParaMision() {

    }

    private void descansar() {
        jugador.descansar();
        Salida.imprimir("El jugador descanso, Energia recuperada al 100%");
    }

    private void repararNave() {
        Nave nave = jugador.getNaveElegida();

        Salida.imprimir("Vida actual de la nave: " + nave.getVida() + "%");
        Salida.imprimir("Cada tramo de reparacion recupera 10% de vida y cuesta 25 creditos");
        Salida.imprimir("Ingrese cuantos tramos de 10% desea reparar:");

        int tramos = entrada.ingresarEntero(1, 10);

        int vidaAReparar = tramos * 10;
        int costo = tramos * 25;

        if (nave.getVida() >= 100) {
            Salida.imprimir("La nave ya tiene la vida al maximo");
            return;
        }

        if (jugador.getCreditos() < costo) {
            Salida.imprimir("No tenes creditos suficientes para reparar la nave");
            Salida.imprimir("Creditos actuales: " + jugador.getCreditos());
            Salida.imprimir("Costo de reparacion: " + costo);
            return;
        }

        if (nave.getVida() + vidaAReparar > 100) {
            Salida.imprimir("No se puede reparar por encima del 100%.");
            return;
        }

        jugador.restarCreditos(costo);
        nave.reparar(vidaAReparar);

        Salida.imprimir("Reparacion realizada correctamente.");
        Salida.imprimir("Vida actual de la nave: " + nave.getVida() + "%");
        Salida.imprimir("Creditos restantes: " + jugador.getCreditos());
    }

    private void salirDelJuego() {
        salir = true;
        Salida.imprimir("Saliendo del juego...");
    }
}
