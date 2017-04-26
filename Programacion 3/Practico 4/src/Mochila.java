
public class Mochila {
	private Lista mochi;
	private int capacidad;
	
	public Mochila(int C){
		mochi = new Lista();
		capacidad = C;
	}
	public Lista getMochila(){
		return mochi;
	}
	public void llenarMochila(Lista L){
		Nodo aux = L.getRaiz();
		Nodo actual = new Nodo();
		int ganancia = 0;
		boolean encotrado = true;
		while(capacidad > 0 && encotrado){// cicla hasta que llena la mochila o no tenga elementos que pueda agregar
			encotrado = false;
			aux = L.getRaiz();
			ganancia = 0;
			for (int i = 0; i < L.getCantidad(); i++){		//recorre todos los elementos de la lista en busca del que tenga la mayor ganancia y este disponible
				if(aux.getCantidad()>0){
					if(aux.getPeso() < capacidad){
						if(ganancia < (aux.getValor()/aux.getPeso())){
							ganancia = (aux.getValor()/aux.getPeso());
							actual = aux;
							encotrado = true;
						}
					}
				}
				aux = aux.getSiguiente();
			}
			if(encotrado){
				String elemento = actual.getElemento();
				int valor = actual.getValor();
				int peso = actual.getPeso();
				int cant = 1;
				actual.setCantidad(actual.getCantidad()-1);
				capacidad -= peso;
				while(actual.getCantidad() > 0 && actual.getPeso() < capacidad){
					cant++;
					actual.setCantidad(actual.getCantidad()-1);
					capacidad -= peso;
				}
				mochi.agregarElemento(elemento, valor, peso, cant);
			}
		}
	}
}
