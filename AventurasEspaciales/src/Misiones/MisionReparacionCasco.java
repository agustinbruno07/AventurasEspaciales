package Misiones;

import java.util.ArrayList;

public class MisionReparacionCasco extends Mision {
    public MisionReparacionCasco() {
        super("Reparacion del casco exterior", crearRequisitos(), 120);
    }

    private static ArrayList<RequisitoMision> crearRequisitos() {
        ArrayList<RequisitoMision> req = new ArrayList<>();
        req.add(new RequisitoMision("Mineral comun", 3));
        req.add(new RequisitoMision("Cristal", 1));
        return req;
    }
}