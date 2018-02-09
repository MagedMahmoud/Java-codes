import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;


public class SingleThread implements ActionListener {
    public static void main(String[] args)
    {
        SingleThread app = new SingleThread();
        app.makeGui();
        
        
    }

	void makeGui()
	{
		// Create the window.
		JFrame frame = new JFrame("Hello World Of Threading!");
		// Set the window size.
		frame.setMinimumSize(new Dimension(800,500));
		// Close when you click the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Stack our components vertically.
		frame.setLayout(
			new BoxLayout(
				frame.getContentPane(),
				BoxLayout.Y_AXIS)
		);

        ImagePanel panel1 = new ImagePanel();
		frame.add(panel1);

		ImagePanel panel2 = new ImagePanel();
		frame.add(panel2);
		
		ImagePanel panel3 = new ImagePanel();
		frame.add(panel3);
		frame.setVisible(true);
		try{ 
			panel1.setPath("robot1.jpg");
			panel2.setPath("robot1.jpg");
			panel3.setPath("robot1.jpg");
		} catch (Exception e){
			System.out.println("File could not be opened.");
		}
		
	
		while(true){
			try{
				
				panel1.setPath("robot1.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot2.jpg");
				panel2.setPath("robot2.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot3.jpg");
				panel3.setPath("robot2.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot1.jpg");
				panel2.setPath("robot3.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot2.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot3.jpg");
				panel2.setPath("robot1.jpg");
				panel3.setPath("robot3.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot1.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot2.jpg");
				panel2.setPath("robot2.jpg");
				Thread.sleep(1000); 
				panel1.setPath("robot3.jpg");
				panel3.setPath("robot1.jpg");
				Thread.sleep(1000); 
			}
			catch (Exception e){
				System.out.println("File could not be opened.");
				
			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
    }
}

