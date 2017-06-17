package TPE;


public class GrafoND extends GrafoD{

	public GrafoND(int numVertices) {
		super(numVertices);
	}

	public void insertarArista(Persona i,Persona j){
		String k = j.getNombre();
		String v = i.getNombre();
		if((!existeArco(v,k))&&(v!=k)){
			super.insertarArco(i, j);
			super.insertarArco(j, i);
		}
		numArcos++;
	}
	
}

