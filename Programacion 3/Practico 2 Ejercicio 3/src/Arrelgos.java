//para un arreglo de tamaño 1000 el ordenamiento por burbujeo demora al rededor de 30000000 nanosegundos
//para el mismo arreglo usando el metodo de quicksort tiene un promedio de 22000000 nano segundos pero en el peor de los casos mantiene unos valores similares al metodo de burbujeo
//utilizo la funcion long para calcular el tiempo de ejecucion
public class Arrelgos {
	public static void main (String[] args) throws java.lang.Exception	{
		long startTime = System.nanoTime();
		Ordenador O = new Ordenador(1000);//el valor en Ordenador es el tamaño del arreglo si se desea puede cambiarse el valor para realizar puebas con un arreglo de distintas dimenciones
		for (int i = 0; i < O.getTamano(); i++){
			O.agregar(i, (int) (Math.random() * 10 + 1));	//utilizo esta funcion para generar valores random los cuales son ingresados en el arreglo
		}
		for (int j = 0; j < O.getTamano(); j++){
			System.out.print(O.getValor(j));
		}
		//O.burbujeo();
		O.quicksort(0,O.getTamano()-1);
		System.out.println();
		for (int j = 0; j < O.getTamano(); j++){
			System.out.print(O.getValor(j));
		}
		System.out.println();
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
		O.agregar(-2, 10);
		System.out.println(O.getValor(-3));
	}
}

