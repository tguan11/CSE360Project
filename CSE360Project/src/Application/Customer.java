package Application;

import java.io.File;
import java.util.Scanner;

public class Customer {

	private String email;
	private String ID;
	private String name;

	public Customer(String name, String email, String ID) {
		this.email = email;
		this.ID = ID;
		this.name = name;
	}

	public Customer() {
		email = "UNKNOWN";
		ID = "";
		name = "UNKNOWN";
	}

	public boolean verifyID() throws Exception {
		boolean b = false;
		File dataBase = new File("database.txt");
		Scanner scanner = new Scanner(dataBase);
		while (scanner.hasNextLine()) {
			String vaildID = scanner.nextLine();
			if (this.ID.equals(vaildID)) {
				b = true;
			}
		}
		scanner.close();
		return b;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getID() {
		return ID;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}

	public void setId(String newID) {
		ID = newID;
	}
}
