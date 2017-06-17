package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tpe.ArregloU;
import tpe.NodoG;


/**
 * Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva
 * el camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponer que
 * el grafo de entrada es acíclico.
 *
 */
public class Main {

	public static void main(String[] args) {
		GrafoD g = new GrafoD(5);
		String csvFile = "datasets/dataset_500000.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();
             while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                String id= items[0];
                	for (int i = 1; i < items.length; i++) {
                		g.insertarArco(id,items[i]);
					}
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
//		g.insertarArco(0, 1);
//		g.insertarArco(1, 2);
//		g.insertarArco(2, 3);
//		g.insertarArco(3, 4);
//		g.insertarArco(4, 2);
//		CaminoSimple c= new CaminoSimple();
//		System.out.print(c.DFS(g,4,1));
//		

	}

}
