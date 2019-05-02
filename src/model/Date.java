package model;

/*
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
	
	//Getters
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	//Setters
	public void setDay(int d) { day = d; }
	public void setMonth(int m) { month = m; }
	public void setYear(int y) { year = y; }
}
