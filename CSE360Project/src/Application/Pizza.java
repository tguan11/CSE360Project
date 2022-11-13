package Application;

public class Pizza {
	//Declare variables
	private String type;
	private boolean topping[] = new boolean[4];
	private double cost;
	
	//Pizza Constructor
	public Pizza(String type, boolean topping[], double cost) {
		this.type = type;
		this.topping = topping;
		this.cost = cost;
	}
	
	//Default Pizza Constructor
	public Pizza() {
		type = "UNKOWN";
		topping[0] = false; topping[1] = false; topping[2] = false; topping[3] = false;
		cost = 0;
	}
	
	//Defines Type of pizza ordered
	public void setType(String newType) {
		type = newType;
	}
	
	//Defines Pizza Topping
	public void setTopping(boolean newTopping[]) {
		topping = newTopping;
	}

	//Defines Cost of Pizza
	public void setCost(double newCost) {
		cost = newCost;
	}

	//Returns cost of pizza
	public double getCost(){
		return cost;
	}

	//Returns type of pizza
	public String getType() {
		return type;
	}
	
	//Returns topping on pizza
	public String getTopping() {
		String toppingList = "";
		if(topping[0]){
			toppingList += "Onions\n";
		}
		if(topping[1]){
			toppingList += "Mushroom\n";
		}
		if(topping[2]){
			toppingList += "Olives\n";
		}
		if(topping[3]){
			toppingList += "Extra Cheese\n";
		}
		return toppingList;
	}
}
