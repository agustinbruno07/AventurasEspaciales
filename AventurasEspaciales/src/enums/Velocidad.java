package enums;

public enum Velocidad {
    Alta(20), Media(40), Baja(60);

    private int probabilidadPeligro;

    Velocidad(int probabilidadPeligro) {
        this.probabilidadPeligro = probabilidadPeligro;
    }

    public int getProbabilidadPeligro() {
        return probabilidadPeligro;
    }
}