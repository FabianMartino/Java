
public class Prueba {
	public static void main (String[] args) throws java.lang.Exception	{
		Pila p1 = new Pila();
		System.out.println(p1.getTamano());
		p1.apilar("hola");
		System.out.println(p1.getTamano());
		System.out.println(p1.getTope());
		p1.desapilar();
		System.out.println(p1.getTamano());
		System.out.println(p1.getTope());
		p1.apilar("hola");
		p1.apilar("como");
		p1.apilar("estas");
		p1.apilar("el");
		p1.apilar("dia");
		p1.apilar("de");
		p1.apilar("hoy");
		System.out.println(p1.getTamano());
		System.out.println(p1.getTope());
		p1.desapilar();
		System.out.println(p1.getTamano());
		System.out.println(p1.getTope());
	}
}
