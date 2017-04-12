//Usando el metodo por recursion se llega al stack overflow debido al constante llamado a si misma.
//
public class Prueba {
	public static void main (String[] args) throws java.lang.Exception	{
		int vertices = 100;// determina el tamaño de la matriz
		GrafoD G = new GrafoD(vertices);
		boolean[] adyacentes = new boolean[vertices];
		for(int i = 0; i < vertices; i++){
			for(int j = 0; j < vertices; j++){
				adyacentes[j]=((Math.random() < 0.5));	
				G.agregarAdyacentes(i, adyacentes);
				System.out.print(G.getValor(i, j)+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Los ciclos son:");
		System.out.println(G.ciclosRecursivo(0)+".");//imprime usando recursion
		System.out.println(G.ciclosIterativo()+".");//imprime por iteracion
	}
}
