package clases;

public class NodoA {
	private int hasta;
	private int valor;
	private NodoA next;
	

	public NodoA(int posDestino) {
		this.hasta = posDestino;
		this.valor = 1;
	}
	
	public int getHasta() {
		return hasta;
	}
	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public void aumentarValor() {
		this.valor++;
	}
	public NodoA getNext() {
		return next;
	}

	public void setNext(NodoA next) {
		this.next = next;
	}
}
