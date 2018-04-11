package Ej;

public class Main {

	public static Lista combina_ordenado(Lista L1, Lista L2) {
		Lista resultado = new Lista();
		L1.iniciarCursor();
		while(L1.cursorHasNext()) {
			L2.iniciarCursor();
			int valor1 = (int) L1.cursorNext();
			boolean encontrado = false;
			while(L2.cursorHasNext()&&!encontrado) {
				int valor2 = (int) L2.cursorNext();
				if(valor1 == valor2) {
					encontrado = true;
					resultado.insertar_ordenado(valor1);
				}
			}
		}
		return resultado;
	}
	
	public static Lista combinada(Lista L1, Lista L2) {
		Lista resultado = new Lista();
		L1.iniciarCursor();
		while(L1.cursorHasNext()) {
			L2.iniciarCursor();
			int valor1 = (int) L1.cursorNext();
			boolean encontrado = false;
			while(L2.cursorHasNext()&&!encontrado) {
				int valor2 = (int) L2.cursorNext();
				if(valor1 == valor2) {
					encontrado = true;
					resultado.agregarUltimo(valor1);
				}
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		Lista L = new Lista();
		L.insert(1);
		L.insert(4);
		L.insert(3);
		L.insert(2);		
		
		Lista L2 = new Lista();
		L2.insert(1);
		L2.insert(7);
		L2.insert(3);
		L2.insert(2);
		
		Lista L3 = new Lista();
		L3.insert(1);
		L3.insert(2);
		L3.insert(3);
		L3.insert(10);		
		
		Lista L4 = new Lista();
		L4.insert(1);
		L4.insert(3);
		L4.insert(5);
		L4.insert(10);
		
		Lista desordenada = new Lista();
		desordenada = combina_ordenado(L,L2);
		desordenada.iniciarCursor();
		while(desordenada.cursorHasNext()) {
			System.out.print(desordenada.cursorNext()+"-");
		}
		
		System.out.println();
		
		Lista ordenada = new Lista();
		ordenada = combina_ordenado(L3,L4);
		ordenada.iniciarCursor();
		while(ordenada.cursorHasNext()) {
			System.out.print(ordenada.cursorNext()+"-");
		}
	}	
}