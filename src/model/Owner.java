package model;

import java.util.ArrayList;

/**
 * 
 * Contains important data about the pet owner.
 * 
 * @author Mateo Valdes
 *
 */
public class Owner {

	//Attributes
	private String name;
	private String id;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Pet> pets;
	
	/**
	 * Class constructor
	 * @param n The name of the pet owner
	 * @param theid The id of the pet owner
	 * @param addr The address of the pet owner
	 * @param pn The phone number of the pet owner
	 */
	public Owner(String n, String theid, String addr, int pn) {
		name = n;
		id = theid;
		address = addr;
		phoneNumber = pn;
		pets = new ArrayList<Pet>();
	}
	
	/**
	 * Add a pet to the pets arraylist
	 * 
	 * <b> pre: </b> <code> pets != null </code> <br>
	 * <b> post: </b> A pet is added to the owner's pets arraylist
	 * @param name		The name of the pet
	 * @param type		The type of the pet
	 * @param id		The id of the pet
	 * @param age		The age of the pet
	 * @param weight	The weight of the pet
	 * @param height	The height of the pet
	 */
	public void addPet(String name, String type, int id, int age, double weight, double height) {
		pets.add(new Pet(name, type, id, age, weight, height));
	}
	
	/**
	 * Create a full report of all the attributes of the owner. <br>
	 * Reports: The name, the ID, the address and the phone numbers
	 * 
	 * @return A string containing a report of all the attributes of the owner
	 */
	public String fullReport() {
		String report = "";
		report += "Name: " + name + "\n";
		report += "ID: " + id + "\n";
		report += "Address: " + address + "\n";
		report += "Phone number: " + phoneNumber + "\n";
		
		return report;
	}
	
	/**Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	 *pre: The client was created before.
	 *post: The address and /or phone number of the client is updated.
	 *@param addr The new address of the client. This param could be empty.
	 *@param phoneNum The new phone number of the client. This param could be empty.
	 */
	public void updateData(String addr, int phoneNum) {
		if( !(addr.equals("")) && !(addr.equals("0")) ) {
			address = addr;
		}
		
		if( phoneNum != 0) {
			phoneNumber = phoneNum;
		}
	}
	
	//Getters
	/**
	 * Returns the name of the pet owner
	 * @return The name of the pet owner
	 */
	public String getName() { return name; }
	
	/**
	 * Returns the ID of the pet owner
	 * @return The ID of the pet owner
	 */
	public String getID() { return id; }

	/**
	 * Returns the phone number of the pet owner
	 * @return The phone number of the pet owner
	 */
	public int getPhoneNumber() { return phoneNumber; }
	
	/**
	 * Returns a list (an arraylist specifically) of all of this pet owner's pets registered
	 * in this clinic
	 * @return A list containing the owner's pets
	 */
	public ArrayList<Pet> getPets() { return pets; }
	
	
}
