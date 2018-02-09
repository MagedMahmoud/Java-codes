import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;


public class MultiThread implements ActionListener {
    public static void main(String[] args)
    {
        MultiThread app = new MultiThread();
        app.makeGui();
    }

	void makeGui()
    {
		// Create the window.
		JFrame frame = new JFrame("Hello World Of Threading!");
		// Set the window size.
		frame.setMinimumSize(new Dimension(800, 400));
		// Close when you click the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Stack our components vertically.
		frame.setLayout(
			new BoxLayout(
				frame.getContentPane(),
				BoxLayout.Y_AXIS)
		);

        final ImagePanel panel1 = new ImagePanel();
        ImagePanel panel2 = new ImagePanel();
        ImagePanel panel3 = new ImagePanel();
        
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                        panel1.setPath("robot1.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("robot2.jpg");
                        Thread.sleep(1000);
                        panel1.setPath("robot3.jpg");
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                       
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                    	 panel2.setPath("robot1.jpg");
                         Thread.sleep(2000);
                         panel2.setPath("robot3.jpg");
                         Thread.sleep(2000);
                         panel2.setPath("robot3.jpg");
                         Thread.sleep(2000);
                    } catch (Exception ex) {
                       
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // You can uncomment the following code and change the image names.
                    	 panel3.setPath("robot1.jpg");
                         Thread.sleep(3000);
                         panel3.setPath("robot2.jpg");
                         Thread.sleep(3000);
                         panel3.setPath("robot3.jpg");
                         Thread.sleep(3000);
                    } catch (Exception ex) {
                       
                        System.out.println(ex.getMessage());
                        return;
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
    }
}

