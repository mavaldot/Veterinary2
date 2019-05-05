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
	private double hRevenue;
	private int petNum;
	
	private Room[] rooms;
	
	private ArrayList<Owner> owners;
	private ArrayList<History> histories;
	private ArrayList<Service> services;
	
	/**
	 * Class constructor
	 * <p>
	 * <b> post: </b> The room array is initialized <br>
	 * <b> post: </b> The histories arraylist is initialized. <br>
	 * <b> post: </b> The owners arraylist is initialized. <br>
	 * <b> post: </b> The services arraylist is initialized. <br>
	 * @param n		The name of the clinic
	 */
	public Clinic(String n) {
		
		name = n;
		hRevenue = 0;
		petNum = 0;
		
		rooms = new Room[MAX_ROOMS];

		histories = new ArrayList<History>();
		owners = new ArrayList<Owner>();
		services = new ArrayList<Service>();
		
	}
	
	/**
	 * Sets up the rooms of the clinic to be empty and available.
	 */
	public void setUp() {
		for(int i = 0; i < MAX_ROOMS; i++) {
			rooms[i] = new Room("Room " + (i+1), null, null, true);
		}
		
		
		addOwner("Johan", "10045675", "Calle 5 # 121 - 34", 5554345);
		addPet("Max", Pet.DOG, 5, 43.5, 65.6);
		addPet("Li", Pet.BIRD, 3, 3.2, 3.4);
		addOwner("Esteban", "10087654", "Calle 5 # 150 - 67", 5556787);
		addPet("Ko", Pet.CAT, 4, 5.5, 7.6);
		addPet("Bu", Pet.OTHER, 1, 2.2, 9.4);
		
		
		
		addService(Service.BATH, 4, 5, 2017, "Max");
		addService(Service.DENTALPROPHYLAXIS, 12, 1, 2019, "Li");
		addService(Service.HOMEBATH, 24, 7, 2018, "Ko");
	}
	
	/**
	 * Asigns a new medication to a pet in a room.
	 * <p>
	 * <b> pre: </b> <code> rooms != null </code> <br>
	 * <b> pre: </b> <code> rooms.length </code> must be greater than or equal to 8 <br>
	 * <b>post: </b> One new medication is assigned to a pet in a room
	 * <p>
	 * @param petName		the name of the pet who will be assigned a new medicine
	 * @param medName		the name of the medication
	 * @param dose 			the dose of the medication
	 * @param costPerDose	the cost of each dose of the medication
	 * @param frequency 	The frequency (per day) of the medication
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
	 * @param height 	The height of the pet in meters
	 */
	public void addPet(String name, String type, int age, double weight, double height) {
		petNum++;
		int index = owners.size() - 1;
		owners.get(index).addPet(name, type, petNum, age, weight, height);
	}
	
	/**
	 * Hospitalizes a pet in a room. 
	 * @param ownerName The name of the pet's owner
	 * @param petName The name of the pet
	 * @param day The day of the month
	 * @param month The month
	 * @param year The year
	 * @param symptoms The symptoms presented by the pet
	 * @param diagnosis The pet's diagnosis
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
					
					hRevenue += calculateHospitalizationCost(petName, day, month, year);
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
	 * @param petName The name of the pet
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
	 * Adds a new service to the 
	 * <p>
	 * <b> pre: </b> <code> owners != null </code> <br>
	 * <b> post: </b> a new service is added to the clinic's list of services. <br>
	 * @param type		The type of service
	 * @param day		The day the service was performed
	 * @param month		The month the service was performed
	 * @param year		The year the service was performed
	 * @param petName	The name of the pet who received the service
	 * @return 		A string informing the user whether the service was added successfully or not
	 */
	public String addService(int type, int day, int month, int year, String petName) {
		
		String msg = "";
		
		boolean found = false;
		int petID = 0;
		String ownerID = "";
		
		for(Owner o : owners) {
			for(Pet p : o.getPets()) {
				if(p.getName().equals(petName)) {
					found = true;
					petID = p.getID();
					ownerID = o.getID();
				}
			}
		}
		
		if(found) {
			msg = "The service was added succssfully!";
			services.add(new Service(type, new Date(day, month, year), petID, ownerID));	
		} else {
			msg = "ERROR. Could not find a pet named " + petName + "in this clinic.";
		}
		
		return msg;
		
	}
	
	/**
	 * Calculates the total revenue from all the performed services
	 * <p>
	 * <b> pre: </b> <code> services != null </code> 
	 * @return A double containing the clinic's total revenue from services
	 */
	public double calculateServiceRevenue() {
		
		double revenue = 0;
		
		for(Service s : services) {
			revenue += s.calculateCost();
		}
		
		return revenue;
	}
	
	/**
	 * Calculates the average service revenue by taking the total revenue from services and dividing it by the total number of services performed
	 * 
	 * @return a double with the average service revenue
	 * @throws ArithmeticException
	 */
	public double calculateAvgServiceRevenue() {
		
		double tRevenue = calculateServiceRevenue();
		double avgRevenue = 0;
		
		try {
			avgRevenue = tRevenue / services.size();
		} catch (ArithmeticException e) {
			avgRevenue = 0;
		}
		
		return avgRevenue;
		
	}
	
	/**
	 *	This method allows to calculate the body mass index for a given pet.
	 *	<p>
	 *	<b> pre: </b> The pet was created before and its attributes height and weight are not null neither height must be zero. <br>
	 *	<b> post: </b> The BMI is calculated. <br>
	 *	@param petName The name of the pet whose BMI is desired.
	 *	@return A String containing the pet's body mass index. If the pet is not found, the user is notified
	 */
	public String calculateBMI(String petName) {
					
		String msg = "";
		boolean found = false;
		double bmi = 0;
		
		for(Owner o : owners) {
			for(Pet p : o.getPets()) {
				if(p.getName().equals(petName)) {
					found = true;
					bmi = p.calculateBMI();
				}
			}
		}
		
		if(found) 
			msg = "The pet's BMI is " + bmi;
		else
			msg = "The pet named " + petName + " was not found in this clinic.";
		
		return msg;
		
	}
	
	
	
	/**
	 * Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	 * <p>
	 * <b> pre: </b> <code> owners != null </code> <br> 
	 * <b> post: </b> The address and /or phone number of the client is updated. <br>
	 * @param addr The new address of the client. This param could be empty.
	 * @param phoneNum The new phone number of the client. This param could be empty.
	 * @param oName The name of the owner whose data will be updated
	 * @return A message informing the user if the pet owner's information was updated successfully
	 */
	public String updateOwnerData(String addr, int phoneNum, String oName) {
		
		String msg = "";
		boolean found = false;
		
		for(Owner o : owners) {
			if(o.getName().equals(oName)) {
				found = true;
				o.updateData(addr, phoneNum);
			}	
		}
		
		if(found) 
			msg = "The client information was updated successfully.";
		else
			msg = "The pet owner named " + oName + " was not found.";
		
		return msg;
		
	}
	
	/**
	 * Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	 * <p>
	 * <b> pre: </b> <code> owners != null </code> <br>
	 * <b> post: </b> New medicines were added to the patient clinic story.
	 * @param petName The pet's name. This param must not be null.
	 * @param name The medicine name. This param must be not null.
	 * @param dose The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
	 * @param cost The medicine cost by each dose. This param could be empty.
	 * @param frequency The frequency of medicine application. This param could be empty.
	 * @return A message that indiques if medicine was added to the patient clinic story
	 */
	public String addNewMedication(String petName, String medName, double dose, double cost, double frequency) {
		
		String msg = "";
		boolean found = false;
		
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(!rooms[i].getAvailable()) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					msg = rooms[i].addNewMedication(medName, dose, cost, frequency);
					found = true;
				}
			}
		}
		
		if(!found) {
			msg = "There is no pet named " + petName + " currently hospitalized in this veterinary clinic";
		}
		
		return msg;
	}
	
	/**
	 * Adds a new possible diagnosis to a hospitalized pet
	 * <p>
	 * <b> post: </b> The pet's diagnosis is updated
	 * 
	 * @param petName		The name of the pet whose new possible diagnosis will be added
	 * @param newDiagnosis	The new diagnosis that will be added to the pet's record
	 * @return	A String indicating whether it was possible to add the new diagnosis to the hospitalized pet's record
	 */
	public String addNewDiagnosis(String petName, String newDiagnosis) {
		
		String msg = "";
		boolean found = false;
		
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(!rooms[i].getAvailable()) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].addNewDiagnosis(newDiagnosis);
					found = true;
				}
			}
		}
		
		if(found)
			msg = "The new diagnosis was added successfully";
		else
			msg = "There is no pet named " + petName + " currently hospitalized in this veterinary clinic";
		
		return msg;
		
	}
	
	/**
	 * Adds a new symptom to a hospitalized pet's list of symptoms
	 * <p>
	 * <b> post: </b> The pet's symptom is updated
	 * 
	 * @param petName		The name of the pet whose new symptom will be added
	 * @param newDiagnosis	The new symptom that will be added to the pet's record
	 * @return	A String indicating whether it was possible to add the new symptom to the hospitalized pet's record
	 */
	public String addNewSymptom(String petName, String newSymptom) {
		
		String msg = "";
		boolean found = false;
		
		for(int i = 0; i < MAX_ROOMS; i++) {
			if(!rooms[i].getAvailable()) {
				if(rooms[i].getCurrentPet().getName().equals(petName)) {
					rooms[i].addNewSymptom(newSymptom);
					found = true;
				}
			}
		}
		
		if(found)
			msg = "The new symptom was added successfully";
		else
			msg = "There is no pet named " + petName + " currently hospitalized in this veterinary clinic";
		
		return msg;
		
	}
	
	/**
	 * Calculates the service revenue in a given week
	 * <p>
	 * <b> pre: </b> <code> services != null </code>
	 * 
	 * @param day		The day of the month when the week starts
	 * @param month		The month when the week starts
	 * @param year		The year when the week starts
	 * @return			The total revenue in the given week
	 */
	public double calculateWeekServiceRevenue(int day, int month, int year) {

		double wRevenue = 0;
		
		Date date = new Date(day, month, year);
		int dateInt = date.toInt();
		
		for(Service s : services) {
			int sDate = s.getDate().toInt();
			if(sDate > dateInt && sDate < (dateInt + 6) )
				;
		}
		
		return wRevenue;
		
	} 
	
	/**
	 * Determines if a service has been performed within the given timeframe and gives 
	 * a full report of the service.
	 * 
	 * @param minD	Day of the month when the time frame begins
	 * @param minM	Month when the time frame begins
	 * @param minY	Year when the time frame begins
	 * @param maxD	Day of the month when the time frame ends
	 * @param maxM	Month when the time frame ends
	 * @param maxY	Year when the time frame ends
	 * @return		A full report of all the services performed by the clinic within that time frame
	 */
	public String reportServicesWithinRange(int minD, int minM, int minY, int maxD, int maxM, int maxY) {
		Date minDate = new Date(minD, minM, minY);
		Date maxDate = new Date(maxD, maxM, maxY);
		
		int min = minDate.toInt();
		int max = maxDate.toInt();
		
		int sNum = 0;
		
		System.out.println(min);
		System.out.println(max);
		
		String msg = "The services within that time frame are: \n\n";
		
		for(Service s : services) {
			int sDate = s.getDate().toInt();
			System.out.println(sDate);
			if(sDate > min && sDate < max) {
				sNum++;
				msg += "Service #" + sNum + ":\n";
				msg += s.fullReport() + "\n";
			}
		}
		
		
		
		if(sNum == 0)
			msg = "There are no services within that time frame.";
		
		return msg;
	}
	
	//Getters
	/**
	 * Returns the full name of the clinic
	 * 
	 * @return The name of the clinic
	 */
	public String getName() { return name; }
	
	/**
	 * Returns the clinic's total revenue from hospitalization
	 * 
	 * @return A double with the total revenue from hospitalization 
	 */
	public double getHRevenue() { return hRevenue; }
	
}
