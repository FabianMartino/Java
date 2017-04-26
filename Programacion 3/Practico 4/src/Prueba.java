
public class Prueba {
	public static void main (String[] args) throws java.lang.Exception	{
		Lista L = new Lista();
		System.out.println(L.getCantidad());
		L.agregarElemento("piedra", 1, 1, 1);
		L.agregarElemento("oro", 100, 1, 5);
		L.agregarElemento("cobre", 5, 2, 3);
		System.out.println(L.getCantidad());
		int capacidad = 7;	//capacidad de la mochila
		Mochila M = new Mochila(capacidad);
		M.llenarMochila(L);	
		System.out.println(M.getMochila().getCantidad());
		System.out.println(M.getMochila().getRaiz().getElemento());
		System.out.println(M.getMochila().getRaiz().getSiguiente().getElemento());

	}
}
