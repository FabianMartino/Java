package TPE;


import java.util.ArrayList;

public abstract class Grafo{
	
	protected int numVertices, numArcos;
	protected ArrayList<ArrayList<Persona>> adyacentes;
	
	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.numArcos = 0;
		this.adyacentes = new ArrayList<ArrayList<Persona>>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			adyacentes.add(new ArrayList<Persona>());
		}
	}
	
		
	public abstract int numVertices();
	public abstract int numArcos();
	public abstract boolean existeArco(String i, String j);
	public abstract void insertarArco(Persona i, Persona j);
	public abstract void insertarVertice(ArrayList<Persona> a);
	public abstract ArrayList<Persona> adyacentesDe(String i);
	

}


