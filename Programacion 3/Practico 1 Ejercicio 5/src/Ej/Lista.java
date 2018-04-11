package Ej;

public class Lista  {
	protected Nodo first;
	protected int size;
	protected Nodo cursor;
	protected Nodo ultimo;

	public Lista() {
		this.first = null;
		this.size = 0;
		this.cursor = null;
		this.ultimo = null;
	}
		
	public void insert(Object o) {
		Nodo tmp = new Nodo(o, null);
		tmp.setNext(first);
		first = tmp;
		this.size++;
		if(size == 1) {
			ultimo = first;
		}
	}
	
	public void agregarUltimo(Object o) {
		if(size == 0) {
			insert(o);
		}
		else {
			Nodo nuevo = new Nodo(o,null);
			ultimo.setNext(nuevo);
			size++;
			ultimo = ultimo.getNext();
		}
	}
	
	public Object extract() {
		Nodo tmp = first;
		tmp.setNext(null);
		first = first.getNext();
		size--;
		if(size == 0) {
			ultimo = null;
		}
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
			iniciarCursor();
			int t = (int) cursor.getInfo();
			if(t>(int)o) {
				insert(o);
			}
			else {
				boolean insertado = false;
				Nodo siguiente = cursor.getNext();
				while(!insertado&&cursor!=null) {
					if(siguiente == null) {
						agregarUltimo(o);
						insertado = true;
					}
					else {
						t = (int) siguiente.getInfo();
						if((int)o<t) {
							Nodo nuevo = new Nodo(o, siguiente);
							cursor.setNext(nuevo);
							insertado = true;
							size++;
						}
						else {
							cursor = cursor.getNext();
							siguiente = siguiente.getNext();
						}	
					}
				}
			}
		}
	}
	
	public void iniciarCursor() {
		cursor = first;
	}
	
	public boolean cursorHasNext() {
		if(cursor!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object cursorNext() {
		Nodo tmp = cursor;
		cursor = cursor.getNext();
		return tmp.getInfo();
	}
}
