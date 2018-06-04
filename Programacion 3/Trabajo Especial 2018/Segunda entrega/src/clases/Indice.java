package clases;

import java.util.ArrayList;

public class Indice {
	private String genero;
	private ArrayList<Libro> libros;
	private Indice sig;
	
	public Indice() {
		this.genero = " ";
		this.libros = new ArrayList<Libro>();
		this.sig = null;
	}
	public Indice(String genero, Libro nuevo, Indice siguente) {
		this.genero = genero;
		this.libros = new ArrayList<Libro>();
		this.libros.add(nuevo);
		this.sig = siguente;
	}
	public void agregarIndice(String genero, Libro libro) {
		Indice nuevo = new Indice(genero,libro,null);
		Indice tmp = this;
		while(tmp.getSig() != null) {
			tmp = tmp.getSig();
		}
		tmp.setSig(nuevo);
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public int getCantidadLibros() {
		return this.libros.size();
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void addLibros(Libro nuevo) {
		this.libros.add(nuevo);
	}
	public Indice getSig() {
		return sig;
	}
	public void setSig(Indice sig) {
		this.sig = sig;
	}
	public Indice buscarGenero(String generos) {
		Indice actual = this;
		return busquedaIntarna(generos,actual); 
	}
	private Indice busquedaIntarna(String generos, Indice actual) {
		if(actual != null) {
			if(actual.genero.equals(generos)) {
				return actual;
			}
			else {
				return busquedaIntarna(generos,actual.sig);
			}
		}
		else {
			return null;
		}
	}
}
