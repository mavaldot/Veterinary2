package model;

import java.util.ArrayList;

/**
 * 
 * Models the medical record of a pet that is or has been hospitalized in the clinic.
 * 
 * @author Mateo Valdes
 *
 */
public class Record {

	//Static attributes
	public static final int CLOSED = 0;
	public static final int OPEN = 1;
	
	//Non-static attributes
	private int state;
	private Pet pet;
	private Owner owner;
	private Date dateOfEntry;
	private String symptoms;
	private String diagnosis;
	private ArrayList<Medication> medications;
	
	/**
	 * Class Constructor
	 * 
	 * @param st	state of the record
	 * @param pt	The pet whose record is being created
	 * @param own	The owner of the pet
	 * @param doe	The pet's date of entry
	 * @param symp	The pet's symptoms
	 * @param d		The pet's diagnosis
	 */
	public Record(int st, Pet pt, Owner own, Date doe, String symp, String d) {
		state = st;
		pet = pt;
		owner = own;
		dateOfEntry = doe;
		symptoms = symp;
		diagnosis = d;
		medications = new ArrayList<Medication>();
	}
	
	/**
	 * The full report of the record, which contains the pet's information, the pet's owner's informations, the date of entry,
	 * the pet's symptoms, the pet's diagnosis and the pet's prescribed medication
	 * <p>
	 * <b> pre: </b> <code> pet != null </code> <br>
	 * <b> pre: </b> <code> owner != null </code> <br>
	 * <b> pre: </b> <code> dateOfEntry != null </code> <br>
	 * 
	 * @return A string with the full report
	 */
	public String fullReport() {
		String msg = "";
		msg += "\nState: ";
		if(state == CLOSED) {
			msg += "CLOSED\n";
		} else if(state == OPEN) {
			msg += "OPEN\n";
		}
		msg += "\nPet info: \n";
		msg += pet.fullReport();
		msg += "Date of entry: " + dateOfEntry.reportDate();
		msg += "\nOwner info: \n";
		msg += owner.fullReport();
		msg += "\nSymptoms: " + symptoms + "\n";
		msg += "Diagnosis: " + diagnosis + "\n";
		if(medications != null) {
			msg += "\nMedications info: \n";
			for(Medication m : medications) {
				m.fullReport();
			}
		} else {
			msg += "\nMedications: None\n";
		}
		
		return msg;
		
	}
	
	/**
	 * Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	 * <p>
	 * <b> pre: </b> <code> medication != null </code> <br>
	 * <b> post: </b> New medicines were added to the patient clinic story. <br>
	 * @param The medicine name. This param must be not null.
	 * @param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
	 * @param The medicine cost by each dose. This param could be empty.
	 * @param The frequency of medicine application. This param could be empty.
	 */
	public void addNewMedication(String name, double dose, double cost, double frequency) {
		
		medications.add(new Medication(name, dose, cost, frequency));
		
	}
	
	/**
	 * Adds a new possible diagnosis to the pet's list of diagnosis 
	 * <p>
	 * <b> post: </b> A new possible diagnosis is added to the pet's list of diagnosis
	 * @param newDiagnosis	The new diagnosis
	 */
	public void addDiagnosis(String newDiagnosis) {
		diagnosis += newDiagnosis + "\n";
	}

	/**
	 * Adds a new symptom to the pet's list of symptoms 
	 * <p>
	 * <b> post: </b> A new symptom is added to the pet's list of symptoms
	 * @param newSymptom	The new symptom presented by the pet
	 */
	public void addSymptom(String newSymptom) {
		symptoms += newSymptom + "\n";
	}
	
	//Getters
	public int getState() { return state; }
	public Pet getPet() { return pet; }
	public Owner getOwner() { return owner; }
	public Date getDateOfEntry() { return dateOfEntry; }
	public String getSymptoms() { return symptoms; }
	public String getDiagnostic() { return diagnosis; }
	public ArrayList<Medication> getMedications() { return medications; }
	
	//Setters
	public void setState(int st) { state = st; }
	public void setPet (Pet pt) { pet = pt; }
	public void setOwner(Owner ownr) { owner = ownr; }
	public void setDateOfEntry(Date dt) { dateOfEntry = dt; }
	public void setSymptoms(String symp) { symptoms = symp; }
	public void setDiagnosis(String diag) { diagnosis = diag; }
	public void setMedications(ArrayList<Medication> md) { medications = md; }

	/**
	 * Calculates the cost of the pet's hospitalization
	 * <p>
	 * <b> pre: </b> <code> medications != null </code> <br>
	 * @param day	The current day of the month
	 * @param month	The current month
	 * @param year	The current year
	 * @return		A double with the total cost of the pet's hospitalization
	 */
	public double calculateCost(int day, int month, int year) {
		double cost = 0;

		int days = 0;
		int entryDay = dateOfEntry.getDay();
		int entryMonth = dateOfEntry.getMonth();
		int entryYear = dateOfEntry.getYear();
		
		while(entryYear < year) {
			if(entryMonth == 1) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 2) {
				while(entryDay <= 28) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 3) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 4) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 5) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 6) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 7) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 8) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 9) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 10) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 11) {
				while(entryDay <= 30) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth++;
			}
			else if(entryMonth == 12) {
				while(entryDay <= 31) {
					entryDay++;
					days++;
				}
				entryDay = 1;
				entryMonth = 1;
				entryYear++;
			}
		}
		
		if(year == entryYear) {
			while(entryMonth < month) {
				if(entryMonth == 1) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 2) {
					while(entryDay <= 28) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 3) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 4) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 5) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 6) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 7) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 8) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 9) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 10) {
					while(entryDay <= 31) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				else if(entryMonth == 11) {
					while(entryDay <= 30) {
						entryDay++;
						days++;
					}
					entryDay = 1;
					entryMonth++;
				}
				
			}
			if(entryMonth == month) {
				while(entryDay < day) {
					entryDay++;
					days++;
				}
			}
		}
		
		double weight = pet.getWeight();
		
		if(pet.getType().equals(Pet.CAT)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 12000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 15000 *  days;
			} else if(weight > 20) {
				cost = 20000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.DOG)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 15000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 17000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 20000 *  days;
			} else if(weight > 20) {
				cost = 25000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.BIRD)) {
			
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 12000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 20000 *  days;
			} else if(weight > 20) {
				cost = 25000 * days;
			} else {
				cost = 0;
			}
			
		} else if(pet.getType().equals(Pet.OTHER)) {
		
			if(weight >= 1 && weight <= 3) {
				cost = 10000 * days;
			} else if(weight > 3 && weight <= 10) {
				cost = 17000 * days;
			} else if(weight > 10 && weight <= 20) {
				cost = 30000 *  days;
			} else if(weight > 20) {
				cost = 30000 * days;
			} else {
				cost = 0;
			}
		}
		
		for(Medication m : medications) {
			cost += days * m.getDose() * m.getCostPerDose() * m.getFrequency();
		}
		
		return cost;
	}
	
}
	
