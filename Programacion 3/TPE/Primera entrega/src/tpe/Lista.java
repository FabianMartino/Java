package tpe;

public class Lista{
	private NodoU raiz;
	private int cantidad;
	private NodoU ultimo;

	public Lista(){
		raiz = new NodoU();
		cantidad = 0;
		ultimo = raiz;
	}
	public boolean esVacia(){
		return raiz == null;
	}
	public int getCantidad(){
		return cantidad;
	}
	public NodoU getRaiz(){
		return raiz;
	}
	//se agrega al principio
	public void agregarElemento(int identidad, NodoG LGustos){
		if(cantidad==0){
			raiz.setElemento(identidad);
			raiz.setGustos(LGustos);
			cantidad++;
			ultimo=raiz;
		}
		else{
			NodoU temporal = new NodoU(identidad,this.raiz,LGustos);
			raiz = temporal;
			cantidad++;
		}
	}
	public void agregarUltimo(int identidad, NodoG LGustos){
		if(cantidad==0){
			raiz.setElemento(identidad);
			raiz.setGustos(LGustos);
			cantidad++;
			ultimo=raiz;
		}
		else{
			NodoU temporal = new NodoU(identidad,null,LGustos);
			ultimo.setSiguiente(temporal);
			ultimo = temporal;
			cantidad++;
		}
	}
	//recive un elemento para eliminar en la lista
	public void eliminarElemento(Integer elemento){
		if(!esVacia()){
			borrarElemento(elemento, this.raiz);
		}
	}
	//busca y elemina el elemento en la lista
	private void borrarElemento(Integer elemento, NodoU N){
		if(N != null){
			NodoU aux = N;
 			if(aux.getElemento() == elemento){
				NodoU temporal = aux.getSiguiente();
				aux.setSiguiente(null);
				N = temporal;
				cantidad--;
			}
 			else{
 				borrarElemento(elemento, aux.getSiguiente());
 			}
		}
	}
	public boolean buscarEnLista(int id){
		NodoU temporal = raiz;
		int contador = 0;
		boolean encontrado = false;
		while(contador < cantidad && !encontrado){
			if(id==temporal.getElemento()){
				return true;
			}
			temporal = temporal.getSiguiente();
			contador++;
		}
		return encontrado;
	}
}