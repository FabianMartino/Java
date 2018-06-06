package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author
 * 	González, Fernanda Magali
 *	Martino Martinez, Fabián 
 *
 */


public class Main {

	
	private static Scanner scan;

	public static void main(String[] args) {
//		GrafoD g = new GrafoD();
//		g.insertarVertice("A");
//		g.insertarVertice("B");
//		g.insertarVertice("C");
//		g.insertarVertice("D");
//		g.insertarVertice("E");
//		
//		g.insertarArco("A", "B");
//		g.insertarArco("A", "C");
//		g.insertarArco("A", "D");
//		g.insertarArco("D", "B");
//		


		String csvFile = "datasets/datasetbusqueda4.csv";
        String line = "";
        String separador = ",";
        GrafoD g = new GrafoD();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();    //Saltea la primer linea
            while ((line = br.readLine()) != null) {

                String[] busqueda = line.split(separador);

                // ---------------------------------------------
                int i = 0;
                String[] generos = new String[busqueda.length];
                while (i < busqueda.length) {
                	generos[i] = busqueda[i];
                	i++;
                }
            	g.buscar(generos);

                // ---------------------------------------------

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.imprimirAdyacentes("");
			int valorMenu = -11;
			while(valorMenu != 0) {
				System.out.println("ingrese una de las siguentes opciones:");
				System.out.println("1.buscar los n elemntos con mas busquedas despues de un genero");
				System.out.println("2.buscar todos los generos que fueron buscados despues de un genero");
				System.out.println("3.devolver un subgrafo afin desde un genero dado");
				System.out.println("0.salir");
			    scan = new Scanner(System.in);
			    valorMenu = scan.nextInt();
				String genero = "";
				switch (valorMenu) {
				case 1:
					System.out.println("ingrese un genero");
					scan = new Scanner(System.in);
					genero=scan.next();
					System.out.println("ingrese la cantidad maxima de generos para devolver");
					int cantidad = 0;
					scan = new Scanner(System.in);
					cantidad = scan.nextInt();
			        ArrayList<String> porCantidad = g.buscadosDespuesDe(cantidad, genero);
				    for (int i = 0; i < porCantidad.size(); i++) {
					   	System.out.println(porCantidad.get(i));
					}
				    System.out.println();
					break;
				case 2:
					System.out.println("ingrese un genero");
					scan = new Scanner(System.in);
					genero=scan.next();
			        ArrayList<String> todos = g.todosDespuesDe(genero);
			        for (int i = 0; i < todos.size(); i++) {
				      	System.out.println(todos.get(i));
				    }
			        
					break;
				case 3:
					System.out.println("ingrese un genero");
					scan = new Scanner(System.in);
					genero=scan.next();
					GrafoD resultante = g.generarVinculados("informática");
					String[] tmp = resultante.imprimir();
					for (int i = 0; i < tmp.length; i++) {
						System.out.println(tmp[i]);
					}
					break;
				case 0:
					valorMenu=0;
					break;
				default:
					break;
				}
			}
	}
}

//
//}