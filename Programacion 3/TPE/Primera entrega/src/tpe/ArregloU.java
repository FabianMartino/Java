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
	public boolean buscar(int id){
		int i = 0;
		while(i<cantidad){
			if(usuarios[i].getElemento() == id){
				return true;
			}
			i++;
		}
		return false;
	}
}
