package Application;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class HomePanel extends JPanel {
    private JButton OrderButton;
    private JLabel title;
    private JPanel buttonPanel, titlePanel, background;

    public HomePanel(JFrame frame) {

		background = new JPanel();

    	// title text
    	title = new JLabel("Pizza Project");
    	
    	// button
		buttonPanel = new JPanel();
		buttonPanel.setSize(200, 100); //set button size
		buttonPanel.setLocation(200, 100); //set button Location

    	OrderButton = new JButton("Place new Order");
    	OrderButton.addActionListener(new ButtonListener(frame));

		buttonPanel.add(OrderButton);

		// title
		titlePanel = new JPanel();
		titlePanel.setSize(200, 100); //set title size 
		titlePanel.setLocation(100, 0); //set title Location

    	title = new JLabel("Welcome to PIZZA STORE");
		titlePanel.add(title);

		frame.add(titlePanel);
		frame.add(buttonPanel);
		frame.add(background);
    }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// removing the elements
            frame.remove(titlePanel);
        	frame.remove(buttonPanel);
        	frame.remove(background);//transition to order screen

        	
        	PlaceOrder orderpanel = new PlaceOrder(frame);
            frame.getContentPane().add(orderpanel);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
