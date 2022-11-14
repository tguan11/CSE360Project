package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlaceOrder extends JPanel {
	private JButton CheckOutButton;
	private JLabel pizza_types, pizza_topics;
	private JPanel pizza2_panel, topic1_panel, topic2_panel;

	String pizzaType = "";
	boolean topics[] = new boolean[4];
	double total = 0;
	private ButtonGroup types;
	private JRadioButton pepperoni, cheese, veggie;
	private JPanel top1_panel, top2_panel, pizza_panel;
	private JCheckBox mush, onion, olives, exChs;

	public PlaceOrder(JFrame frame) {
		// button
		CheckOutButton = new JButton("Check out");
		CheckOutButton.addActionListener(new ButtonListener(frame));
		pizza2_panel = new JPanel();
		pizza2_panel.setLayout(new GridLayout(10, 10, 10, 10));

		pizza_panel = new JPanel();
		pizza_panel.setLayout(new GridLayout(1, 3));

		// Delivery Type
		pizza_types = new JLabel("Pizza Type:");

		pepperoni = new JRadioButton("Pepperoni"); //Add different ingredients
		cheese = new JRadioButton("Cheese");
		veggie = new JRadioButton("Veggie");
		pepperoni.setActionCommand(pizzaType = "Pepperoni");
		cheese.setActionCommand(pizzaType = "Cheese");
		veggie.setActionCommand(pizzaType = "Veggie");





		// adding the elements
		types = new ButtonGroup();
		types.add(pepperoni);
		types.add(cheese);
		types.add(veggie);
		pizza_panel.add(pepperoni);
		pizza_panel.add(cheese);
		pizza_panel.add(veggie);

		pizza2_panel.add(pizza_types);
		pizza2_panel.add(pizza_panel);
		add(pizza_types);
		add(pizza_panel);

		top1_panel = new JPanel();
		top2_panel = new JPanel();
		topic1_panel = new JPanel();
		topic2_panel = new JPanel();

		pizza_topics = new JLabel("Toppings:");

		onion = new JCheckBox("Onion", false);
		mush = new JCheckBox("Mushroom", false);
		olives = new JCheckBox("Olives", false);
		exChs = new JCheckBox("Cheese", false);

		ItemListener onionButton = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					topics[0] = true;
					total += 1.50;  
//Price changes after adding or removing items
				}
				if (state == ItemEvent.DESELECTED) {
					topics[0] = false;
					total -= 1.50;//Price changes after adding or removing items
				}
			}
		};
		ItemListener mushButton = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					topics[1] = true;
					total += 1.50;//Price changes after adding or removing items
				}
				if (state == ItemEvent.DESELECTED) {
					topics[1] = false;
					total -= 1.50;//Price changes after adding or removing items
				}
			}
		};
		ItemListener olivesButton = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					topics[2] = true;
					total += 1.50;//Price changes after adding or removing items
				}
				if (state == ItemEvent.DESELECTED) {
					topics[2] = false;
					total -= 1.50;//Price changes after adding or removing items
				}
			}
		};
		ItemListener exchsButton = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					topics[3] = true;
					total += 1.50;//Price changes after adding or removing items
				}
				if (state == ItemEvent.DESELECTED) {
					topics[3] = false;
					total -= 1.50;//Price changes after adding or removing items
				}
			}
		};

		onion.addItemListener(onionButton);
		mush.addItemListener(mushButton);
		olives.addItemListener(olivesButton);
		exChs.addItemListener(exchsButton);

		top1_panel.add(onion);
		top1_panel.add(mush);
		top2_panel.add(olives);
		top2_panel.add(exChs);
		topic1_panel.add(top1_panel);
		topic1_panel.add(top2_panel);
		topic2_panel.add(pizza_topics);
		topic2_panel.add(topic1_panel);
		add(topic2_panel);
		add(CheckOutButton);
	}

	public class ButtonListener implements ActionListener {
		private JFrame frame;

		public ButtonListener(JFrame frame) {
			this.frame = frame;

		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (pepperoni.isSelected()) {
				total += 12;
				pizzaType = "Pepperoni";
			} else if (cheese.isSelected()) {
				total += 10;
				pizzaType = "Cheese";
			} else if (veggie.isSelected()) {
				total += 15;
				pizzaType = "Veggie";
			} //Different types match different prices
			Pizza newPizza = new Pizza(pizzaType, topics, total);

			// remove the elements
			remove(CheckOutButton);
			remove(pizza_panel);
			remove(topic2_panel);
			remove(pizza_types);
			remove(topic2_panel);

			CheckOutPanel checkoutpanel = new CheckOutPanel(frame, newPizza);
			frame.getContentPane().add(checkoutpanel);
			frame.pack();
			frame.setVisible(true);
		}
	}
}
