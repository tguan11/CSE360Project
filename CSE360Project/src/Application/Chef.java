package Application;
//chef class
//this is working for chef to change the status
//Status: "RECIEVED", "PREPERING", "COOKING", "READY FOR PICK UP" 



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Chef extends JPanel {
	private JLabel orderNUM, customer, pizzaType, pizzaTopic;

	public Chef(JFrame frame, Order newOrder, progressPanel process) {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);

		String[] orderProgressOptions = { "RECIEVED", "PREPERING", "COOKING", "READY FOR PICK UP" };
		customer = new JLabel("Customer Name: " + newOrder.getCustomerName());
		orderNUM = new JLabel("Order Number: " + Integer.toString(newOrder.getOrderNum()));
		pizzaType = new JLabel("Pizza Type: " + newOrder.getPizzaType());
		pizzaTopic = new JLabel("Topics: " + newOrder.getPizzatopics());

		final JComboBox<String> status = new JComboBox<String>(orderProgressOptions);
		status.setVisible(true);
		status.getItemAt(status.getSelectedIndex());
		JButton update = new JButton("Update Order Status");

		Box order = Box.createVerticalBox();
		order.add(customer);
		order.add(orderNUM);
		order.add(pizzaType);
		order.add(pizzaTopic);
		order.add(status);
		order.add(update);
		add(order);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				process.updateProgress(status.getSelectedIndex());
			}
		});
	}
}
