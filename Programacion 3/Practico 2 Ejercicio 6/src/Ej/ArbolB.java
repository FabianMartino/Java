package Ej;

public class ArbolB {
	protected NodoA raiz;
	protected int size;
	protected NodoA cursor;
	
	//complejidad O(1)
	public void Arbol() {
		raiz = null;
		size = 0;
		cursor = null;
	}
	
	//complejidad O(1)
	public Object getRaiz() {
		return raiz;
	}
	
	//complejidad O(1)
	public boolean isEmpty() {
		if(raiz != null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**Busca un elemento en el arbol y la complejidad es O(n) cuando n son los elementos del arbol
	 * @param o
	 * @return
	 */
	public boolean hasElement(int o) {
		cursor = raiz;
		if(buscar(o,cursor))
			return true;
		else
			return false;
	}
	
	/**es la funcion recursiva que es llamada por el hasElement(int) y recorre tod el arbol por lo que la complejidad es O(n)
	 * @param o
	 * @param puntero
	 * @return
	 */
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
	
	/**inserta elementos comparando si son mayor o menor a otro que ya se encuentra en el arbol por lo que si se insertan
	 * elementos de una manera espesifica se puede dar que termine con la forma de una lista por lo que la complejidad es O(n)
	 * en el peor de los casos ya que n es la cantidad de elementos
	 * @param o
	 */
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
	
	/**si el arbol tiene elementos llama a la funcion borrarCursor por lo que la complejidad temporqal es o(n)
	 * @param valor
	 */
	public void delete(int valor) {
		if(size > 0) {
			cursor = raiz;
			NodoA cursorAux = raiz;
			borrarCursor(valor,cursorAux);
		}
	}
	
	/**busca el elemento que tiene que eliminar y si este tiene hijos busca el NMI o NMD para remplazarlo,
	 * podria ser que necesite recorrer todos los nodos del arbol por lo que la complejidad
	 * es O(n) siendo n los elementos del arbol
	 * @param valor
	 * @param pos
	 */
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
	
	/**busca la altura del arbol por lo que debe recorrer todos los elementos y la compejidad es O(n)
	 * @return
	 */
	public int getHeight() {
		if(size > 0) {
			cursor = raiz;
			return buscarAltura(cursor);
		}
		else return 0;
	}
	
	/**recorre de manera recursiva el arbol contando los niveles para identificar cual es la altura de arbol
	 * por lo que es de complejidad de O(n) con n siendo la cantidad de elementos del arbol
	 * @param pos
	 * @return
	 */
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
