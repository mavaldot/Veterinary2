package model;

/**
 * 
 * Contains the details of all the services performed by the clinic
 * 
 * @author Mateo Valdes
 *
 */
public class Service {

	//Static attributes
	public static final int BATH = 1;
	public static final int HOMEBATH = 2;
	public static final int NAILTRIMMING = 3;
	public static final int DENTALPROPHYLAXIS = 4;
	public static final int VACCINATION = 5;
	
	//Non-static attributes
	private int type;
	private double cost;
	private Date serviceDate;
	private int petID;
	private String ownerID;
	
	/**
	 * Class constructor
	 * @param typ	The type of service
	 * @param sd	The date the service was performed
	 * @param pid	The pet's ID
	 * @param oid	The pet owner's ID
	 */
	public Service(int typ, Date sd, int pid, String oid) {
		type = typ;
		serviceDate = sd;
		petID = pid;
		ownerID = oid;
	}
	
	/**
	 * Determines the type of service and converts it into a string of words
	 * 
	 * @return A string containing the type of service
	 */
	public String whatType() {
	
		String typeStr = "";
		
		switch(type) {
		case 1: 
			typeStr = "Bath";
			break;
		case 2:
			typeStr = "Home bath";
		case 3:
			typeStr = "Nail trmming";
			break;
		case 4:
			typeStr = "Dental prophylaxis";
			break;
		case 5:
			typeStr = "Vaccination";
			break;
		}
		
		return typeStr;
	}
	
	/**
	 * Calculates the cost of the service based on the type of service.
	 * <p>
	 * <b> post: </b> The cost attribute is modified with the calculated cost <br>
	 * @return	A double with the calculated cost
	 */
	public double calculateCost() {
		
		double cost = 0;
		
		switch(type) {
		
		case 1:
			cost = 20;
			break;
			
		case 2:
			cost = 30;
			break;
			
		case 3:
			cost = 8;
			break;
			
		case 4: 
			cost = 12;
			break;
			
		case 5:
			cost = 45;
			break;
			
		default:
			cost = 0;
			break;
		}
		
		this.cost = cost;
		
		return cost;
	}
	
	/**
	 * Creates a full report containing all the service's important information
	 * <p>
	 * <b> pre: </b> <code> serviceDate </code> <br>
	 * 
	 * @return The full report of all the service's information
	 */
	public String fullReport() {
		
		String msg = "";
		
		msg += "Type: " + whatType() + "\n";
		msg += "Cost: " + calculateCost() + "\n";
		msg += "Date: " + serviceDate.reportDate();
		msg += "Pet ID: " + petID + "\n";
		msg += "User ID:" + ownerID + "\n";
		
		
		return msg;
	}
	
	//Getters
	
	/**
	 * 
	 * Returns the date when the service was performed
	 * 
	 * @return An object containing the date when the service was performed
	 */
	public Date getDate() {
		return serviceDate;
	}
	
	
}
