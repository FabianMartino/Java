package Ej;

public class Main {

	public static void main(String[] args) {
		Lista L = new Lista();
		L.insert(1);
		L.insert(4);
		L.insert(3);
		L.insert(15);
		
		Lista L2 = new Lista();
		L2.insert(1);
		L2.insert(4);
		L2.insert(3);
		L2.insert(15);
		
		Lista R1 = new Lista();
		R1 = L.combina_ordenado(L2);
		Lista R2 = new Lista();
		R2 = L.combinada(L2);
		for(int i =0;i<R1.size;i++) {
			System.out.print(R1.print(i)+"-");
			
		}
		System.out.println(" ");
		for(int i =0;i<R2.size;i++) {
			System.out.print(R2.print(i)+"-");
			
	}

}
}