package model;

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
	
	
}
