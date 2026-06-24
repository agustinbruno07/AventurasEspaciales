package Planetas;

public class PlanetaGaseoso extends Planeta {

    public PlanetaGaseoso() {
        super("Planeta Gaseoso");
    }

    @Override
    public String minar() {
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 60) {
            return "Gas";
        } else if (probabilidad <= 85) {
            return "Plasma";
        } else {
            return "Cristal";
        }
    }
}