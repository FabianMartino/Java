package clases;


import java.util.ArrayList;

public abstract class Grafo{
	
	protected ArrayList<NodoG> vertices;

	
	public Grafo() {
		this.vertices = new ArrayList<NodoG>();

	}
	
		
	public abstract boolean existeArco(String i, String j);
	public abstract void insertarArco(String i, String j);
	public abstract void insertarVertice(String a);
	public abstract ArrayList<NodoG> adyacentesDe(String i);
	

}


