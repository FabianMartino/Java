package ej;

public class CuboMagico {
	private int[][] cubo;
	private int suma;
	private int rango;
	private int dimencion;
	
	public CuboMagico(int suma,int dimencion,int rango) {
		this.cubo = new int[dimencion][dimencion];
		this.suma = suma;
		this.rango = rango;
		this.dimencion = dimencion;
	}
	
	public void generarCubo() {
		int[] sumCol = new int[dimencion];
		for(int i = 0;i<dimencion;i++) {
			sumCol[i] = 0;
		}
		int[] sumFila = new int[dimencion];
		for(int i = 0;i<dimencion;i++) {
			sumFila[i] = 0;
		}
		boolean[] usados = new boolean[rango];
		for(int i = 0;i<usados.length;i++) {
			usados[i] = false;
		}
		int col = 0;
		int fila = 0;
		int[][] tmp = cubo;
		boolean encontrado = false;
		tmp = back(col,fila,sumCol,sumFila,tmp,usados,encontrado);
		if(tmp.length>0) {
			this.cubo = tmp;
		}
	}
	private int[][] back(int col,int fila,int[] sumCol,int[] sumFila,int[][] cuboAux,boolean[] usados,boolean encontrado) {		
		if(fila==dimencion) {
			if(validarSuma(sumCol,sumFila)) {
				encontrado = true;
				return cuboAux;
			}
		}
		else {
			int i = 0;
			int[][] tmp = cuboAux;
			int[][] resultado;
			while(i<usados.length&&!encontrado) {
				if(!usados[i]) {
					usados[i]=true;
					sumCol[col] += i;
					sumFila[fila] += i;
					if(sumCol[col]<= suma&&sumFila[fila]<= suma) {
						tmp[col][fila] = i;
					    if(col < dimencion-1) {
					    	resultado = back(col+1,fila,sumCol,sumFila,tmp,usados,encontrado);
					    }
					    else {
					    	resultado = back(0,fila+1,sumCol,sumFila,tmp,usados,encontrado);
					    }
						if(validarSuma(sumCol,sumFila)) {
							return resultado;
						}
					}
					sumCol[col] -= i;
					sumFila[fila] -= i;
					usados[i]=false;
				}
				i++;
			}
		}
		int[][] vacio = new int[dimencion][dimencion];
		return vacio;

	}
	
	private boolean validarSuma(int[] sumCol,int[] sumFila) {
		boolean validar = true;
		for(int i = 0;i<sumCol.length;i++)
			if(sumCol[i]!=suma)
				validar = false;
		for(int i = 0;i<sumFila.length;i++)
			if(sumFila[i]!=suma)
				validar = false;
		return validar;	
	}
	
	public void imprimir() {
		if(!isEmpty())
			for(int i = 0;i<dimencion;i++) {
				for(int j = 0;j<dimencion;j++) {
					System.out.print(cubo[j][i]+" ");
				}
				System.out.println();
			}
		else
			System.out.println("El cubo esta vacio.");
	}
	public boolean isEmpty() {
		for (int i = 0; i < cubo.length; i++) {
			for (int j = 0; j < cubo.length; j++) {
				if(cubo[j][i]!=0) {
					return false;
				}
			}
		}
		return true;
	}

}
