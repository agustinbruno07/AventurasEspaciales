package Misiones;

import java.util.ArrayList;

import Recursos.Recurso;
import Utilidades.Salida;

public class Mision {
	
    private String nombre;
	private ArrayList<RequisitoMision> requisitos;
	private int recompensa;
	private boolean completada;

	public  Mision(String nombre, ArrayList<RequisitoMision> requisitos, int recompensa) {
        this.nombre = nombre;
        this.requisitos = requisitos;
        this.recompensa = recompensa;
        this.completada = false;
    }
	
	public String mostrarInfo() {
		String info = "Mision: " + nombre + "\n";
		info += "Recompensa: " + recompensa + "\n";
		if(completada) {
			info += "Estado: completada \n";
		}else {
			info += "Estado: incompleta \n";
		}
		info += "Requisitos requeridos:\n";
		
		for(int i = 0; i < requisitos.size(); i++) {
			RequisitoMision r = requisitos.get(i);
		    info += "  - " + r.getNombreRecurso() + " x" + r.getCantidad() + "\n";
		}
		
		return info;
	}
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<RequisitoMision> getRequisitos() {
		return requisitos;
	}
	public int getRecompensa() {
		return recompensa;
	}
	public boolean getCompletada() {
		return completada;
	}
	public boolean setCompletada(boolean completa) {
		return completada = completa;
	}
	
	
	
}
