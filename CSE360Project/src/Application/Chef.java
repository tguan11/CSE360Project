package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Chef extends JPanel  {
	 private JLabel orderNUM , customer , pizzaType, pizzaTop;
	public Chef(JFrame frame, Order newOrder , progressPanel process) {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		
		String[] orderProgressOptions = {"ORDER RECIEVED" ,"IN PREP", "COOKING", "READY FOR PICK UP"};
		customer = new JLabel("Customer Name: " + newOrder.getCustomerName());
		orderNUM = new JLabel("Order Number: " +Integer.toString(newOrder.getOrderNum()));
		pizzaType= new JLabel("Pizza Type: "+newOrder.getPizzaType());
		pizzaTop =new JLabel("Toppings: " + newOrder.getPizzaTopping()+ " ");
		
		final JComboBox<String> status = new JComboBox<String>(orderProgressOptions);
		status.setVisible(true);
		status.getItemAt(status.getSelectedIndex());
		JButton update = new JButton("Update Order Status");

		Box orderInfo = Box.createVerticalBox();
		orderInfo.add(customer);
		orderInfo.add(orderNUM);
		orderInfo.add(pizzaType);
		orderInfo.add(pizzaTop);
		orderInfo.add(status);
		orderInfo.add(update);
		add(orderInfo);
		update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				process.updateProgress(status.getSelectedIndex()); 
			}
		});
	}
}

