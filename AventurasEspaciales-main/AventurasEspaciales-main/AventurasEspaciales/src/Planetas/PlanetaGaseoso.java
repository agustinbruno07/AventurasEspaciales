package Planetas;

import Recursos.Cristal;
import Recursos.Gas;
import Recursos.Plasma;
import Recursos.Recurso;

public class PlanetaGaseoso extends Planeta {

    public PlanetaGaseoso() {
        super("Planeta Gaseoso");
    }

    @Override
    public Recurso minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 60) {
            return new Gas();
        } else if (probabilidad <= 85) {
            return new Plasma();
        } else {
            return new Cristal();
        }
    }
}