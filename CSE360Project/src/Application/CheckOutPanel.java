package Application;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CheckOutPanel extends JPanel {
    private JButton submitButton;
    private JLabel cost, costPrompt;
    private JLabel IDPrompt, namePrompt, emailPrompt;
    private JTextArea IDArea, nameArea, emailArea ;
	
    Pizza newPizza;

    public CheckOutPanel(JFrame frame, Pizza newPizza) {
		this.newPizza = newPizza;

    	// button
    	submitButton = new JButton(" See order progress ");
    	submitButton.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	IDPrompt = new JLabel("enter your ASU ID: ");    
		namePrompt = new JLabel("Enter your Name: ");
    	emailPrompt = new JLabel("Enter your email:");
    	
    	// text box for email?
    	IDArea = new JTextArea(1, 5);
    	nameArea = new JTextArea(1, 5);
    	emailArea = new JTextArea(1,5);
    	
    	// text for total price
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	costPrompt = new JLabel("your total: ");
    	cost = new JLabel(currencyFormatter.format(newPizza.getCost()));

    	add(costPrompt);
		add(cost);
    	add(namePrompt);
    	add(nameArea);
    	add(IDPrompt);
        add(IDArea);
        add(emailPrompt);
        add(emailArea);
        add(submitButton);
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
				if(newCustomer.verifyID() && !name.equals("") && !email.equals("")){
						remove(nameArea);
						remove(namePrompt);
						remove(emailArea);
						remove(emailPrompt);
						remove(IDArea);
						remove(IDPrompt);
						remove(cost);
						remove(costPrompt);
						remove(submitButton);

						Order newOrder = new Order(newPizza, newCustomer);
						progressPanel progress = new progressPanel(frame, newOrder);
					    frame.getContentPane().add(progress);
					    
					    JFrame Chef_view = new JFrame("Chefs view");
					    Chef_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					    Chef_view.setPreferredSize(new Dimension(500, 400));
					    Chef_view.setBackground(Color.RED);
					    Chef chef = new Chef(Chef_view , newOrder , progress);
					    Chef_view.getContentPane().add(chef);
					    Chef_view.pack();
					    Chef_view.setVisible(true);

					    frame.pack();
					    frame.setVisible(true);
					} else {
						IDPrompt.setText("ID invalid: ");
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


