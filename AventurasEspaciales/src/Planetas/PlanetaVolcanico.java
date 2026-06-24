package Planetas;

public class PlanetaVolcanico extends Planeta {

    public PlanetaVolcanico() {
        super("Planeta Volcánico");
    }

    @Override
    public String minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 50) {
            return "Lava";
        } else if (probabilidad <= 80) {
            return "Obsidiana";
        } else {
            return "Nucleo energetico";
        }
    }
}