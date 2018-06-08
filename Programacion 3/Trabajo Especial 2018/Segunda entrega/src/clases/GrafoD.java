package clases;

import java.util.ArrayList;

public class GrafoD extends Grafo{
	final static int invalido = -1; 
	
	public GrafoD() {
		super();
	}

	public int buscarPosicion(String nombre){
		int pos = invalido;
		int i = 0;
		while(pos==invalido&&i<vertices.size()){
			if(vertices.get(i).getElemento().equals(nombre)){
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
		int pos = buscarPosicion(nombre);
		if(pos != invalido) {
			Lista direcciones = vertices.get(pos).getAdyacentes();
			direcciones.iniciarCursor();
			for(int i = 0;i<direcciones.size();i++) {
					ady.add(vertices.get(direcciones.cursorNext().getHasta()));
			}
		}
		return ady;
	}
	
	public void insertarVertice(String nombre) {
		if(buscarPosicion(nombre)==invalido) {
			NodoG nuevo = new NodoG(nombre);
			vertices.add(nuevo);
		}
	}

	
	public void insertarArco(String desde, String hasta){
		int i= buscarPosicion(desde);
		int j= buscarPosicion(hasta);
		if(i>=0&&j>=0) {
			if(vertices.get(i).getAdyacentes().buscar(j)==null)
			vertices.get(i).insertarAdyacente(j);
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
			int buscado = buscarPosicion(nombres[i]);
			int destino = buscarPosicion(nombres[i+1]);
			if(buscado != invalido&&destino!=invalido) {
				NodoA tmp = vertices.get(buscado).getAdyacentes().buscar(destino);
				if(tmp != null) {
					tmp.aumentarValor();
				}
				else {
					insertarArco(nombres[i],nombres[i+1]);
				}
			}
		}
	}
	public ArrayList<String> buscadosDespuesDe(int cantidad,String desde) {
		int pos = buscarPosicion(desde);
		ArrayList<String> resultado = new ArrayList<String>();
		ArrayList<NodoA> tmp = new ArrayList<NodoA>();
		if(pos != invalido) {
			Lista direcciones = vertices.get(pos).getAdyacentes();
			direcciones.iniciarCursor();
			for(int i = 0;i < direcciones.size();i++) {
				tmp.add(direcciones.cursorNext());
			}
			int max = invalido;
			for(int i = 0;i<cantidad;i++) {
				int valor = invalido;
				String genero = "";
				for (int j = 0; j < tmp.size(); j++) {
					if(max==invalido||tmp.get(j).getValor() <=max) {
						if(valor <= tmp.get(j).getValor()&&!resultado.contains(vertices.get(tmp.get(j).getHasta()).getElemento())) {
							valor = tmp.get(j).getValor();
							genero = vertices.get(tmp.get(j).getHasta()).getElemento();
						}
					}
					
				}
				if(valor>invalido) {
					max = valor;
					resultado.add(genero);
				}
			}
		}
		return resultado;
	}
	public ArrayList<String> todosDespuesDe(String desde) {
		int pos = buscarPosicion(desde);
		ArrayList<String> resultado = new ArrayList<String>();
		if(pos != invalido) {
			Lista direcciones = vertices.get(pos).getAdyacentes();
			direcciones.iniciarCursor();
			for(int i = 0;i < direcciones.size();i++) {
				resultado.add(vertices.get(direcciones.cursorNext().getHasta()).getElemento());
			}
		}
		return resultado;
	}
	public GrafoD generarVinculados(String nombre) {
		GrafoD resultado = new GrafoD();
		ArrayList<String> color = new ArrayList<String>();
		for (int i = 0; i < vertices.size(); i++) {
			color.add("blanco");
		}
		int origen = buscarPosicion(nombre);
		buscarVinculos(resultado,origen,origen,color);
		return resultado;
	}
	private void buscarVinculos(GrafoD resultado, int origen, int buscado, ArrayList<String> color) {
		if(color.get(origen).equals("blanco")) {
			color.add(origen, "gris");
			Lista ady = vertices.get(origen).getAdyacentes();
			ady.iniciarCursor();
			for (int i = 0; i < ady.size(); i++) {
				if(ady.cursorHasNext()) {
					int pos = ady.cursorNext().getHasta();
					if(pos == buscado || resultado.buscarPosicion(vertices.get(pos).getElemento())!=invalido) {
						resultado.insertarVertice(vertices.get(origen).getElemento());
						resultado.insertarVertice(vertices.get(pos).getElemento());
						resultado.insertarArco(vertices.get(origen).getElemento(), vertices.get(pos).getElemento());
					}
					else {
						buscarVinculos(resultado,pos,buscado,color);
						if(resultado.buscarPosicion(vertices.get(pos).getElemento())!=invalido) {
							resultado.insertarVertice(vertices.get(origen).getElemento());
							resultado.insertarVertice(vertices.get(pos).getElemento());
							resultado.insertarArco(vertices.get(origen).getElemento(), vertices.get(pos).getElemento());
						}
					}
				}
			}
		}
	}
	public String[] imprimir() {
		String[] resultado = new String[vertices.size()];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = vertices.get(i).getElemento();
		}
		return resultado;
	}
}
