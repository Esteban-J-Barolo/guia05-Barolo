package guia05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class prue {
	public static void main(String[] args) {

		LocalDate dia_inicio = LocalDate.now();
		LocalDate dia_fin = LocalDate.of(2021, 04, 19);
		
		System.out.println(ChronoUnit.DAYS.between(dia_inicio, dia_fin));

	}

}
