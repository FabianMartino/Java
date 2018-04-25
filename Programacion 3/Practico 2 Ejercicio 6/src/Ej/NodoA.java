package Ej;

public class NodoA {
	private int info;
	private NodoA izq;
	private NodoA der;
	
	public NodoA() {
		this.info = 0;
		this.izq = null;
		this.der = null;
	}
	
	public NodoA(int nuevo, NodoA izquierda, NodoA derecha) {
		this.info = nuevo;
		this.izq = izquierda;
		this.der = derecha;
	} 

	public int getInfo() {
		return info;
	}


	public NodoA getIzq() {
		return izq;
	}

	public void setIzq(NodoA izq) {
		this.izq = izq;
	}

	public NodoA getDer() {
		return der;
	}

	public void setDer(NodoA der) {
		this.der = der;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	
	

}
