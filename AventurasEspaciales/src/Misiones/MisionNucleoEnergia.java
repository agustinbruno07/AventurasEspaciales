package Misiones;

import java.util.ArrayList;

public class MisionNucleoEnergia extends Mision {
    public MisionNucleoEnergia() {
        super("Nucleo de energia principal", crearRequisitos(), 170);
    }

    private static ArrayList<RequisitoMision> crearRequisitos() {
        ArrayList<RequisitoMision> req = new ArrayList<>();
        req.add(new RequisitoMision("Nucleo energetico", 1));
        req.add(new RequisitoMision("Obsidianas", 2));
        return req;
    }
}
