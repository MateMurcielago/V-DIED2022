package guia_5.ejercicio_1;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
	//Insertar una fecha instant
	//Instant h = Instant.from(LocalDate.parse("09/05/2014", DateTimeFormatter.ofPattern("dd/mm/yyyy")));
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(10);
		a.add(7);
		a.stream().sorted((n1, n2) -> n2.compareTo(n1)).forEach(System.out::println);
	}
}
