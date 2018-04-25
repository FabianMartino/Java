package Ej;

public class ArbolB {
	protected NodoA raiz;
	protected int size;
	protected NodoA cursor;
	
	public void Arbol() {
		raiz = null;
		size = 0;
		cursor = null;
	}
	
	public Object getRaiz() {
		return raiz;
	}
	
	public boolean isEmpty() {
		if(raiz != null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean hasElement(int o) {
		cursor = raiz;
		if(buscar(o,cursor))
			return true;
		else
			return false;
	}
	
	private boolean buscar(int o,NodoA puntero) {
		if(puntero != null) {
			if(puntero.getInfo()==o) {
				return true;
			}
			boolean i = false;
			if(puntero.getIzq()!=null) {
				i = buscar(o,puntero.getIzq());
			}
			boolean d = false;
			if(puntero.getDer()!=null) {
				d = buscar(o,puntero.getDer());
			}
			if(i||d) {
				return true;
			}
			else {
				if(puntero.getInfo() == o) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void insertar(int o) {
		if(isEmpty()) {
			NodoA nuevo = new NodoA(o,null,null);
			raiz = nuevo;
		}
		else {
			cursor = raiz;
			boolean insertado = false;
			while(!insertado) {
				if(cursor.getInfo()>o) {
					if(cursor.getIzq()==null){
						NodoA nuevo = new NodoA(o,null,null);
						cursor.setIzq(nuevo);
						insertado=true;
					}
					else {
						cursor= cursor.getIzq();
					}
				}
				else {
					if(cursor.getDer()==null){
						NodoA nuevo = new NodoA(o,null,null);
						cursor.setDer(nuevo);
						insertado=true;
					}
					else {
						cursor= cursor.getDer();
					}
				}
			}
			
		}
		size++;
	}
	
	public void delete(int valor) {
		if(size > 0) {
			cursor = raiz;
			NodoA cursorAux = raiz;
			borrarCursor(valor,cursorAux);
		}
	}
	
	private void borrarCursor(int valor, NodoA pos) {
		if(pos != null) {
			if(pos.getInfo() == valor) {
				if(pos.getIzq() == null && pos.getDer() == null) {
					pos = null;
				}
				else {
					if(pos.getDer() != null) {
						cursor = pos.getDer();
						NodoA anterior = pos;
						while(cursor.getIzq() != null) {
							anterior = cursor;
							cursor = cursor.getIzq();
						}
						pos.setInfo(cursor.getInfo());
						anterior.setIzq(cursor.getDer());
					}
					else {
						if(pos.getIzq() != null) {
							cursor = pos.getIzq();
							NodoA anterior = pos;
							while(cursor.getDer() != null) {
								anterior = cursor;
								cursor = cursor.getDer();
							}
							pos.setInfo(cursor.getInfo());
							anterior.setIzq(cursor.getIzq());
						}
					}
					cursor = null;
				}
			}
			else {
					borrarCursor(valor, pos.getIzq());
					borrarCursor(valor, pos.getDer());
			}
		}
		else return;
	}
	
	public int getHeight() {
		if(size > 0) {
			cursor = raiz;
			return buscarAltura(cursor);
		}
		else return 0;
	}
	
	private int buscarAltura(NodoA pos) {
		if(pos == null) {
			return 0;
		}
		else {
			int valorIzq = 1;
			valorIzq += buscarAltura(pos.getIzq());
			int valorDer = 1;
			valorDer += buscarAltura(pos.getDer());
			if(valorIzq > valorDer) {
				return valorIzq;
			}
			else {
				return valorDer;
			}
		}
	}
}
