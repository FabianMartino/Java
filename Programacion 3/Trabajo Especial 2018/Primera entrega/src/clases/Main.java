package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author
 * 	González, Fernanda Magali
 *	Martino Martinez, Fabián 
 *
 */
public class Main {

	public static void main(String[] args) {

		String csvFile = "datasets/dataset1.csv";
        String line = "";
        String separador = ",";
        String sepLibro = " ";
        String salida = "datasets/salida.csv";
        Coleccion C = new Coleccion();
        Indice I = new Indice();

        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();    //Saltea la primer linea
            while ((line = br.readLine()) != null) {

                String[] libros = line.split(separador);

                // ---------------------------------------------
                int i = 0;
                while (i < libros.length) {
                	String titulo = libros[i];
                	String autor = libros[i+1];
                	int paginas = Integer.parseInt(libros[i+2]);
                	String[] generos = libros[i+3].split(sepLibro);
                	Libro nuevo = new Libro(titulo,autor,paginas,generos);
                		for(int j = 0; j<generos.length;j++) {
                			if(I.getGenero()==" ") {
                        		I = new Indice(generos[j], nuevo);
                        	}
                			else {                													
	                			Indice tmp = I.buscarGenero(generos[j]);
	                			if(tmp != null) {
	                				tmp.addLibros(nuevo);
	                			}
	                			else {
	                				tmp = new Indice(generos[j], nuevo);
	                				tmp.setSig(I);
	                				I = tmp;
                			}
                		}
                	}
                	C.agregarLibro(nuevo);
                	i=i+4;
                }
                // ---------------------------------------------

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
        BufferedWriter bw = null;
		try {
			File file = new File(salida);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			// Escribo la primer linea del archivo
			String contenidoLinea1 = "Usuario1;Tiempo1";
			bw.write(contenidoLinea1);
			bw.newLine();

			// Escribo la segunda linea del archivo
			String contenidoLinea2 = "Usuario2;Tiempo2";
			bw.write(contenidoLinea2);
			bw.newLine();
			
			/*
			 *
			 * ... 
			 * 
			*

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}**/

	}

}
