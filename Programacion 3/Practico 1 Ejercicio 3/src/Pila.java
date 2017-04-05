//en lugar de trabajar en el final de la lista decici invertirla y usar el inicio como tope
public class Pila {
	private Lista raiz;
	
	public Pila(){
		raiz = new Lista();
	}
	//agrega un elemento al principio de la raiz
	public void apilar(String elemento){
		this.raiz.agregarElemento(elemento);
	}
	//elimina el elemento al principio de la raiz
	public void desapilar(){
		this.raiz.eliminarPosicion(1);
	}
	//devuelve el valor que tiene el primer elemento de la raiz
	public String getTope(){
		if(this.getTamano()>0){
			Nodo temporal = this.raiz.getRaiz();
			return temporal.getElemento();
		}
		else{
			return "La pila esta vacia";
		}
	}
	public int getTamano(){
		return this.raiz.getCantidad();
	}
}
