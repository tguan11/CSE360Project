package Application;


public class Order {
	private static int currentNum = 1;
	private Pizza pizza;
	private Customer customer;
	private int orderProgress;
	private int orderNumber;
	
	public Order(Pizza pizza, Customer customer) {
		this.pizza = pizza;
		this.customer = customer;
		orderProgress = 0;
		orderNumber = currentNum;
		currentNum++;
	}


	public Order() {
		
	}
	// returns cost of pizza
	public double getCost() {
		return pizza.getCost();
	}

	//returns order num
	public int getOrderNum() {
		return orderNumber;
	}
	// sets the next stage of the order process
	public void nextStage() {
		if(orderProgress != 3) {
			orderProgress++;
		}
	} 
	// sets the order progress
	public void setOrderProgress(int newOrderProgress) {
		this.orderProgress = newOrderProgress;
		
	}
	// returns the order progress
	public int getOrderProgress() {
		return this.orderProgress;
	}

	// returns the customer email
	public String getCustomerEmail() {
		return customer.getEmail();
	}
	public String getCustomerName() {
		return customer.getName();
	}
	
	public String getPizzaType() {
		return pizza.getType();
	}
	public String getPizzatopics() {
		return pizza.getTopics();
	}

}

