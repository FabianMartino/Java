
public class GrafoD {
	private boolean[][] matriz;
	private int vertices;	//Es la cantidad de vertices	
	
	public GrafoD(int vertices){
		this.matriz = new boolean[vertices][vertices];
		this.vertices = vertices;
	}
	//Agrega los adyacentes de un vector i
	public void agregarAdyacentes(int vertice,boolean[]adyacentes){
		for(int i = 0; i < adyacentes.length; i++){
			this.matriz[vertice][i] = adyacentes[i];
		}
	}
	//Obtengo el valor de la matriz en una coordenada. Esto lo uso para luego imprimir la matriz
	public Boolean getValor(int i, int j){
		return this.matriz[i][j];
	}
	//Obtiene los conjuntos de vertices que forman un ciclo
	public String ciclosRecursivo(int vertice){
		String temporal = "";
		if(vertice < this.vertices){
			for(int i = vertice; i < this.vertices; i++){
				if(this.matriz[vertice][i]){
					if(this.matriz[i][vertice]){
						if(!temporal.equals("")){
							temporal += " - ";
						}
						temporal += vertice+" con "+i;
					}
				}				
			}
			String aux = ciclosRecursivo(vertice+1);
			if(!aux.equals("")){
				if(!temporal.equals("")){
					temporal += " - ";
				}
			}
			temporal += aux;
		}
		return temporal;
	}
	public String ciclosIterativo(){
		String temporal = "";
		for(int i = 0; i < this.vertices; i++){
			for(int j = i; j < this.vertices; j++){
				if(this.matriz[j][i]){
					if(this.matriz[i][j]){
						if(!temporal.equals("")){
							temporal += " - ";
						}
						temporal += i+" con "+j;
					}
				}				
			}
		}
		return temporal;
	}
}
