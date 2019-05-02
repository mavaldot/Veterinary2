package model;

import java.util.ArrayList;

/**
 *  This class models a veterinary clinic. 
 * 
 * @author	 Mateo Valdes
 */
public class Clinic {

	//Static attributes
	public static final int MAX_ROOMS = 8;
	
	//Non-static attributes
	private String name;
	private ArrayList<Owner> owners;
	private Room[] rooms;
	private double revenue;
	private ArrayList<History> histories;
	
	/**
	 * Class constructor
	 * @param n		The name of the clinic
	 */
	public Clinic(String n) {
		
		name = n;
		owners = new ArrayList<Owner>();
		rooms = new Room[MAX_ROOMS];
		revenue = 0;
		histories = new ArrayList<History>();
		
	}
	
	/**
	 * Sets up the rooms of the clinic to be empty and available.
	 */
	public void setUp() {
		for(int i = 0; i < MAX_ROOMS; i++) {
			rooms[i] = new Room("Room " + (i+1), null, null, true);
		}
	}
	
	/**
	 * Asigns a new medication to a pet in a room.
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * <b> pre: </b> <code> rooms.length >= 8 </code> <br>
	 * <b>post: </b> One new medication is assigned to a pet in a room
	 * <p>
	 * @param petName		the name of the pet who will be assigned a new medicine
	 * @param medName		the name of the medication
	 * @param dose 			the dose of the medication
	 * @param costPerDose	the frequency (per day) of the medication
	 * @return 				<code> true </code> if the medication was added successfully, <code> false </code> if there is an 
	 * 						error adding the medication.
	 */
	public boolean addMedication(String petName, String medName, double dose, double costPerDose, double frequency) {
		boolean success = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			
			if(!rooms[i].getAvailable()) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].getRecord().getMedications().add(new Medication(medName, dose, costPerDose, frequency));
					success = true;
				}
			}
		}
		
		return success;
	}
	
	/**
	 * Adds a new owner object to the owners arraylist. <p>
	 * <b> pre: </b> <code> owners != null </code> <br>
	 * <b> post: </b> A new owner is added to the owners array list 
	 * <p>
	 * @param name			The name of the owner
	 * @param id 			The id of the owner
	 * @param address		The address of the owner
	 * @param phoneNumber	The phone number of the owner
	 */
	public void addOwner(String name, String id, String address, int phoneNumber) {
		owners.add(new Owner(name, id, address , phoneNumber));
	}
	
	/**
	 * Adds a pet to the last owner on the arraylist of owners
	 * <b> pre: </b> <code> owners != null </code> <br>
	 * <b> post: </b> A pet is added to the last owner in the arraylist of owners
	 * @param name		The name of the pet		
	 * @param type		The type of pet
	 * @param age		The age of the pet
	 * @param weight	The weight of the pet in kilograms
	 */
	public void addPet(String name, String type, int age, double weight, double height) {
		int index = owners.size() - 1;
		owners.get(index).addPet(name, type, age, weight, height);
	}
	

	
	/**
	*  This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*  <b> pre: </b> The client was created before. <br>
	*  <b> post: </b>The address and /or phone number of the client is updated. <br>
	*  @param The new address of the client. This param could be empty.
	*  @param The new phone number of the client. This param could be empty.
	*/
	public void updateClient() {
		
	}
	
	/**
	 * Hospitalizes a pet in a room. 
	 * @param ownerName
	 * @param petName
	 * @param day
	 * @param month
	 * @param year
	 * @param symptoms
	 * @param diagnosis
	 * @return
	 */
	public int hospitalizePet(String ownerName, String petName, int day, int month, int year, String symptoms, String diagnosis) {
		int status = 0;
		Owner owner = null;
		Pet pet = null;
		for(Owner o : owners) {
			if(o.getName().equals(ownerName)) {
				for(Pet p : o.getPets()) {
					if(p.getName().equals(petName)) {
						owner = o;
						pet = p;
					}
				}
			}
		}
		
		if(pet == null) {
			status = 1;
		} else {
			boolean success = false;
			for(int i = 0; i < MAX_ROOMS && !success; i++) {
				if(rooms[i].getAvailable()) {
					rooms[i].fillRoom(pet, owner, day, month, year, symptoms, diagnosis);
					status = 2;
					success = true;
				}
			}
			
		}
		
		return status;
	}
	
	/**
	 * Shows the records of all currently hospitalized animals <p>
	 * 
	 * <b> pre </b> <code> rooms != null </code>
	 * 
	 * @return A string with the record of all currently hospitalized animals
	 */
	public String showHospitalizedAnimalRecords() {
		String msg = "";
		for(int i = 0; i < MAX_ROOMS; i++) {
				msg += "\n" + rooms[i].getName() + ": \n";
				if(rooms[i].getRecord() != null) {
					msg += rooms[i].getRecord().fullReport();
				} else {
					msg += "EMPTY\n";
				}

			}
		
		return msg;
	}
	
	/**
	 * Finds the phone number given the owner's name
	 * <p>
	 * <b> pre: </b> <code> owners != null </code> <br> 
	 * 
	 * @param ownerName	The name of the owners whose phone number is desired
	 * @return			an int representing the owner's phone number
	 */
	public int findPhoneNumberWithOwnerName(String ownerName) {
		int phoneNumber = 0;
		for (Owner o : owners) {
			if(o.getName().equals(ownerName)) {
				phoneNumber = o.getPhoneNumber();
				break;
			}
		}
		
		return phoneNumber;
	}
	
	/**
	 * Find the phone number of an owners given his pet's name
	 * <p>
	 * <b> pre: </b> <code> owners != null </code> <br> 
	 * 
	 * @param petName	The name of the owner's pet
	 * @return			an int with the owner's phone number
	 */
	public int findPhoneNumberWithPetName(String petName) {
		int phoneNumber = 0;
		for(Owner o : owners) {
			
			for(Pet p : o.getPets()) {
				if(p.getName().equals(petName)) {
					phoneNumber = o.getPhoneNumber();
					break;
				}
			}
		}
		
		return phoneNumber;
	}
	
	/**
	 * Checks to see if the pet is currently hospitalized
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * 
	 * @param petName 	The name of the pet who may be hospitalized 
	 * 
	 * @return 		<code> true </code> if the pet is currently hospitalized, <code> false </code> if the pet is not 
	 * 				currently hospitalized
	 */
	public boolean isHospitalized(String petName) {
		boolean hospitalized = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet().getName().equals(petName)) {
				hospitalized = true;
				break;
			}
		}
		
		return hospitalized;
	}
	
	/**
	 * Calculates the cost of hospitalization of a particular pet
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * 
	 * @param petName	The name of the hospitalized pet
	 * @param day		The current day of the month
	 * @param month		The current month
	 * @param year		The current year
	 * @return			the cost of the pet's hospitalization
	 */
	public double calculateHospitalizationCost(String petName, int day, int month, int year) {
		double cost = 0;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					cost += rooms[i].calculateCost(day, month, year);
				}
			}
		}
		
		return cost;
		
	}
	
	/**
	 * Release a pet. Returns true if a pet is released successfully
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * <b> pre: </b> <code> histories != null </code> <br>
	 * 
	 * @param petName	The name of the hospitalized pet
	 * @param day		The current day of the month
	 * @param month		The current month 
	 * @param year		The current year
	 * @return			<code> true </code> if the pet was released successfully, <code> false </code> if it was not.
	 */
	public boolean releasePet(String petName, int day, int month, int year) {
		boolean success = false;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].getRecord().setState(Record.CLOSED);
					boolean foundPet = false;
					for(History h : histories) {
						if(h.getPetName().equals(petName)) {
							
							h.getRecords().add(rooms[i].getRecord());
							foundPet = true;
						}
					} if (!foundPet) {
						histories.add(new History(petName));
						histories.get(histories.size()-1).addRecord(rooms[i].getRecord());
					}
					
					revenue += calculateHospitalizationCost(petName, day, month, year);
					rooms[i].releasePet();
					
					success = true;
				}
			}
		}
		
		return success;
	}
	
	/**
	 * Checks how many rooms a pet currently occupies 
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * 
	 * @param petName The name of the hospitalized pet
	 * @return	an int representing the number of rooms the pet currently occupies
	 */
	public int howManyRooms(String petName) {
		int roomsNum = 0;
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(rooms[i].getCurrentPet() != null) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) 
					roomsNum++;
			}
		}
		return roomsNum;
	}
	
	/**
	 * Checks the record history of a pet 
	 * <p>
	 * <b> pre: </b> <code> histories != null </code> <br>
	 * @param petName
	 * @return	A pet containing the record history of the pet
	 */
	public String displayHistory(String petName) {
		
		String msg = "";
		boolean found = false;
		
		for(History h : histories) {
			if(h.getPetName().equals(petName)) {
				found = true;
				for(Record r : h.getRecords()) {
					msg += r.fullReport();
				}
			}
		}
		if(!found) {
			msg = petName + " does not have a record history in this clinic.";
		}
		
		return msg;
		
	}
	
	/**
	 * Finds a pet with the given name 
	 * <b> pre: </b> <code> owners != null </code> 
	 * 
	 * @param name	The name of the pet you want to find
	 * @return		The found pet. <code> null </code> if the pet is not found.
	 */
	public Pet findPetWithName(String name) {
		Pet foundPet = null;
		for(Owner o : owners) {
			for(Pet p : o.getPets()) {
				if(p.getName().equals(name))
					foundPet = p;
			}
		}
		
		return foundPet;
	}
	
	/**
	 * Finds an owner with the given name 
	 * <b> pre: </b> <code> owners != null </code> 
	 * 
	 * @param name	The name of the owner you want to find
	 * @return		The found owner. <code> null </code> if the owner is not found.
	 */
	public Owner findOwnerWithName(String name) {
		Owner foundOwner = null;
		for(Owner o : owners) {
			if(o.getName().equals(name))
				foundOwner = o;
		}
		
		return foundOwner;
	}
	
	//Getters
	public String getName() { return name; }
	public double getRevenue() { return revenue; }
	public ArrayList<Owner> getOwners() { return owners; }
	public ArrayList<History> getHistories() { return histories; }
	
	//Setters
	public void setName(String n) { name = n; }
	public void setRevenue(double rev) { revenue = rev; }
	public void setOwner(ArrayList<Owner> owns) { owners = owns; }
	public void setHistories(ArrayList<History> hs) { histories = hs; }	
}
