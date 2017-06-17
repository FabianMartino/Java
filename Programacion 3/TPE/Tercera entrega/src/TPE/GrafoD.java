package TPE;

import java.util.ArrayList;

public class GrafoD extends Grafo{
	private String[] direcciones;
	
	public GrafoD(int numVertices) {
		super( numVertices);
		direcciones= new String[500000];
	}
	
	public int numVertices(){
		return numVertices;
	}
	
	public int numArcos(){
		return numArcos;
	}
	
	public int buscarPosicion(String nombre){
		for(int i=0;i<direcciones.length;i++){
			if(direcciones[i]==nombre){
				return i;
			}
		}
		 return -1;
	}
	
	public boolean existeArco(String i, String j){
		ArrayList<Persona> vecinos=this.adyacentesDe(i); 
		for (int v=0;v< vecinos.size();v++){
			if (vecinos.get(v).getNombre() == j){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Persona> adyacentesDe(String i) {
		int k= buscarPosicion(i);
		return adyacentes.get(k);
	}
	
	public void insertarVertice(ArrayList<Persona> a) {
		ArrayList<Persona> ady = a;
		adyacentes.add(ady);
	}

	
	public void insertarArco(Persona i, Persona j){
		int k= j.getId();
		adyacentes.get(k).add(j);
	}
	
	public String imprimirAdyacentes(int i){
		ArrayList<Persona> lista = adyacentes.get(i);
		String s = "";
		for (Persona adyacente : lista) {
			s+= adyacente.toString()+" ";
		}
		return s;
	}
}
