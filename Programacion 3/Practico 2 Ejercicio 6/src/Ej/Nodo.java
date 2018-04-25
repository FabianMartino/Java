package Ej;

public class Nodo {
	private Object info;
	private Nodo next;
	
	public Nodo() {
		this.info = null;
		this.next = null;
	}
	
	public Nodo(Object nuevo, Nodo sig) {
		this.info = nuevo;
		this.next = sig;
	} 

	public Object getInfo() {
		return info;
	}

	public Nodo getNext() {
		return next;
	}

	public void setInfo(Object info) {
		this.info = info;
	}
	
	public void setNext(Nodo next) {
		this.next = next;
	}
	
	
}
