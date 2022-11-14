package Application;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("Pizza Ordering App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);
        
        HomePanel homepanel = new HomePanel(frame);
        frame.getContentPane().add(homepanel);
        frame.pack();
        frame.setVisible(true);
    }
}

