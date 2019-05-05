package model;

import java.util.ArrayList;

/**
 * 
 * Contains all the records of a particular pet
 * 
 * @author Mateo
 *
 */
public class History {

	//Attributes
	private String petName;
	private ArrayList<Record> records;
	
	/**
	 * Class constructor. Creates a history for the pet whose name was inputted.
	 * 
	 * @param name	The name of the pet
	 */
	public History(String name) {
		petName = name;
		records = new ArrayList<Record>();
	}
	
	/**
	 * Adds a new record to this history
	 * <p>
	 * <b> pre: </b> <code> records != null </code> <br>
	 * <b> post: </b> A new record is added to this history
	 * 
	 * @param record	The record object that is to be added to this history
	 */
	public void addRecord(Record record) {
		records.add(record);
	}
	
	//Getters
	public String getPetName() { return petName; }
	public ArrayList<Record> getRecords() { return records; }
	
	//Setters
	public void setPetName(String name) { petName = name; }
	public void setRecords(ArrayList<Record> rs) { records = rs; }
	
}
