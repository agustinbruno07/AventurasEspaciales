package Misiones;

import java.util.ArrayList;

public class MisionEstabilizacionReactor extends Mision {
    public MisionEstabilizacionReactor() {
        super("Estabilizacion del reactor", crearRequisitos(), 170);
    }

    private static ArrayList<RequisitoMision> crearRequisitos() {
        ArrayList<RequisitoMision> req = new ArrayList<>();
        req.add(new RequisitoMision("Gases", 2));
        req.add(new RequisitoMision("Cristal", 1));
        return req;
    }
}
