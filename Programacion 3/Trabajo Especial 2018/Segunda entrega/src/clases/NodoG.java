package clases;

public class NodoG {
	private String elemento;
	private Lista adyacentes;
	
	public NodoG() {
		this.elemento = "";
		this.adyacentes = new Lista();
	}
	public NodoG(String E) {
		this.elemento = E;
		this.adyacentes = new Lista();
	}
	public Lista getAdyacentes() {
		return adyacentes;
	}
	public void insertarAdyacente(int destino) {
		adyacentes.agregarUltimo(destino);
	}
	public void setAdyacentes(Lista adyacentes) {
		this.adyacentes = adyacentes;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}	
}
