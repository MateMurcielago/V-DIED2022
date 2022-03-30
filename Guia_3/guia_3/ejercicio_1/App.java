package guia_3.ejercicio_1;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1 = new Punto(1,1);
		Punto p2 = new Punto(2,2);
		Recta r1 = new Recta(p1,p2);
		
		System.out.print("Pendiente de la recta R1: " + r1.pendiente() + "\n\n");;
		
		Punto p3 = new Punto(3,3);
		Recta r2 = new Recta(p2,p3);
		
		if(r1.equals(r2)) {
			System.out.print("La recta R1 y la recta R2 representan la misma recta");
		} else {
			System.out.print("La recta R1 y la recta R2 no representan la misma recta");
		}
	}

}
