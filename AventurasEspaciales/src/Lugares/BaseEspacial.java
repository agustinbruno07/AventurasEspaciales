
package Lugares;

import Modelo.Jugador;
import Modelo.Nave;
import Recursos.Recurso;
import Utilidades.Entrada;
import Planetas.*;
import Utilidades.Salida;

import java.util.ArrayList;
import java.util.Random;

import Misiones.Mision;
import Misiones.RequisitoMision;

public class BaseEspacial {

    private Jugador jugador;
    private Entrada entrada;
    private boolean salir;
    private ArrayList<Mision> misiones;
    
    public BaseEspacial(Jugador jugador, Entrada entrada) {
        this.jugador = jugador;
        this.entrada = entrada;
        this.salir = false;
        this.misiones = new ArrayList<>();
        cargarMisiones();
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

    private void cargarMisiones() {
    	
    	ArrayList<RequisitoMision> req1 = new ArrayList<>();
    	req1.add(new RequisitoMision("Mineral comun", 3));
    	req1.add(new RequisitoMision("Cristal", 1));
    	
    	ArrayList<RequisitoMision> req2 = new ArrayList<>();
    	req2.add(new RequisitoMision("Gases", 2));
    	req2.add(new RequisitoMision("Cristal", 1));
    	
    	
    	ArrayList<RequisitoMision> req3 = new ArrayList<>();
    	req3.add(new RequisitoMision("Nucleo energético", 1));
    	req3.add(new RequisitoMision("Obsidianas", 2));
    	
    	misiones.add(new Mision("Reparacion del casco exterior", req1, 120));
    	misiones.add(new Mision("Estabilizacion del reactor", req2, 170));
    	misiones.add(new Mision("Nucleo de energía principal", req3, 170));
    	
    	
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
        int energiaNecesaria = (int)(Math.random() * 16) + 10;

        Salida.imprimir("Minar requiere " + energiaNecesaria + "% de energia");

        if (!jugador.tieneEnergia(energiaNecesaria)) {
            Salida.imprimir("No tenes energia suficiente para minar");
            Salida.imprimir("Debes volver a la base para descansar");
            return;
        }

        jugador.restarEnergia(energiaNecesaria);

        Recurso recursoEncontrado = planetaActual.minar();
        Nave nave = jugador.getNaveElegida();

        if (nave.agregarRecurso(recursoEncontrado)) {
            Salida.imprimir("Minaste en: " + planetaActual.getNombre());
            Salida.imprimir("Recurso encontrado: " + recursoEncontrado.getNombre());
        } else {
            Salida.imprimir("No hay espacio suficiente en la bodega");
            Salida.imprimir("El recurso se perdio");
        }

        Salida.imprimir("Energia restante: " + jugador.getEnergia() + "%");
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
        Nave nave = jugador.getNaveElegida();
        Salida.imprimir(nave.mostrarBodega());
    }

    private void venderRecursos() {
        Nave nave = jugador.getNaveElegida();
        if (nave.getBodega().isEmpty()) {
            Salida.imprimir("La bodega está vacía, no hay nada que vender.");
            return;
        }

        Salida.imprimir("===== VENDER RECURSOS =====");
        Salida.imprimir(nave.mostrarBodega());
        Salida.imprimir("1. Vender un recurso específico");
        Salida.imprimir("2. Vender todos los recursos");
        Salida.imprimir("3. Cancelar");

        int opcion = entrada.ingresarEntero(1, 3);
        switch (opcion) {
            case 1:
                venderRecursoEspecifico(nave);
                break;
            case 2:
                venderTodosLosRecursos(nave);
                break;
            case 3:
                Salida.imprimir("Venta cancelada.");
                break;
        }

    }

    private void verMisionesDisponibles() {
        boolean volverBase = false;
        while (!volverBase) {
            Salida.imprimir("===== MISIONES DISPONIBLES =====");
            Salida.imprimir("1. Reparación del casco exterior");
            Salida.imprimir("2. Estabilización del reactor");
            Salida.imprimir("3. Núcleo de energía principal");
            Salida.imprimir("4. Volver a la base");

            int opcMision = entrada.ingresarEntero(1, 4);

            switch (opcMision) {
                case 1:
                case 2:
                case 3:
                    Salida.imprimir(misiones.get(opcMision - 1).mostrarInfo());
                    break;
                case 4:
                    volverBase = true;
                    Salida.imprimir("Volviendo a la base espacial...");
                    break;
            }
        }
    }
    

    private void entregarRecursosParaMision() {
        Salida.imprimir("===== ENTREGAR RECURSOS PARA MISION =====");
        Salida.imprimir("1. Reparación del casco exterior");
        Salida.imprimir("2. Estabilización del reactor");
        Salida.imprimir("3. Núcleo de energía principal");
        Salida.imprimir("4. Cancelar");

        int opcMision = entrada.ingresarEntero(1, 4);

        switch (opcMision) {
            case 1:
            case 2:
            case 3:
                Mision mision = misiones.get(opcMision - 1);
                if (mision.getCompletada()) {
                    Salida.imprimir("Esta mision ya fue completada.");
                } else {
                    entregarRecursos(mision);
                }
                break;
            case 4:
                Salida.imprimir("Cancelado.");
                break;
        }
    }
    
    private void entregarRecursos(Mision mision) {
        Nave nave = jugador.getNaveElegida();

        if (!tieneLosRecursos(nave, mision)) {
            Salida.imprimir("No tenes los recursos necesarios para completar esta mision.");
            return;
        }

        for (RequisitoMision req : mision.getRequisitos()) {
            for (int i = 0; i < req.getCantidad(); i++) {
                nave.retirarRecursoPorNombre(req.getNombreRecurso());
            }
        }

        mision.setCompletada(true);
        jugador.agregarCreditos(mision.getRecompensa());
        Salida.imprimir("Mision completada! Recibiste " + mision.getRecompensa() + " creditos.");
        Salida.imprimir("Creditos actuales: " + jugador.getCreditos());
    }

	private boolean tieneLosRecursos(Nave nave, Mision mision) {
        for (RequisitoMision req : mision.getRequisitos()) {
            int cantidadEnBodega = 0;
            for (Recurso r : nave.getBodega()) {
                if (r.getNombre().equalsIgnoreCase(req.getNombreRecurso())) {
                    cantidadEnBodega++;
                }
            }
            if (cantidadEnBodega < req.getCantidad()) {
                return false;
            }
        }
        return true;
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

    private void venderRecursoEspecifico(Nave nave) {
        int maxIndice = nave.getBodega().size() - 1;
        Salida.imprimir("Ingrese el número del recurso a vender (0 - " + maxIndice + "):");
        int indice = entrada.ingresarEntero(0, maxIndice);

        Recurso vendido = nave.retirarRecurso(indice);
        if (vendido != null) {
            jugador.agregarCreditos(vendido.getValor());
            Salida.imprimir("Vendido: " + vendido.getNombre() + " por " + vendido.getValor() + " créditos.");
            Salida.imprimir("Créditos actuales: " + jugador.getCreditos());
     } else {
            Salida.imprimir("Error al vender el recurso.");
        }
    }

    private void venderTodosLosRecursos(Nave nave) {
        int total = 0;
        for (Recurso r : nave.getBodega()) {
            total += r.getValor();
        }
        nave.vaciarBodega();
        jugador.agregarCreditos(total);
        Salida.imprimir("Vendidos todos los recursos. Obtuviste " + total + " créditos.");
        Salida.imprimir("Créditos actuales: " + jugador.getCreditos());
    }
}
