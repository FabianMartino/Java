
public class Nodo {
	private String elem;
	private Nodo sig;
 
	public Nodo(){
		elem = null;
		sig = null;
	}
	public Nodo(String elemento, Nodo siguiente){
		elem = elemento;
		sig = siguiente;
	}
	public String getElemento(){
		return elem;
	}
	public Nodo getSiguiente(){
		return sig;
	}
	public void setElemento(String elemento){
		elem = elemento;
	}
	public void setSiguiente (Nodo siguiente){
		sig = siguiente;
	}
}

