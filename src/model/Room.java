package model;

/**
 * 
 * Models a room in the clinic with a pet and his record
 * 
 * @author Mateo Valdes
 *
 */
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
	
	/**
	 * Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	 * <p>
	 * <b> pre: </b> The patient clinic story must be not null. <br>
	 * <b> post: </b> New medicines were added to the patient clinic story.
	 * @param The medicine name. This param must be not null.
	 * @param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
	 * @param The medicine cost by each dose. This param could be empty.
	 * @param The frequency of medicine application. This param could be empty.
	 * @return A message that indiques if medicine was added to the patient clinic story
	*/
	public String addNewMedication(String name, double dose, double cost, double frequency) {
		String msg = "";
		
		if(available) {
			msg = "ERROR. The pet is not currently hospitalized.";
		}
		else {
			record.addNewMedication(name, dose, cost, frequency);
			msg = "The medication was added successfully.";
		}
		
		return msg;
	}
	
	/**
 	 * Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
 	 * <p>
	 * pre: The patient clinic story must be not null. <br>
	 * post: New notes were added to the possible diagnostic in the patient clinic story.
	 * @param The notes of possible diagnostic. This param must be not null.
	 */
	public void addNewDiagnosis(String newDiagnosis) {
		
		record.addDiagnosis(newDiagnosis);
		
	}
	
	/**
 	 * Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
 	 * <p>
	 * pre: The patient clinic story must be not null. <br>
	 * post: New notes were added to the possible diagnostic in the patient clinic story.
	 * @param The new symptoms. This param must be not null.
	 */
	public void addNewSymptom(String newSymptom) {
		
		record.addSymptom(newSymptom);
		
	}
	
	
	//Getters
	
	/**
	 * 
	 * @return
	 */
	public String getName() { return name; }
	
	/**
	 * 
	 * @return
	 */
	public Pet getCurrentPet() { return currentPet; }
	
	/**
	 * 
	 * @return
	 */
	public Record getRecord() { return record; }
	
	/**
	 * 
	 * @return
	 */
	public boolean getAvailable() { return available; }
	
}
