package Planetas;

import Recursos.Lava;
import Recursos.NucleoEnergetico;
import Recursos.Obsidiana;
import Recursos.Recurso;

public class PlanetaVolcanico extends Planeta {

    public PlanetaVolcanico() {
        super("Planeta Volcánico");
    }

    @Override
    public Recurso minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 50) {
            return new Lava();
        } else if (probabilidad <= 80) {
            return new Obsidiana();
        } else {
            return new NucleoEnergetico();
        }
    }
}