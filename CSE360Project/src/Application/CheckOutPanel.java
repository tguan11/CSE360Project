package Application;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CheckOutPanel extends JPanel {
	private JButton ProcessingButton;
	private JLabel IDLable, nameLabel, emailLabel, costLabel, costText;
	private JTextArea IDArea, nameArea, emailArea;

	Pizza newPizza;

	public CheckOutPanel(JFrame frame, Pizza newPizza) {
		this.newPizza = newPizza;

		// button
		ProcessingButton = new JButton("Order Processing");
		ProcessingButton.addActionListener(new ButtonListener(frame));

		IDLable = new JLabel("enter your ASU ID: ");
		IDArea = new JTextArea(1, 5);
		nameLabel = new JLabel("Enter your Name: ");
		nameArea = new JTextArea(1, 5);
		emailLabel = new JLabel("Enter your email:");
		emailArea = new JTextArea(1, 5);

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

		costLabel = new JLabel("Total is: ");
		costText = new JLabel(nf.format(newPizza.getCost()));

		add(costLabel);
		add(costText);
		add(nameLabel);
		add(nameArea);
		add(IDLable);
		add(IDArea);
		add(emailLabel);
		add(emailArea);
		add(ProcessingButton);
	}

	public class ButtonListener implements ActionListener {
		private JFrame frame;

		public ButtonListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent event) {

			String ID = IDArea.getText();
			String name = nameArea.getText();
			String email = emailArea.getText();
			Customer newCustomer = new Customer(name, email, ID);

			try {
				if (newCustomer.verifyID() && !name.equals("") && !email.equals("")) {
					remove(nameArea);
					remove(nameLabel);
					remove(emailArea);
					remove(emailLabel);
					remove(IDArea);
					remove(IDLable);
					remove(costText);
					remove(costLabel);
					remove(ProcessingButton);

					Order newOrder = new Order(newPizza, newCustomer);
					progressPanel progress = new progressPanel(frame, newOrder);
					frame.getContentPane().add(progress);

					JFrame Chef_view = new JFrame("Chefs view");
					Chef_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Chef_view.setPreferredSize(new Dimension(500, 400));
					Chef_view.setBackground(Color.RED);
					Chef chef = new Chef(Chef_view, newOrder, progress);
					Chef_view.getContentPane().add(chef);
					Chef_view.pack();
					Chef_view.setVisible(true);

					frame.pack();
					frame.setVisible(true);
				} else {
					IDLable.setText("ID invalid: ");
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
