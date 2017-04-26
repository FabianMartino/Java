

public class Lista{
	private Nodo raiz;
	private int cantidad; 
 
	public Lista(){
		raiz = new Nodo();
		cantidad = 0;
	}
	public boolean esVacia(){
		return raiz == null;
	}
	public int getCantidad(){
		return cantidad;
	}
	public Nodo getRaiz(){
		return raiz;
	}
	//se agrega al principio
	public void agregarElemento(String elemento,int valor, int peso, int cant){
		Nodo temporal = new Nodo(elemento,this.raiz,valor,peso,cant);
		raiz = temporal;
		cantidad++;
	}
	//recive un elemento para eliminar en la lista
	public void eliminarElemento(String elemento){
		if(!esVacia()){
			borrarElemento(elemento, this.raiz);
		}
	}
	//busca y elemina el elemento en la lista
	public void borrarElemento(String elemento, Nodo N){
		if(N != null){
			Nodo aux = N;
 			if(aux.getElemento() == elemento){
				Nodo temporal = aux.getSiguiente();
				aux.setSiguiente(null);
				N = temporal;
				cantidad--;
			}
 			else{
 				borrarElemento(elemento, aux.getSiguiente());
 			}
		}
	}
	//verifica la posicion a eliminar y elimina si es el primer elemento
	//la primera posicion de la lista la considero la 1
	public void eliminarPosicion(int pos){
		if(pos > this.cantidad || pos < 1 ){
			return;
		}
		else{
			if(pos == 1){
				if(cantidad == 1){
					this.raiz = null;
				}
				else{
					Nodo temporal = this.raiz;
					this.raiz = temporal.getSiguiente();
					temporal.setSiguiente(null);
				}
			}
			else{
				int actual = 1;
				borrar_Posicion(pos, actual, this.raiz);	
			}
			cantidad--;
		}
	}
	//se posiciona en el elemento anterior a eliminar y lo elimina de la lista
	public void borrar_Posicion(int pos, int actual, Nodo N){
		pos++;
		if(pos > actual){
			actual++;
			borrar_Posicion(pos, actual, N.getSiguiente());
		}
		else{
			Nodo temporal = N.getSiguiente();
			N.setSiguiente(temporal.getSiguiente());
			temporal.setSiguiente(null);
		}
	}
}
