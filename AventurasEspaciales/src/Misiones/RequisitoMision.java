package Misiones;

public class RequisitoMision {

    private String nombreRecurso;
    private int cantidad;
    
	public RequisitoMision(String nombreRecurso, int cantidad) {
		this.nombreRecurso = nombreRecurso;
        this.cantidad = cantidad;
	}
	
    public String getNombreRecurso() {
        return this.nombreRecurso;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    
}
