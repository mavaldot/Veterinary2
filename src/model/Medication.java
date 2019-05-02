package model;

public class Medication {

	//Attributes
	private String name;
	private double dose;
	private double costPerDose;
	private double frequency;
	
	/**
	 * Class constructor. 
	 * @param n		The name of the medication
	 * @param d		The dose of the medication
	 * @param cpd	The cost per dose of the medication
	 * @param f		The frequency (per day) of the medication
	 */
	public Medication(String n, double d, double cpd, double f) {
		name = n;
		dose = d;
		costPerDose = cpd;
		frequency = f;
	}
	
	/**
	 * Create a full report of all the attributes of the medication <br>
	 * Reports: The name, the dose, the cost per dose and the dose frequency (per day).
	 * 
	 * @return A string containing all the attributes of the medication
	 */
	public String fullReport() {
		String report = "";
		report += "Name: " + name + "\n";
		report += "Dose: " + dose + "\n";
		report += "Cost per dose: " + costPerDose + "\n";
		report += "Dose frequency (per day): " + frequency + "\n";
		
		return report;
		
	}
	
	//Getters
	public String getName() { return name; } 
	public double getDose() { return dose; }
	public double getCostPerDose() { return costPerDose; }
	public double getFrequency() { return frequency; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setDose(double d) { dose = d; }
	public void setCostPerDose(double cpd) { costPerDose = cpd; }
	public void setFrequency(double f) { frequency = f; }
}
