package model;

/**
 * Contains all the important information regarding a medication prescribed to a pet.
 * @author Mateo
 *
 */
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
	
	/**
	 * Returns the name of the medication
	 * @return The name of the medication
	 */
	public String getName() { return name; } 
	
	/**
	 * Returns the dose of the medication in milligrams
	 * @return The dose of the medication in milligrams
	 */
	public double getDose() { return dose; }
	
	/**
	 * Returns the cost per dose of the medication
	 * @return The cost per dose of the medication
	 */
	public double getCostPerDose() { return costPerDose; }
	
	/**
	 * Returns the frequency (per day) of the medication
	 * @return The frequency of the medication
	 */
	public double getFrequency() { return frequency; }
}
