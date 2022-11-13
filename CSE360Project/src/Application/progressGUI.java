package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;    
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class progressGUI extends JPanel{
    JTextField status_area;
	JLabel status_label, emailReceipt;
	JPanel panel;
    int i=0,num=0;     
    private JButton ReturnHome;
  
    public  progressGUI(JFrame frame, Order newOrder) {
		frame.getContentPane();
   
    	// button
    	ReturnHome = new JButton(" Return to home ");
    	ReturnHome.addActionListener(new ButtonListener(frame));

    	// status
    	status_label = new JLabel("You order now is ");
    	status_area = new JTextField();
    	status_area.setText("RECIEVED");

		emailReceipt = new JLabel("A receipt has been sent to " + newOrder.getCustomerEmail());

		// SET LOCATION OF JLABEL
		panel = new JPanel();
		frame.add(panel);

    	// add the elements
        add(ReturnHome);
        add(status_label);
        add(status_area);
		add(emailReceipt);
     
      
    }
	public void updateProgress(int newProgress){
     	if (newProgress == 1) {
    		status_area.setText("IN PREP");
    	}
     	else if(newProgress == 2) {
     		status_area.setText("COOKING");
    	}
     	else if(newProgress == 3)
     	{
     		status_area.setText("READY FOR PICK UP");
     	}
     	else
     	{
     		
     	}
    }
	
    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        public void actionPerformed(ActionEvent event) {
        	remove(ReturnHome);
        	remove(status_area);
        	remove(status_label);
        	remove(emailReceipt);
        	
        	HomePanel homepanel = new HomePanel(frame);
            frame.getContentPane().add(homepanel);
            frame.pack();
            frame.setVisible(true);   
        }
	}
}

