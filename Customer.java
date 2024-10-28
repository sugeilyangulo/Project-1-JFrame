package labs.lab9;

/**
 * Represents a single customer.
 */
public class Customer {
	
	private String name, email, location, notes, amount;
	private boolean dog, cat, bird, fish, other;

	/**
	 * Constructs a Customer
	 * 
	 * @param name    customer name
	 * @param email   email
	 * @param dog  	  dog 
	 * @param cat	  cat
	 * @param bird    bird
	 * @param fish    fish
	 * @param other   other
	 * @param amount  total amount spent
	 * @param location home store location
	 * @param notes    notes
	 */
	public Customer(String name, String email, boolean dog, boolean cat, boolean bird, boolean fish, boolean other,
			String amount, String location, String notes) {
		
		this.name = name;
		this.email = email;
		this.dog = dog;
		this.cat = cat;
		this.bird = bird;
		this.fish = fish;
		this.other = other;
		this.amount = amount;
		this.location = location;
		this.notes = notes;
	}

	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * @return dog
	 */
	public boolean getDog() {
		return dog;
	}

	
	/**
	 * @return cat
	 */
	public boolean getCat() {
		return cat;
	}

	
	/**
	 * @return bird
	 */
	public boolean getBird() {
		return bird;
	}
	
	/**
	 * @return fish
	 */
	public boolean getFish() {
		return fish;
	}
	
	/**
	 * @return other
	 */
	public boolean getOther() {
		return other;
	}
	
	/**
	 * @return amount
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * @return notes
	 */
	public String getNotes() {
		return notes;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDog(Boolean dog) {
		this.dog = dog;
	}
	
	public void setCat(Boolean cat) {
		this.cat = cat;
	}
	
	public void setBird(Boolean bird) {
		this.bird = bird;
	}
	
	public void setFish(Boolean fish) {
		this.fish = fish;
	}
	
	public void setOther(Boolean other) {
		this.other = other;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
