package Application;

public class Pizza {
	// Declare variables
	private String type;
	private boolean topics[] = new boolean[4];
	private double cost;

	// Pizza Constructor
	public Pizza(String type, boolean topics[], double cost) {
		this.type = type;
		this.topics = topics;
		this.cost = cost;
	}

	// Default Pizza Constructor
	public Pizza() {
		type = "";
		topics[0] = false;
		topics[1] = false;
		topics[2] = false;
		topics[3] = false;
		cost = 0;
	}

	// Defines Type of pizza ordered
	public void setType(String newType) {
		type = newType;
	}

	// Defines Pizza topics
	public void setTopics(boolean newtopics[]) {
		topics = newtopics;
	}

	// Defines Cost of Pizza
	public void setCost(double newCost) {
		cost = newCost;
	}

	// Returns cost of pizza
	public double getCost() {
		return cost;
	}

	// Returns type of pizza
	public String getType() {
		return type;
	}

	// Returns topics on pizza
	public String getTopics() {
		String topicsList = "";
		if (topics[0]) {
			topicsList += "Onions\n";
		}
		if (topics[1]) {
			topicsList += "Mushroom\n";
		}
		if (topics[2]) {
			topicsList += "Olives\n";
		}
		if (topics[3]) {
			topicsList += "Extra Cheese\n";
		}
		return topicsList;
	}
}
