package clases;


import java.util.ArrayList;

public abstract class Grafo{
	
	protected int numVertices, numArcos;
	protected ArrayList<NodoG> adyacentes;
	protected ArrayList<NodoA> direcciones;

	
	public Grafo() {
		this.numVertices = 0;
		this.numArcos = 0;
		this.adyacentes = new ArrayList<NodoG>();
		this.direcciones = new ArrayList<NodoA>();

	}
	
		
	public abstract int numVertices();
	public abstract int numArcos();
	public abstract boolean existeArco(String i, String j);
	public abstract void insertarArco(String i, String j);
	public abstract void insertarVertice(String a);
	public abstract ArrayList<NodoG> adyacentesDe(String i);
	

}


