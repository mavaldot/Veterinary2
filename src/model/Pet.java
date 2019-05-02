package model;

public class Pet {
	
	//Static attributes
	public static final String CAT = "cat";
	public static final String DOG = "dog";
	public static final String BIRD = "bird";
	public static final String OTHER = "other";
	
	//Non-static attributes
	private String name;
	private String type;
	private int age;
	private int id;
	private double weight;
	private double height;
	private double bmi;
	
	/**
	 * Class constructor
	 * 
	 * @param n	The name of the pet
	 * @param t	The type of the pet
	 * @param i The id of the pet
	 * @param a	The age of the pet
	 * @param w	The weight of the pet
	 * @param h	The height of the pet
	 */
	public Pet(String n, String t, int i, int a, double w, double h) {
		name = n;
		type = t;
		id = i;
		age = a;
		weight = w;
		height = h;
		bmi = 0;
	}
	
	/**
	 * Create a full report of all the attributes of the pet. <br>
	 * Reports: The name, the type, the age and the weight.
	 * 
	 * @return A string containing a report of all the attributes of the pet.
	 */
	public String fullReport() {
		String report = "";
		report += "Name: " + name + "\n";
		report += "Type: " + type + "\n";
		report += "Age: " + age + "\n";
		report += "Weight: " + weight + "\n";
		
		return report;
	}
	
	/**
	*	This method allows to calculate the body mass index for a pet.
	*	<p>
	*	<b> pre: </b> The pet was created before and its attributes height and weight are not null neither height must be zero. <br>
	*	<b> post: </b> The BMI is calculated. <br>
	*	@return The pet body mass index.
	*	@throws  If the height is zero, so an exception is thrown due to the division on zero does not exist.
	*/
	double calculateBMI() {
		double rBMI = 0;
		
		try {
			rBMI = weight / (height * height);
		} catch (ArithmeticException e) {
																					
		}
		
		bmi = rBMI;
		
		return bmi;
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
	public int getID() { return id; }
	
	public String getType() { return type; }
	public int getAge() { return age; }
	public double getWeight() { return weight; }
	public double getHeight() { return height; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setType(String type) { this.type = type; }
	public void setAge(int age) { this.age = age; }
	public void setWeight(double weight) { this.weight = weight; }
	public void setHeight(double height) { this.height = height; }
	
}
