package clases;

public class Lista  {
	protected NodoA first;
	protected int size;
	protected NodoA cursor;
	protected NodoA ultimo;

	public Lista() {
		this.first = null;
		this.size = 0;
		this.cursor = null;
		this.ultimo = null;
	}
		
	public void insert(int pos) {
		NodoA tmp = new NodoA(pos);
		tmp.setNext(first);
		first = tmp;
		this.size++;
		if(size == 1) {
			ultimo = first;
		}
	}
	
	public void agregarUltimo(int pos) {
		if(size == 0) {
			insert(pos);
		}
		else {
			NodoA nuevo = new NodoA(pos);
			ultimo.setNext(nuevo);
			size++;
			ultimo = nuevo;
		}
	}
	
	public NodoA extract() {
		NodoA tmp = first;
		first = first.getNext();
		tmp.setNext(null);
		size--;
		if(size == 0) {
			ultimo = null;
		}
		return tmp;
	}
	
	public Object print(int pos) {
		if(pos<=size) {
			NodoA tmp = first;
			for(int i=0;i<pos;i++) {
				tmp = tmp.getNext();
			}
			return tmp;
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
	
	public NodoA cursorNext() {
		NodoA tmp = cursor;
		cursor = cursor.getNext();
		return tmp;
	}
	public NodoA buscar(int buscado) {
		iniciarCursor();
		NodoA tmp = null;
		for(int i = 0;i < this.size; i++) {
			tmp = cursorNext();
			if(tmp.getHasta() == buscado) {
				return tmp;
			}
		}
		return null;
	}
}
