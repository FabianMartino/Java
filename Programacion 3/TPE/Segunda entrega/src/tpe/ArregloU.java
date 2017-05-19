package tpe;

public class ArregloU {

	private NodoU[] usuarios;
	private int cantidad;
	
	public ArregloU(){
		usuarios = new NodoU[10000];
		cantidad = 0;
	}
	
	public NodoU getUsuarios(int i) {
		return usuarios[i];
	}

	public void setUsuarios(int i, NodoU usuario) {
		this.usuarios[i] = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void agregar(int id, NodoG gustos){
		if(cantidad==usuarios.length){
			NodoU[] nuevo = new NodoU[(cantidad*2)];
			for(int i=0;i<usuarios.length;i++){
				nuevo[i]=usuarios[i];
			}
			usuarios = nuevo;
		}
		usuarios[cantidad] = new NodoU();
		usuarios[cantidad].setElemento(id);
		usuarios[cantidad].setGustos(gustos);
		cantidad++;
	}
	public void ordenarBurbujeo(){
		if(cantidad>1){
			for(int i = 0; i<cantidad;i++){
				System.out.println(i);
				for(int j = 0; j<cantidad-1;j++){
					if(usuarios[j].getElemento() > usuarios[j+1].getElemento()){
						NodoU temporal = usuarios[j];
						usuarios[j] = usuarios[j+1];
						usuarios[j+1] = temporal;
					}
				}
			}
		}
	}
	public void agregarOrdenado(int id, NodoG gustos){
		if(cantidad==usuarios.length){
			NodoU[] nuevo = new NodoU[(cantidad*2)];
			for(int i=0;i<usuarios.length;i++){
				nuevo[i]=usuarios[i];
			}
			usuarios = nuevo;
		}
		if(cantidad==0){
			usuarios[cantidad] = new NodoU();
			usuarios[cantidad].setElemento(id);
			usuarios[cantidad].setGustos(gustos);
			cantidad++;	
			return;
			
		}
		int posicion = buscarPosicion(id);
		insertarYCorrer(posicion,id,gustos);
	}
	private int buscarPosicion(int id){
		int posicion = 0;
		while(posicion<cantidad){
			if(id<usuarios[posicion].getElemento()){
				return posicion;
			}
			posicion++;
		}
		return cantidad;
	}
	private void insertarYCorrer(int posicion, int id, NodoG gustos){
		if(posicion==cantidad){
			usuarios[cantidad] = new NodoU();
			usuarios[cantidad].setElemento(id);
			usuarios[cantidad].setGustos(gustos);
			cantidad++;	
		}
		else{
			usuarios[cantidad] = new NodoU();
			if(cantidad>1){
				for(int i = cantidad;i>posicion;i--){	
					usuarios[i].setElemento(usuarios[i-1].getElemento());
					usuarios[i].setGustos(usuarios[i-1].getGustos());
				}
			}
			usuarios[posicion].setElemento(id);
			usuarios[posicion].setGustos(gustos);
			cantidad++;	
		}
	}
		
	public boolean buscar(int id){
		int min = 0;
		int max = cantidad-1;
		int medio = ((min+max)/2);
		while(min<=max){
			if(usuarios[medio].getElemento() == id){
				return true;
			}
			else{
				if(usuarios[medio].getElemento() < id){
					max = medio-1;
				}
				else{
					min = medio+1;
				}
				medio = ((min+max)/2);
			}
		}
		return false;
	}
	
}
