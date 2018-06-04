package clases;

import java.util.ArrayList;

public class GrafoD extends Grafo{
	private int invalido; 
	
	public GrafoD() {
		super();
		invalido = -1;
	}
	
	public int numVertices(){
		return numVertices;
	}
	
	public int numArcos(){
		return numArcos;
	}

	public int buscarPosicion(String nombre){
		int pos = invalido;
		int i = 0;
		while(pos==invalido&&i<adyacentes.size()){
			if(adyacentes.get(i).getElemento().equals(nombre)){
				pos = i;
			}
			i++;
		}
		 return pos;
	}
	
	public boolean existeArco(String i, String j){
		ArrayList<NodoG> vecinos=this.adyacentesDe(i); 
		for (int v=0;v< vecinos.size();v++){
			if (vecinos.get(v).getElemento() == j){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<NodoG> adyacentesDe(String nombre) {
		ArrayList<NodoG> ady = new ArrayList<NodoG>();
		for(int i = 0;i<direcciones.size();i++) {
			if(direcciones.get(i).getDesde().getElemento().equals(nombre)) {
				ady.add(direcciones.get(i).getHasta());
			}
		}
		return ady;
	}
	
	public void insertarVertice(String nombre) {
		NodoG nuevo = new NodoG(nombre);
		adyacentes.add(nuevo);
		numVertices++;
	}

	
	public void insertarArco(String i, String j){
		int k= buscarPosicion(i);
		int z= buscarPosicion(j);
		if(z>=0&&k>=0) {
			NodoA nuevo = new NodoA(adyacentes.get(k),adyacentes.get(z));
			direcciones.add(nuevo);
			numArcos++;
		}
	}
	
	public String imprimirAdyacentes(String i){
		ArrayList<NodoG> lista = adyacentesDe(i);
		String s = "";
		for (NodoG adyacente : lista) {
			s+= adyacente.getElemento()+" ";
		}
		return s;
	}
	
	public void buscar(String[] nombres) {
		for(int i = 0;i <nombres.length;i++) {
			if(buscarPosicion(nombres[i]) == invalido) {
				insertarVertice(nombres[i]);
			}
		}
		for(int i = 0;i < nombres.length-1;i++) {
			int buscado = buscarArco(nombres[i],nombres[i+1]);
			if(buscado != invalido) {
				direcciones.get(i).aumentarValor();;
			}
			else {
				insertarArco(nombres[i],nombres[i+1]);
			}
		}
	}
	private int buscarArco(String desde, String hasta) {
		int pos = invalido;
		int i = 0;
		while(pos==invalido&&i<direcciones.size()){
			if(direcciones.get(i).getDesde().getElemento().equals(desde)&&direcciones.get(i).getHasta().getElemento().equals(hasta)){
				pos = i;
			}
			i++;
		}
		 return pos;
	}
	public ArrayList<String> buscadosDespuesDe(int cantidad,String desde) {
		ArrayList<NodoA> tmp = new ArrayList<NodoA>();
		for(int i = 0;i < direcciones.size();i++) {
			if(direcciones.get(i).getDesde().getElemento().equals(desde)) {
				tmp.add(direcciones.get(i));
			}
		}
		int max = invalido;
		ArrayList<String> resultado = new ArrayList<String>();
		for(int i = 0;i<cantidad;i++) {
			int valor = invalido;
			String genero = "";
			for (int j = 0; j < direcciones.size(); j++) {
				if(max==invalido||direcciones.get(j).getValor() <max) {
					if(valor < direcciones.get(j).getValor()) {
						valor = direcciones.get(j).getValor();
						genero = direcciones.get(j).getHasta().getElemento();
					}
				}
				max = valor;
				resultado.add(genero);
			}
		}
		return resultado;
	}
	public ArrayList<String> todosDespuesDe(String desde) {
		ArrayList<String> resultado = new ArrayList<String>();
		for(int i = 0;i < direcciones.size();i++) {
			if(direcciones.get(i).getDesde().getElemento().equals(desde)) {
				resultado.add(direcciones.get(i).getHasta().getElemento());
			}
		}
		return resultado;
	}
	
}
