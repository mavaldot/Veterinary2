package model;

import java.util.ArrayList;

public class Owner {

	//Attributes
	private String name;
	private String id;
	private String address;
	private int phoneNumber;
	
	private ArrayList<Pet> pets;
	
	/**
	 * Class constructor
	 * @param n
	 * @param theid
	 * @param addr
	 * @param pn
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
	 * <b> pre: </b> <code> pets != null </code> < br>
	 * <b> post: </b> A pet is added to the owner's pets arraylist
	 * @param name		The name of the pet
	 * @param type		The type of the pet
	 * @param age		The age of the pet
	 * @param weight	The weight of the pet
	 * @param height	The height of the pet
	 */
	public void addPet(String name, String type, int age, double weight, double height) {
		pets.add(new Pet(name, type, age, weight, height));
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
	
	//Getters
	public String getName() { return name; }
	public String getId() { return id; }
	public String getAddress() { return address; }
	public int getPhoneNumber() { return phoneNumber; }
	public ArrayList<Pet> getPets() { return pets; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setId(String theid) { id = theid; }
	public void setAddress(String a) { address = a; }
	public void setPhoneNumber(int pn) { phoneNumber = pn; }
	public void setPets(ArrayList<Pet> pts) { pets = pts; }
	
}
