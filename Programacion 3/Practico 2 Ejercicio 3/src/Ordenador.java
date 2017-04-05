
public class Ordenador {
	int[] orden;
	
	public Ordenador(int tamano){
		orden = new int[tamano];
	}
	//agrega un valor en una posicion dada
	public void agregar(int pos, int valor){
		if(pos < this.getTamano() && pos > -1){
			orden[pos] = valor;
		}
	}
	//si la posicion no se encuentra dentro del rango devuelve un -1
	public int getValor(int pos){
		if(pos < this.getTamano() && pos > -1){
			return orden[pos];
		}
		else{
			return -1;
		}
	}
	public int getTamano(){
		return orden.length;
	}
	public void burbujeo(){
		if(orden.length > 1){
			for (int i = 0; i < orden.length-1; i++){
				for (int j = 0; j < orden.length-1; j++){
					if(orden[j] > orden[j+1]){
						int temporal = orden[j];
						orden[j] = orden[j+1];
						orden[j+1] = temporal;
					}
				}
			}
		}
	}
	public void quicksort(int izq, int der) {
		int pivote = orden[izq]; 
		int i=izq;
		int j=der;
		while(i<j){         
			while(orden[i]<=pivote && i<j){
				i++; 
			}
			while(orden[j]>pivote){
				j--; 
			}
			if (i<j) {                                     
				int temporal = orden[i];
				orden[i] = orden[j];
				orden[j] = temporal;
			}
		}
		orden[izq]=orden[j];
		orden[j]=pivote; 
		if(izq<j-1){
			quicksort(izq,j-1);
		}
		if(j+1 <der){
			quicksort(j+1,der); 
		}
	}
}
