package model;

public class Service {

	//Static attributes
	public static final int BANO = 1;
	public static final int BANOADOMICILO = 2;
	public static final int CORTEDEUNANS = 3;
	public static final int PROFILAXISDENTAL = 4;
	public static final int APLICACIONVACUNA = 5;
	
	//Non-static attributes
	private int type;
	private double cost;
	private Date serviceDate;
	private Pet pet;
	private Owner owner;
	
	public Service(int typ, double cst, Date sd, Pet pt, Owner own) {
		
		
	}
		
	
}
