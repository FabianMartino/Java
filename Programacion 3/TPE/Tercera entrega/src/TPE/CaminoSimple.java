package TPE;

import java.util.ArrayList;

public class CaminoSimple {
	
	public enum color{
	AMARILLO, BLANCO, NEGRO};
	
	color visitados[];
  
	public Integer DFS(GrafoD g,int u,int j){
	visitados = new color[g.numVertices()];
		
	for (int i=0;i<g.numVertices();i++){
			visitados[i] = color.BLANCO;
		}
		return DFS_Visit(u,j,g);
	}
	
	
	
	public Integer DFS_Visit(int u,int j, GrafoD g){
		visitados[u] = color.AMARILLO;
		ArrayList <Integer> ady = g.adyacentesDe(u);
		 Integer aux=0;
		 Integer resultado=0;
		 
		for (int i = 0; i < ady.size(); i++) {
			if(ady.get(i)!=j){
				if(visitados[ady.get(i)]==color.BLANCO){
				aux = DFS_Visit(ady.get(i),j,g);
			}else if(visitados[ady.get(i)]==color.AMARILLO){
				  aux=0;
			}
		}else
			{aux=1;}
		if (resultado<aux){
			resultado=aux;
		}
		
	}
		visitados[u] = color.NEGRO;
		if(resultado>0)
			resultado++;
		return resultado;
  }

}
