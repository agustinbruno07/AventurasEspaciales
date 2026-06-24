package Planetas;

public class PlanetaRocoso extends Planeta {

    public PlanetaRocoso() {
        super("Planeta Rocoso");
    }

    @Override
    public String minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 60) {
            return "Mineral comun";
        } else if (probabilidad <= 85) {
            return "Cristal";
        } else {
            return "Nucleo energetico";
        }
    }
}