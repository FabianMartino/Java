package clases;

public class Indice {
	private String genero;
	private Libro[] libros;
	private int cantidadLibros;
	private Indice sig;
	
	public Indice() {
		this.genero = " ";
		this.cantidadLibros = 0;
		this.sig = null;
	}
	public Indice(String genero, Libro nuevo) {
		this.genero = genero;
		this.cantidadLibros = 0;
		this.libros[cantidadLibros] = nuevo;
		this.sig = null;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setLibro(Libro nuevo) {
		this.libros[0] = nuevo;
	}
	public void addLibros(Libro nuevo) {
		cantidadLibros++;
		this.libros[cantidadLibros] = nuevo;
	}
	public Indice getSig() {
		return sig;
	}
	public void setSig(Indice sig) {
		this.sig = sig;
	}
	public Indice buscarGenero(String genero) {
			return busquedaIntarna(genero,this); 
	}
	private Indice busquedaIntarna(String genero, Indice actual) {
		if(actual != null) {
			if(actual.genero == genero) {
				return actual;
			}
			else {
				return busquedaIntarna(genero,actual.sig);
			}
		}
		else {
			return null;
		}
	}
}
