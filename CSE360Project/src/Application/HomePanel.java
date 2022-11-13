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
		buttonPanel.setSize(200, 100);
		buttonPanel.setLocation(200, 100);

    	OrderButton = new JButton(" Make an order! ");
    	OrderButton.addActionListener(new ButtonListener(frame));

		buttonPanel.add(OrderButton);

		// title
		titlePanel = new JPanel();
		titlePanel.setSize(200, 100);
		titlePanel.setLocation(100, 0);

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
        	frame.remove(background);

        	// transition to order screen
        	OrderPanel orderpanel = new OrderPanel(frame);
            frame.getContentPane().add(orderpanel);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
