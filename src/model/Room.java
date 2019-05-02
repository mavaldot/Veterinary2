package model;

public class Room {

	//Attributes
	private String name;
	private Pet currentPet;
	private Record record;
	private boolean available;
	
	/**
	 * Class constructor. 
	 * 
	 * @param n		The name of the room
	 * @param cpt	The current pet in the room
	 * @param rc	The current record in the room
	 * @param a		The availability of the room
	 */
	public Room(String n, Pet cpt, Record rc, boolean a) {
		name = n;
		currentPet = cpt;
		record = rc;
		available = a;
	}
	
	/**
	 * Fill the room with a pet given the attributes and create a new record for the pet
	 * <p>
	 * <b> post: </b> A new pet is added to the room <br>
	 * <b> post: </b> A new record is added to the room <br>
	 * <b> post: </b> The room is not longer available <br>
	 * 
	 * @param cpt		The current pet
	 * @param own		The pet's owner
	 * @param day		The current day of the month
	 * @param month		The current month
	 * @param year		The current year
	 * @param symptoms	The pet's symptoms
	 * @param diagnosis	The pet's diagnosis
	 */
	public void fillRoom(Pet cpt, Owner own, int day, int month, int year, String symptoms, String diagnosis) {
		currentPet = cpt;
		record = new Record(Record.OPEN, cpt, own, new Date(day, month, year), symptoms, diagnosis);
		available = false;
	}
	
	/**
	 * Calculates the cost of the pet's hospitalization
	 * 
	 * @param day	Current day of the month
	 * @param month	Current month
	 * @param year	Current year
	 * @return		A double with the cost of the pet's hospitalization
	 */
	public double calculateCost(int day, int month, int year) {
		double cost = record.calculateCost(day, month, year);
		
		return cost;
	}
	
	/**
	 * Releases the current pet
	 * <p>
	 * <b> post: </b> The pet is released from the room
	 */
	public void releasePet() {
		currentPet = null;
		record = null;
		available = true;
	}
	
	//Getters
	public String getName() { return name; }
	public Pet getCurrentPet() { return currentPet; }
	public Record getRecord() { return record; }
	public boolean getAvailable() { return available; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setCurrentPet(Pet cp) { currentPet = cp; }
	public void setRecord(Record r) { record = r; }
	public void setAvailable(boolean a) { available = a; }
	
}
