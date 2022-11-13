package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel {
	private JButton PayButton;
	private JLabel pizza_types, pizza_topics;
	private JPanel pizza2_panel, toppings_panel, toppings2_panel;

	String pizzaType = "";
	boolean toppings[] = new boolean[4];
	double total = 0;
	private ButtonGroup types;
	private JRadioButton pepperoni, cheese, veggie;
	private JPanel top1_panel, top2_panel, pizza_panel;
	private JCheckBox mush, onion, olives, exChs;

	public OrderPanel(JFrame frame) {
		// button

		PayButton = new JButton("Check out");
		PayButton.addActionListener(new ButtonListener(frame));
		pizza2_panel = new JPanel();
		pizza2_panel.setLayout(new GridLayout(10, 10, 10, 10));

		pizza_panel = new JPanel();
		pizza_panel.setLayout(new GridLayout(1, 3));

		// Delivery Type
		pizza_types = new JLabel("Pizza Type:");

		pepperoni = new JRadioButton("Pepperoni");
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
		toppings_panel = new JPanel();
		toppings2_panel = new JPanel();

		pizza_topics = new JLabel("Toppings:");

		onion = new JCheckBox("Onion", false);
		mush = new JCheckBox("Mushroom", false);
		olives = new JCheckBox("Olives", false);
		exChs = new JCheckBox("Cheese", false);

		ItemListener onionButt = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				// AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					toppings[0] = true;
					total += 1.50;
				}
				if (state == ItemEvent.DESELECTED) {
					toppings[0] = false;
					total -= 1.50;
				}
			}
		};
		ItemListener mushButt = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				// AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					toppings[1] = true;
					total += 1.50;
				}
				if (state == ItemEvent.DESELECTED) {
					toppings[1] = false;
					total -= 1.50;
				}
			}
		};
		ItemListener olivesButt = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				// AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					toppings[2] = true;
					total += 1.50;
				}
				if (state == ItemEvent.DESELECTED) {
					toppings[2] = false;
					total -= 1.50;
				}
			}
		};
		ItemListener exchsButt = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				// AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					toppings[3] = true;
					total += 1.50;
				}
				if (state == ItemEvent.DESELECTED) {
					toppings[3] = false;
					total -= 1.50;
				}
			}
		};

		onion.addItemListener(onionButt);
		mush.addItemListener(mushButt);
		olives.addItemListener(olivesButt);
		exChs.addItemListener(exchsButt);

		top1_panel.add(onion);
		top1_panel.add(mush);
		top2_panel.add(olives);
		top2_panel.add(exChs);
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
		toppings2_panel.add(pizza_topics);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
		add(PayButton);
	}

	
	public class ButtonListener implements ActionListener {
		private JFrame frame;

		public ButtonListener(JFrame frame) {
			this.frame = frame;

		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if(pepperoni.isSelected()){
				total += 12;
				pizzaType = "Pepperoni";
			} else if(cheese.isSelected()){
				total += 10;
				pizzaType = "Cheese";
			} else if(veggie.isSelected()){
				total += 15;
				pizzaType = "Veggie";
			}
			Pizza newPizza = new Pizza(pizzaType, toppings, total);

			// remove the elements
			remove(PayButton);
			remove(pizza_panel);
			remove(toppings2_panel);
			remove(pizza_types);
			remove(toppings2_panel);

			// transition to payment screen
			PaymentPanel paymentpanel = new PaymentPanel(frame, newPizza);
			frame.getContentPane().add(paymentpanel);
			frame.pack();
			frame.setVisible(true);
		}
	}
}
