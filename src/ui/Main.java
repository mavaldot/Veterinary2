package ui;

import java.util.Scanner;

import model.Clinic;

/**
 * 
 * The main class. Contains the main
 * method and handles the input and the output.
 * 
 * @author Mateo Valdes
 *
 */

public class Main {

	private Clinic clinic;
	private Scanner s;
	
	/**
	 * Class constructor.
	 */
	public Main() {
		init();
	}
	
	/**
	 * Initializes the objects in the main class <p>
	 * <b>post:</b> clinic is initialized <br>
	 * <b>post:</b> Scanner is initialized
	 */
	public void init() {
		clinic = new Clinic("My Little Pet Veterinary Clinic");
		s = new Scanner(System.in);
	}
	
	/**
	 * Serves as the entry point of the program.
	 * 
	 * @param args		The command-line arguments.
	 */
	public static void main(String args[]) {
		
		Main m = new Main();
		m.setUp();
		m.run();
	}
	
	/**
	 * Sets up the clinic attribute
	 */
	public void setUp() {
		clinic.setUp();
	}
	
	/**
	 * 
	 * Ask the users for an int. If the user does not enter an int, this methods throws an exception and asks again.
	 * 
	 * @param prompt	the message the user will get
	 * @return			an int representing what the user has entered
	 * @throws			NumberFormatException
	 */
	public int askInt(String prompt) {
		boolean asking = true;
		int rValue = 0;
		
		while(asking) {
			System.out.println(prompt);
			String str = s.nextLine();
			try {
				rValue = Integer.parseInt(str);
				asking = false;
			} catch (NumberFormatException e) {
				System.out.println("ERROR. Please enter a number.");
			}

		}
		
		return rValue;
	}
	
	/**
	 * 
	 * Ask the users for a double. If the user does not enter a double, this methods throws an exception and asks again.
	 * 
	 * @param prompt	the message the user will get
	 * @return			a double representing what the user just entered
	 * @throws			NumberFormatException
	 */
	public double askDouble(String prompt) {
		boolean asking = true;
		double rValue = 0;
		
		while(asking) {
			System.out.println(prompt);
			String str = s.nextLine();
			try {
				rValue = Double.parseDouble(str);
				asking = false;
			} catch (NumberFormatException e) {
				System.out.println("ERROR. Please enter a number.");
			}

		}
		
		return rValue;
	}
	
