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
                        		I = new Indice(generos[j], nuevo, null);
                        	}
                			else {                													
	                			Indice tmp = I.buscarGenero(generos[j]);
	                			if(tmp != null) {
	                				tmp.addLibros(nuevo);
	                			}
	                			else {
	                				I.agregarIndice(generos[j], nuevo);
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

        String aBuscar = "poesía"; // se pone el genero que se quiere buscar
        Indice buscado = I.buscarGenero(aBuscar);
        if(buscado!=null) {
        	ArrayList<Libro> resultado = I.buscarGenero(aBuscar).getLibros();
        	BufferedWriter bw = null;
    		try {
    			File file = new File(salida);
    			if (!file.exists()) {
    				file.createNewFile();
    			}

    			FileWriter fw = new FileWriter(file);
    			bw = new BufferedWriter(fw);
    			
    			String contenidoLinea = "titulo";
    			bw.write(contenidoLinea);
    			bw.newLine();
    			for(int i = 0; i < resultado.size(); i++) {
    				contenidoLinea = resultado.get(i).getTitulo();
        			bw.write(contenidoLinea);
        			bw.newLine();
    			}

    			

    		} catch (IOException ioe) {
    			ioe.printStackTrace();
    		} finally {
    			try {
    				if (bw != null)
    					bw.close();
    			} catch (Exception ex) {
    				System.out.println("Error cerrando el BufferedWriter" + ex);
    			}
    		}
        }
        else {
        	System.out.println("no se encontro ese genero");
        }
        

	}

}
