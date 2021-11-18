package es.unileon.prg.tema6.PruebaPractica;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		Date day2;
		try {
			today = new Date(11,11,2020);
			System.out.println("Primera fecha" + today);
            day2 = new Date(15,06,2020);
            System.out.println("Segunda fecha " + day2);
            System.out.println(today.isSameYear(day2));
            System.out.println(today.isSameMonth(day2));
            System.out.println(today.isSameDay(day2));
            System.out.println(today.isSame(day2));
            System.out.println("El nombre del mes de " + today + " es: " + today.getMonthName());
            System.out.println("La estacion de " + today + "es: " + today.getSeasonName());
            System.out.println("Faltan " + today.getMonthsLeft() + "meses para que acabe el año");
            System.out.println("Faltan " + today.getDaysLeftOfMonth()+ "dias para que acabe el mes");
            System.out.println("Meses con los mismos dias que " + today + ":" + today.getMonthsSameDays());
            System.out.println("Dias pasados desde inicio del año:" + today.daysPast());
            System.out.println("Intentos de generar la misma fecha con while:" + today.randomDate());
            System.out.println("Intentos de generar la misma fecha con do while:" + today.randomDate2());

            System.out.println("El nombre del mes de " + day2+ " es: " + day2.getMonthName());
            System.out.println("La estacion de " + day2 + "es: " + day2.getSeasonName());
            System.out.println("Faltan " + day2.getMonthsLeft() + "meses para que acabe el año");
            System.out.println("Faltan " + day2.getDaysLeftOfMonth()+ "dias para que acabe el mes");
            System.out.println("Meses con los mismos dias que " + day2 + ":" + day2.getMonthsSameDays());
            System.out.println("Dias pasados desde inicio del año:" + day2.daysPast());
            System.out.println("Intentos de generar la misma fecha con while:" + day2.randomDate());
            System.out.println("Intentos de generar la misma fecha con do while:" + today.randomDate2());


		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}

