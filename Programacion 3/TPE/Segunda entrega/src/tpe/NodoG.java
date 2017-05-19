package tpe;

public class NodoG {

	private String elem;
	private NodoG sig;

	public NodoG(){
		elem = "";
		sig = null;
	}
	public NodoG(String elemento, NodoG siguiente){
		elem = elemento;
		sig = siguiente;
	}
	public String getElemento(){
		return elem;
	}
	public NodoG getSiguiente(){
		return sig;
	}
	public void setElemento(String elemento){
		elem = elemento;
	}
	public void setSiguiente (NodoG siguiente){
		sig = siguiente;
	}
	public String listar(){
		String temporal = elem;
		if(sig!=null){
			temporal+=";"+sig.listar();
			
		}
		return temporal;
	}
}
