//se entrega un segundo main debido a las diferencias entre listas y arreglos
package tpe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainConArreglos {

	public static void main(String[] args) {
		String csvFile = "datasets/dataset_500000.csv";
        String line = "";
        String cvsSplitBy = ";";
        ArregloU A= new ArregloU();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();
            while ((line = br.readLine()) != null) {
            	NodoG gustos = new NodoG();
                String[] items = line.split(cvsSplitBy);
                Integer id= Integer.parseInt(items[0]);
                	for (int i = 1; i < items.length; i++) {

                			if (gustos.getElemento()==""){
                				gustos.setElemento(items[i]);
                			}
                			else{
                			NodoG temporal = gustos;
                			  while((temporal.getSiguiente()!=null)&&(!temporal.getElemento().equals(items[i]))){
                				temporal=temporal.getSiguiente();
                 			  }
                			  if(!temporal.getElemento().equals(items[i])){
                				  NodoG aux = new NodoG(items[i],null);
                				  temporal.setSiguiente(aux);
                			  }
                			}
					}
                	A.agregar(id, gustos);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        long startTime = 0;
        long endTime = 0;
        int tiempototal = 0;
        int cantidad = 0;
        String csvFileInsertar = "datasets/dataset_insert_10000.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileInsertar))) {
        	BufferedWriter bw = null;
      		try {
      			File file = new File("datasets/salidaAlta.csv");
      			if (!file.exists()) {
      				file.createNewFile();
      			}
      			FileWriter fw = new FileWriter(file);
      			bw = new BufferedWriter(fw);
      			tiempototal = 0;
      			while ((line = br.readLine()) != null) {
	        		startTime = System.nanoTime();
	        		NodoG gustos = new NodoG();
	                String[] items = line.split(cvsSplitBy);
	                Integer id= Integer.parseInt(items[0]);
	                for (int i = 1; i < items.length; i++) {
            			if (gustos.getElemento()== ""){
            				gustos.setElemento(items[i]);
            			}
            			else{
                			NodoG temporal = gustos;
                			  while((temporal.getSiguiente()!=null)&&(!temporal.getElemento().equals(items[i]))){
                				temporal=temporal.getSiguiente();
                 			  }
                			  if(!temporal.getElemento().equals(items[i])){
                				  NodoG aux = new NodoG(items[i],null);
                				  temporal.setSiguiente(aux);
                			  }
                		}
	                }
                	A.agregar(id, gustos);
                	cantidad++;
                	endTime = System.nanoTime();
                	String contenidoLinea1 = (endTime - startTime) + " ns" + ";" + id + ";"+ gustos.listar();
                	tiempototal += (endTime - startTime);
                	bw.write(contenidoLinea1);
                	bw.newLine();
      			}	
      			String contenidoLinea1 = "Tiempo total;"+tiempototal;
      			bw.write(contenidoLinea1);
            	bw.newLine();
            	if(cantidad > 0){
	        		contenidoLinea1 = "Tiempo promedio;"+(tiempototal/cantidad);
		  			bw.write(contenidoLinea1);
		        	bw.newLine();
	        	}
       		} 
      		catch (IOException ioe) {
       			ioe.printStackTrace();
       		}
      		finally {
       			try {
       				if (bw != null)
       					bw.close();
       			} 
       			catch (Exception ex) {
       				System.out.println("Error cerrando el BufferedWriter" + ex);
       			}

      		}
       } catch (IOException e) {
           e.printStackTrace();
       }
       String csvFileBuscar = "datasets/dataset_busqueda_10000.csv";
       try (BufferedReader br = new BufferedReader(new FileReader(csvFileBuscar))) {
    	   BufferedWriter bw = null;
      		try {
      			File file = new File("datasets/salidaBusqueda.csv");
      			if (!file.exists()) {
      				file.createNewFile();
      			}
      			cantidad = 0;
      			tiempototal =0;
      			FileWriter fw = new FileWriter(file);
      			bw = new BufferedWriter(fw);
      			String encontrado = "";
	            while ((line = br.readLine()) != null) {
	            	encontrado = "no encontrado";
	        		startTime = System.nanoTime();
	        		String[] items = line.split(cvsSplitBy);
	        		if(A.buscar(Integer.parseInt(items[0]))){
	        			encontrado = "encontrado";
	        		}
            	    endTime = System.nanoTime();
            	    String contenidoLinea1 = items[0] + ";" + encontrado + ";" + (endTime - startTime) + " ns";
            	    bw.write(contenidoLinea1);
            	    bw.newLine();
            	    tiempototal += (endTime - startTime);
            	    cantidad++;
	            }
	            String contenidoLinea1 = "Tiempo total;"+tiempototal;
	  			bw.write(contenidoLinea1);
	        	bw.newLine();
	        	if(cantidad > 0){
	        		contenidoLinea1 = "Tiempo promedio;"+(tiempototal/cantidad);
		  			bw.write(contenidoLinea1);
		        	bw.newLine();
	        	}
	        } 
      		catch (IOException ioe) {
      			ioe.printStackTrace();
	       	}
      		finally {
	   			try {
	   				if (bw != null)
	   					bw.close();
	   			} 
	   			catch (Exception ex) {
	   				System.out.println("Error cerrando el BufferedWriter" + ex);
	   			}
      		}
       }
       catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println("termino");
	}
}
