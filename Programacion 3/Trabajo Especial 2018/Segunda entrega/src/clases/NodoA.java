package clases;

public class NodoA {
	private NodoG desde;
	private NodoG hasta;
	private int valor;
	
	public NodoA(NodoG d, NodoG h) {
		this.desde = d;
		this.hasta = h;
		this.valor = 1;
	}
	public NodoG getDesde() {
		return desde;
	}
	public void setDesde(NodoG desde) {
		this.desde = desde;
	}
	public NodoG getHasta() {
		return hasta;
	}
	public void setHasta(NodoG hasta) {
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
}
