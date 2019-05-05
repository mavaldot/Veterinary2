package model;

/**
 * Contains day, month, and year. 
 * 
 * @author	Mateo Valdes
 */

public class Date {

	//Attributes
	private int day;
	private int month;
	private int year;
	
	/**
	 * 
	 * Class constructor. Creates a date with a day, a month and a year
	 * 
	 * @param d	The day of the month
	 * @param m	The month
	 * @param y	The year
	 */
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	/**
	 * Reports the date in dd/mm/yy format
	 * 
	 * @returns A string with the date in dd/mm/yy format
	 */
	public String reportDate() {
		String report = day + "/" + month + "/" + year + "\n";
		return report;
	}
	
	/**
	 * Converts the date to an int representing the number of days that have passed since the birth of Jesus Christ
	 *
	 * @return an int representing the number of days that passed since the birth of Jesus Christ
	 */
	public int toInt() {
		
		int totalDays = 0;
		
		totalDays += year*365;
		
		switch(month) {
		
		case 1:
			
			break;
			
		case 2:
			
			totalDays += 31;
			break;
			
		case 3:
			
			totalDays += 59;
			break;
		case 4:
			
			totalDays += 90;
			
			break;
			
		case 5: 
			
			totalDays += 120;
			break;
			
		case 6:
			
			totalDays += 151;
			break;
			
		case 7:
			
			totalDays += 181;
			break;
			
		case 8: 
			
			totalDays += 212;
			break;
			
		case 9:
			
			totalDays += 243;
			break;
			
		case 10:
			
			totalDays += 273;
			break;
			
		case 11:
			
			totalDays += 304;
			break;
			
		case 12:
			
			totalDays += 334;
			break;
			
		default:
				
			break;
				
		}
		
		totalDays += day;
		
		return totalDays;
		
	}
	
	//Getters
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	//Setters
	public void setDay(int d) { day = d; }
	public void setMonth(int m) { month = m; }
	public void setYear(int y) { year = y; }
}
