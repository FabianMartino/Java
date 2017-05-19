package tpe;

public class NodoU {

	private int ID;
	private NodoU sig;
	private NodoG gustos;

	public NodoU(){
		ID = -1;
		sig = null;
		gustos = null;
	}
	public NodoU(int elemento, NodoU siguiente, NodoG LGustos){
		ID = elemento;
		sig = siguiente;
		gustos = LGustos;
	}
	public int getElemento(){
		return ID;
	}
	public NodoU getSiguiente(){
		return sig;
	}
	public void setElemento(int elemento){
		ID = elemento;
	}
	public void setSiguiente (NodoU siguiente){
		sig = siguiente;
	}
	public NodoG getGustos(){
		return gustos;
	}
	public void setGustos(NodoG LGustos){
		gustos = LGustos;
	}
}