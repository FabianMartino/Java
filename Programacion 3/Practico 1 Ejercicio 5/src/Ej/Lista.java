package Ej;

public class Lista  {
	protected Nodo first;
	protected int size;

	public Lista() {
		this.first = null;
		this.size = 0;
	}
	public void insert(Object o) {
		Nodo tmp = new Nodo(o, null);
		tmp.setNext(first);
		first = tmp;
		this.size++;
		}
	
	public Object extract() {
		Nodo tmp = first;
		tmp.setNext(null);
		first = first.getNext();
		size--;
		return tmp.getInfo();
	}
	
	public Object print(int pos) {
		if(pos<=size) {
			Nodo tmp = first;
			for(int i=0;i<pos;i++) {
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		else {
			return "error";
		}
	}
	
	public boolean isEmpty(){
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size () {
		return size;
	}
	
	public String maximo() {
		int pos = 0;
		Nodo mayor = first;
		Nodo tmp = first;
		for(int i = 0;i<size-1;i++) {
			tmp = tmp.getNext();
			int m = (int) mayor.getInfo();
			int t = (int) tmp.getInfo();
			System.out.println(m+" "+t);
			if(m<t) {
				pos = i+1;
				mayor = tmp;
			}
		}
		return "El valor maximo es "+mayor.getInfo()+" en la posicion "+pos;
	}
	
	public void insertar_ordenado(Object o) {
		if(size == 0) {
			insert(o);
		}
		else {
			Nodo tmp = this.first;
			int t = (int) tmp.getInfo();
			if(t>(int)o) {
				insert(o);
			}
			else {
				boolean insertado = false;
				int pos = 0;
				Nodo siguiente = tmp.getNext();
				while(!insertado&&pos<size) {
					t = (int) siguiente.getInfo();
					if((int)o<t) {
						Nodo nuevo = new Nodo(o, siguiente);
						tmp.setNext(nuevo);
						insertado = true;
						size++;
					}
					else {
						tmp = tmp.getNext();
						siguiente = siguiente.getNext();
					}
				}
			}
		}
	}
	
	public Lista combina_ordenado(Lista L) {
		Lista resultado = new Lista();
		Nodo tmp = first;
		Nodo tmpL = L.first;
		for(int i = 0;i<size;i++) {
			int valor1 = (int)tmp.getInfo();
			int valor2 = (int)tmpL.getInfo();
			int count = 0;
			while(L.size>count&&valor1!=valor2) {
				valor2 = (int) tmpL.getInfo();
				tmpL = tmpL.getNext();
				count++;
			}
			if(count<=L.size&&valor1==valor2) {
				resultado.insertar_ordenado(tmp.getInfo());
			}
			tmp = tmp.getNext();
			tmpL = L.first;
		}
		return resultado;
	}
	
	public Lista combinada(Lista L) {
		Lista resultado = new Lista();
		Nodo tmp = first;
		Nodo tmpL = L.first;
		for(int i = 0;i<size;i++) {
			int valor1 = (int)tmp.getInfo();
			int valor2 = (int)tmpL.getInfo();
			int count = 0;
			while(L.size>count&&valor1!=valor2) {
				valor2 = (int) tmpL.getInfo();
				tmpL = tmpL.getNext();
				count++;
			}
			if(count<=L.size&&valor1==valor2) {
				resultado.insert(tmp.getInfo());
			}
			tmp = tmp.getNext();
			tmpL = L.first;
		}
		return resultado;
	}
}
