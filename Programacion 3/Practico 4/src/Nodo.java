
public class Nodo {
	private String elem;
	private int valor;
	private int peso;
	private int cantidad;
	private Nodo sig;
 
	public Nodo(){
		elem = null;
		sig = null;
		valor = 0;
		peso = 0;
		cantidad = 0;
	}
	public Nodo(String elemento, Nodo siguiente, int Valor, int Peso, int Cantidad){
		elem = elemento;
		sig = siguiente;
		valor = Valor;
		peso = Peso;
		cantidad = Cantidad;
	}
	public String getElemento(){
		return elem;
	}
	public int getValor(){
		return valor;
	}
	public int getPeso(){
		return peso;
	}
	public int getCantidad(){
		return cantidad;
	}
	public Nodo getSiguiente(){
		return sig;
	}
	public void setElemento(String elemento){
		elem = elemento;
	}
	public void setValor(int Valor){
		valor = Valor;
	}
	public void setPeso(int Peso){
		peso = Peso;
	}
	public void setCantidad(int Cantidad){
		cantidad = Cantidad;
	}
	public void setSiguiente (Nodo siguiente){
		sig = siguiente;
	}
}

