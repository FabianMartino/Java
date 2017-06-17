package TPE;

public class Persona {
	public enum tipo{USUARIO,GUSTO};
	private String nombre;
	private tipo clase;
	private int id;
	
	public Persona(tipo t){
		this.nombre="";
		clase=t;
		this.id=-1;
	}
	public Persona(String nombre,tipo t,int id){
		this.nombre=nombre;
		clase=t;
		this.id=id;
	}
	public tipo getClase() {
		return clase;
	}
	public void setClase(tipo clase) {
		this.clase = clase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
