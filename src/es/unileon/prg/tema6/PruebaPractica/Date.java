package es.unileon.prg.tema6.PruebaPractica;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	public Date(){

	}

	public Date(Date day2){
		day2= new Date();
	}

	

	public int getYear(){
		return year;
	}


	public boolean isSameYear(Date another){
		
		boolean mismoAño = false;
		if(this.year == another.getYear()){
			mismoAño = true;	
		}else{
			mismoAño = false;
		}
		return mismoAño;
	}
	public int getMonth(){
		return month;
	}

	public boolean isSameMonth(Date another){
		
		boolean mismoMes = false;
		if(this.month == another.getMonth()){
			mismoMes = true;
		}else{
			mismoMes = false;
		}
		return mismoMes;
	}
	public int getDay(){
		return day;
	}

	public boolean isSameDay(Date another){
		
		boolean mismoDia = false;
		if(this.day == another.getDay()){
			mismoDia = true;
		}else{
			mismoDia = false;
		}
		return mismoDia;
	
	}
	public boolean isSame(Date another){
		boolean igual = false;
		if((this.day == another.getDay()) && (this.month == another.getMonth())&& (this.year == another.getYear())){
			igual = true;
		}else{
			igual = false;
		}
		return igual;
	}
	
	public String getMonthName(){
		String nombreMes = " ";
		switch(month){
			case 1:
				nombreMes = "Enero";
				break;
			case 2:
				nombreMes = "Febrero";
				break;
			case 3:
				nombreMes = "Marzo";
				break;
			case 4:
				nombreMes = "Abril";
				break;
			case 5:
				nombreMes = "Mayo";
				break;
			case 6:
				nombreMes = "Junio";
				break;
			case 7: 
				nombreMes = "Julio";
				break;
			case 8:
				nombreMes = "Agosto";
				break;
			case 9:	
				nombreMes = "Septiembre";
				break;
			case 10:
				nombreMes = "Octubre";
				break;
			case 11:
				nombreMes = "Noviembre";
				break;
			case 12:
				nombreMes = "Diciembre";
				break;
		}
		return nombreMes;


	
	}
	public boolean checkMonthDay(int day) throws DateException{
		boolean valid=false;
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(day <=0 || day >31){
					throw new DateException("Día no valido");
				}else{
					valid=true;
				}
				break;
			case 2:
				if(day <=0 || day >28){
					throw new DateException("Dia no valido");
				}else{
					valid=true;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(day <=0 || day >30){
					throw new DateException("Dia  no valido");
				}else{
					valid=true;
				}
				break;
		}	
		return valid;
	
	}
	public String getSeasonName(){
		String season = "";
		switch(month){
		case 12:
		case 1:
		case 2:
			season = "Invierno";
			break;
		case 3:
		case 4: 
		case 5:
			season = "Primavera";
			break;
		case 6:
		case 7:
		case 8:
			season  = "Verano";
			break;
		case 9:
		case 10:
		case 11:
			season = "Otoño";
			break;
	}
	return season;
	}

	public String getMonthsLeft(){
		StringBuffer meses = new StringBuffer();
		int month = this.month;
		Date fecha = this;
		for (int i =this.month; i<12; i++){
			month++;
			try{
				fecha.setMonth(month);
			} catch (DateException e){
				e.printStackTrace();
			}
			meses.append(fecha.getMonthName() + " ");
		}
		return meses.toString();
	}
	public String getDaysLeftOfMonth(){
		StringBuffer dias = new StringBuffer();
		Date fecha = this;
		int day = this.day;

		for (int i = this.day; i<this.getDaysOfMonth(); i++){
			day++;
			try{
				fecha.setDay(day);
			}catch (DateException e){
				e.printStackTrace();
			}
			dias.append(fecha.toString() + " ");
		}
		return dias.toString();
	}
	public String getMonthsSameDays(){
		String meses = "";
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				meses = "Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				meses = "Abril, Junio, Septiembre y Noviembre";
				break;
			case 2:
				meses = "Febrero";
				break;
		}
		return meses;
		}

	public int daysPast() throws DateException{
		int num=0;
		if(this.getMonth() ==1 && this.getDay() !=1){
			num += this.getDay()-1;
		}else{
			int mes = this.getMonth();
			for (int i = 1; i<this.getMonth(); i++){
				this.setMonth(i);
				num = num + this.getDaysOfMonth();
			}
			if(this.getDay() == 31 && mes ==12){
				num = 365 - (this.getDaysOfMonth() - this.getDay())-1;
		}
		}
	return num;
	}
	
	public int randomDate(){
		int diaRandom =0 ;
		int mesRandom = 0;
		int intentos = 0;
		while((diaRandom !=this.day) && (mesRandom !=this.month)){
			diaRandom = (int)((Math.random()*31)+1);
			mesRandom = (int)((Math.random()*12)+1);
			intentos = intentos + 1;
			
		}
		return intentos;
	}
	public int randomDate2(){
		int diaRandom2 = 0;
		int mesRandom2 = 0;
		int intentos2 = 0;
		do{
			diaRandom2 = (int)((Math.random()*31)+1);
			mesRandom2 = (int)((Math.random()*12)+1);
			intentos2 = intentos2 + 1;
		}while((diaRandom2 !=this.day)&&(mesRandom2 !=this.month));
			
		
		return intentos2;
	}
    public String diaSemana(int day) throws DateException{
		String nombre = " ";
		int nombresDias = this.daysPast() % 7;
		switch(nombresDias){
			case 0:
				nombre = "Lunes";
				break;
			case 1:
				nombre = "Martes";
				break;
			case 2:
				nombre = "Miercoles";
				break;
			case 3: 
				nombre = "Jueves";
				break;
			case 4:
				nombre = "Viernes";
				break;
			case 5:
				nombre = "Sabado";
				break;
			case 6:
				nombre = "Domingo";
				break;
			
		}
		return nombre;

	}


}
