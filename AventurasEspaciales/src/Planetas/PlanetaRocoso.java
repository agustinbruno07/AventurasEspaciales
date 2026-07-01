package Planetas;

import Recursos.Cristal;
import Recursos.MineralComun;
import Recursos.NucleoEnergetico;
import Recursos.Recurso;

public class PlanetaRocoso extends Planeta {

    public PlanetaRocoso() {
        super("Planeta Rocoso");
    }

    @Override
    public Recurso minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 60) {
            return new MineralComun();
        } else if (probabilidad <= 85) {
            return new Cristal();
        } else {
            return new NucleoEnergetico();
        }
    }
}