	/**
	 * Handles the input and the output. Loops until <code> running = false </code>
	 * 
	 * @throws NumberFormatException
	 */
	public void run() {
		
		System.out.println("Welcome to " + clinic.getName() + "!");
		
		boolean running = true;
		boolean asking = false;
		Scanner s = new Scanner(System.in);
		
		while(running) {
			System.out.println("\nPlease pick an option:");
			System.out.println("1. Register a new human client and his/her pets");
			System.out.println("2. Hospitalize a pet");
			System.out.println("3. Display the records of all the currently hospitalized animals");
			System.out.println("4. Obtain the phone number of a pet's owner");
			System.out.println("5. Calculate the cost of a hospitalization");
			System.out.println("6. Release a pet from hospitalization");
			System.out.println("7. Check the clinic's revenue from hospitalization");
			System.out.println("8. Check how many rooms a pet occupies");
			System.out.println("9. Display the record history of a pet");
			System.out.println("10. Calculate the BMI of a pet");
			System.out.println("11. Update the basic data of the client");
			System.out.println("12. Add new prescribed medications to a hospitalized pet");
			System.out.println("13. Add new notes to a pet's possible diagnosis");
			System.out.println("14. Add a new symptom to a hosptalized pet");
			System.out.println("15. Check the revenue from services");
			System.out.println("16. Check the clinic's total revenue");
			System.out.println("17. Add a new service to the clinic");
			System.out.println("18. Check the average revenue for services");
			System.out.println("19. Check the clinic's revenue in a given week");
			System.out.println("20. Report the services performed within a given week");
			System.out.println("21. Quit");
			System.out.println("");
			
			String choice = s.nextLine();
			int choiceNum = 0;
			
			try {
				choiceNum = Integer.parseInt(choice);
			} catch(NumberFormatException e) {
				System.out.println("ERROR. Please enter a NUMBER.");
			}
			
			switch(choiceNum) {
			
			case 1:
				System.out.println("Please enter the name of the client");
				String name = s.nextLine();
				System.out.println("Please enter the ID of the client");
				String id = s.nextLine();
				System.out.println("Please enter the address of the client");
				String address = s.nextLine();
				int phoneNumber = askInt("Please enter the phone number of the client");
				
				clinic.addOwner(name, id, address, phoneNumber);
				
				boolean addingPets = true;
				
				while(addingPets) {
					
					System.out.println("Please enter the name of the pet");
					String petName = s.nextLine();
					System.out.println("Please enter the type of pet. (OPTIONS: cat, dog, bird, other)");
					String petType = s.nextLine();		
					int petAgeNum = askInt("Please enter the age of the pet.");
					double petWeightDouble = askDouble("Please enter the weight of the pet (in kilograms)");					
					double petHeightDouble = askDouble("Please enter the height of the pet (in meters)");
					
					clinic.addPet(petName, petType, petAgeNum, petWeightDouble, petHeightDouble);
					
					asking = true;
					while(asking) {
						System.out.println("Does this client have another pet?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						String ans = s.nextLine();
						int ansNum = 0;
						try {
							ansNum = Integer.parseInt(ans);
							
							switch(ansNum) {
							
							case 1:
								asking = false;
								System.out.println(" ");
								break;
								
							case 2:
								asking = false;
								addingPets = false;
								break;
								
							default:
								System.out.println("ERROR. PLEASE ENTER A VALID CHOICE");
								break;
							
							}
						} catch (NumberFormatException e) {
							System.out.println("ERROR. PLEASE ENTER A VALID CHOICE");
						}
						

					}
				}

				System.out.println("The client and his/her pets were added successfully.");
				
				break;
				
			case 2:
				
				System.out.println("Please enter the name of the pet you want to hospitalize");
				String petName = s.nextLine();
				
				//I ASK FOR THE NAME OF THE OWNER BECAUSE TWO DIFFERENT PETS CAN HAVE THE SAME NAME
				System.out.println("Please enter the name of the owner of this pet");
				String ownerName = s.nextLine();
				
				int day = askInt("Please enter the current day of the month");
				int month = askInt("Please enter the current month");
				int year = askInt("Please enter the current year");
				
				System.out.println("Please enter the symptoms");
				String symptoms = s.nextLine();
				
				System.out.println("Please enter the possible diagnosis");
				String diagnosis = s.nextLine();
				
				//IT IS AN INT BECAUSE THE MESSAGE I WILL SHOW DEPENDS ON THE INT THE FUNCTION RETURNS
				int hospitalizeStatus = clinic.hospitalizePet(ownerName, petName, day, month, year, symptoms, diagnosis);
				
				switch(hospitalizeStatus) {
				
				case 0:
					System.out.println("ERROR. There is no room available");
					break;
				case 1:
					System.out.println("ERROR. Could not find the pet.");
					break;
				case 2:

					System.out.println("The pet was hospitalized successfully");
					System.out.println("Was this pet prescribed any medication?");
					int medChoiceNum = 0;
					boolean askingMedication = true;
					while(askingMedication) {
						
						System.out.println("1. Yes");
						System.out.println("2. No");
						
						String medChoice = s.nextLine();
						try {
							medChoiceNum = Integer.parseInt(medChoice);
							switch(medChoiceNum) {
							
							case 1:
								System.out.println("Please enter the name of the medication");
								String medName = s.nextLine();	
								double doseDouble = 		askDouble("Please enter the dose of the medication");
								double costPerDoseDouble = 	askDouble("Please enter the cost per dose of the medication");
								double frequencyDouble = 	askDouble("Please enter the frequency (per day) of the medication");
								
								if(clinic.addMedication(petName, medName, doseDouble, costPerDoseDouble, frequencyDouble))
									System.out.println("The medication was added successfully");
								else
									System.out.println("ERROR. Could not add the medication");
								
								
								System.out.println("Was this pet prescribed any other medication?");
								break;
							case 2:
								askingMedication = false;
								break;
							default:
								System.out.println("ERROR. Please enter a valid number");
								break;
							}
						} catch (NumberFormatException e) {
							System.out.println("ERROR. Please enter a number.");
						}

					}		
					
					break;
				default:
					System.out.println("ERROR");
					break;
				
				}
				
				break;
				
			case 3:
				
				String msg = clinic.showHospitalizedAnimalRecords();
				System.out.println(msg);
				break;
				
			case 4:
				
				int nameChoiceNum = 0;
				asking = true;
				while(asking) {
					try {
						
						System.out.println("Do you know the owner's name or the pet's name?");
						System.out.println("1. Owner's name");
						System.out.println("2. Pet's name");
						String nameChoice = s.nextLine();
						nameChoiceNum = Integer.parseInt(nameChoice);
						switch(nameChoiceNum) {
						case 1:
							System.out.println("Please enter the name of the owner");
							String findOwnerName = s.nextLine();
							int phoneNumberO = clinic.findPhoneNumberWithOwnerName(findOwnerName);
							System.out.println(phoneNumberO);
							asking = false;
							break;
						case 2:
							System.out.println("Please enter the name of the pet");
							String findPetName = s.nextLine();
							int phoneNumberP = clinic.findPhoneNumberWithPetName(findPetName);
							System.out.println(phoneNumberP);
							asking = false;
							break;
						default:
							System.out.println("ERROR. Please enter a valid number");
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("ERROR. Please enter a number.");
					}
				}
				
				break;
				
			case 5:
				
				System.out.println("Please enter the name of the hospitalized pet");
				String hPetName = s.nextLine();
				
				int cday = 		askInt("Please enter the current day of the month");		
				int cmonth =	askInt("Please enter the current month");
				int cyear = 	askInt("Please enter the current year");
				
				if(clinic.isHospitalized(hPetName)) {
					double cost = clinic.calculateHospitalizationCost(hPetName, cday, cmonth, cyear);
					System.out.printf("The cost of this pet's hospitalization is %.2f COP\n", cost);
				} else {
					System.out.println("ERROR. There is no hospitalized pet named " + hPetName);
				}
				
				
				break;
				
			case 6:
				
				System.out.println("Please enter the name of the pet you want to release");
				String releasedPet = s.nextLine();
				
				int rday = askInt("Please enter the current day of the month");		
				int rmonth = askInt("Please enter the current month (a number between 1 and 12)");
				int ryear = askInt("Please enter the current year");
				
				if(clinic.releasePet(releasedPet, rday, rmonth, ryear)) {
					System.out.println("The pet was released successfully.");
				} else {
					System.out.println("ERROR. Could not find a pet with that name.");
				}
				
				break;
				
			case 7:
				
				System.out.printf("The total revenue from hospitalizations is is: $%.2f \n", clinic.getHRevenue());
				break;
				
			case 8:
				
				System.out.println("Please enter the name of the pet");
				String roomsPetName = s.nextLine();
				
				int rooms = clinic.howManyRooms(roomsPetName);
				
				System.out.println(roomsPetName + " occupies " + rooms + " rooms.");
				
				break;
				
			case 9:
				
				System.out.println("Please enter the name of the pet");
				String rPetName = s.nextLine();
				String history = clinic.displayHistory(rPetName);
				System.out.println(history);
				break;
				
			case 10:
					
				System.out.println("Please enter the name of the pet");
				String bmiPetName = s.nextLine();
				System.out.println(clinic.calculateBMI(bmiPetName));
				
				break;
				
			case 11:
				
				System.out.println("Please enter the name of the pet owner");
				String updatePetOwner = s.nextLine();
				System.out.println("Please enter the new address. If unknown, enter 0");
				String newAddress = s.nextLine();
				int newPhoneNum = askInt("Please enter the new phone number. If unknown, enter 0");
				System.out.println(clinic.updateOwnerData(newAddress, newPhoneNum, updatePetOwner));
				
				break;
				
			case 12:
				
				break;
				
			case 13:
				
				break;
				
			case 14:
				
				break;
				
			case 15:
				
				System.out.println("The clinic's total revenue from services is: $" + clinic.calculateServiceRevenue() + ".");
				
				break;
				
			case 16:
				
				System.out.printf("The clinic's total revenue is: $%.2f \n", clinic.getHRevenue() + clinic.calculateServiceRevenue());
				break;
				
			case 17:
				
				int stype = 	askInt("Please enter the type of service. OPTIONS:\n"
								+ "1. Bath\n"
								+ "2. Home delivery bath\n"
								+ "3. Dental prophylaxis\n"
								+ "4. Vaccination\n");
				int sday = 		askInt("Please enter the day of the month the service was performed.");
				int smonth = 	askInt("Please enter the month the service was performed.");
				int syear = 	askInt("Please enter the year the service was performed.");
				
				System.out.println("Please enter the name of the pet.");
				String sPetName = s.nextLine();
		
				System.out.println(clinic.addService(stype, sday, smonth, syear, sPetName));
				
				break;
				
			case 18:
				
				System.out.printf("The clinic's average revenue from services is: $%.2f \n", clinic.calculateAvgServiceRevenue());
				break;
				
			case 19:
				
				
				break;
				
			case 20:
				
				
				break;
				
			case 21:
				running = false;
				System.out.println("Goodbye");
				break;
				
			default:
				
				System.out.println("PLEASE ENTER A VALID CHOICE.");
				break;
			}	
		}
	}
}
