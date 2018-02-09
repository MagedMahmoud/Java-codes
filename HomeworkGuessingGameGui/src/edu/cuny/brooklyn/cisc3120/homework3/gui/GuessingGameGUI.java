package edu.cuny.brooklyn.cisc3120.homework4.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GuessingGameGUI implements ActionListener {
    private int limit;
    private int maxInt;
    private int target;
    private int attempts;
    // These components are members so they can be modified from the
    // `actionPerformed` method.
    private JLabel guessLabel;
    private JLabel feedbackLabel;
    private JButton backSpace;

	public GuessingGameGUI(int limit, int maxInt, int target)
    {
        this.limit = limit = 5;
        this.maxInt = maxInt;
        Random rand = new Random();
        this.target = target = rand.nextInt(maxInt) + 1;   
        this.attempts = attempts = 1;
        
      
    }

    private void handleBS()
    {
        String text = guessLabel.getText();
        text = text.substring(0, text.length() - 1);
        if (text.equals("")) {
            text = "0";
            backSpace.setEnabled(false);
        }
        guessLabel.setText(text);
    }

    private void handleSubmit()
    {
        String text = guessLabel.getText();
        try {
            int value = Integer.parseInt(text);
            if (value > target) {
                feedbackLabel.setText("Too High!");
            } else if (value < target) {
                feedbackLabel.setText("Too Low!");
            } else {
                feedbackLabel.setText("Woo!");
            }
            return;
        } catch (NumberFormatException ex) {
            // Ignore integer parse exception...
            // What can cause this exception to be thrown?
            feedbackLabel.setText("You're Dumb!");
        }
    }

    private void handleNumber(int value)
    {
        String text = guessLabel.getText();
        backSpace.setEnabled(true);

        if (text.equals("0")) {
            text = "";
        }
        text += Integer.toString(value);
        guessLabel.setText(text);
    }

    public void actionPerformed(ActionEvent e)
    {
        // You can "debug" your code by printing to stdout.
        // If you are using eclipse, the results will be written to the eclipse
        // log console.
        //
        // This command is printing out the action command for the button that
        // was pressed.
        System.out.println(e.getActionCommand());

        // Is the button that triggered this event a number button?
        try {
            int value = Integer.parseInt(e.getActionCommand());
            handleNumber(value);
            return;
        } catch (NumberFormatException ex) {
            // Ignore integer parse exception...
            // This happens when "submit" or "BS" is pressed.
        }

        // Is it the backspace button?
        if (e.getActionCommand().equals("BS")) {
            handleBS();
            return;
        }

        // Is it the submit button?
        if (e.getActionCommand().equals("submit")) {
            handleSubmit();
            return;
        }
    }

    private JFrame createFrame()
    {
    	JFrame frame = new JFrame("The Guessing Game!");
        frame.setMinimumSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(
        	new BoxLayout(
        		frame.getContentPane(),
        		BoxLayout.Y_AXIS)
        );
        return frame;
    }

    private JLabel createMainLabel() {
    	JLabel mainLabel = new JLabel();
    	mainLabel.setText(
            "Guess a number between 1 and " + Integer.toString(this.maxInt));
        mainLabel.setFont(
        	new Font("Arial", Font.BOLD, 22));
        return mainLabel;
    }

    private JLabel createFeedBackLabel() {
    	JLabel feedbackLabel = new JLabel();
        feedbackLabel.setFont(
        	new Font("Arial", Font.BOLD, 22));
        return feedbackLabel;
    }

    private JLabel createGuessLabel() {
    	JLabel guessLabel = new JLabel("0");
        guessLabel.setFont(
        	new Font("Arial", Font.BOLD, 22));
        guessLabel.setOpaque(true);
        guessLabel.setBackground(Color.gray);
        return guessLabel;
    }

    private JPanel createNumberPad()
    {
    	JPanel numberPad = new JPanel();
        // If you wanted to, you could make the panel blue,
        // to see where exactly it starts and ends.
        numberPad.setBackground(Color.gray);
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            numberPad.add(button);
            // Call `this.actionPerformed` when the button is pressed.
            button.addActionListener(this);
        }
        return numberPad;
    }

    private JPanel createBottomPanel()
    {
    	
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.gray);
        bottomPanel.setMinimumSize(new Dimension(32, 400));
        return bottomPanel;
    }

    private JButton createBackSpace()
    {
        JButton backSpace = new JButton("<");
        backSpace.setActionCommand("BS");
        // The backspace will start "disabled".
        // This means you will not be able to click on it until there is
        // something to erase.
        backSpace.setEnabled(false);
        // Call `this.actionPerformed` when the button is pressed.
        backSpace.addActionListener(this);
        return backSpace;
    }

    private JButton createSubmitButton()
    {
    	JButton submit = new JButton("Submit Guess");
    
            System.out.printf("Attempt %d of %d: ", attempts, limit);
        // Call `this.actionPerformed` when the button is pressed.
        submit.addActionListener(this);      
		return submit;            
    }
    
    
    

    public void play()
    {
        // Create all of the components.
        JFrame window = createFrame();
        JButton submit = createSubmitButton();
        JPanel numberPad = createNumberPad();
        JLabel mainLabel = createMainLabel();
        guessLabel = createGuessLabel();
        feedbackLabel = createFeedBackLabel();
        JPanel bottomPanel = createBottomPanel();
        backSpace = createBackSpace();

        // Add the backspace button to the numberpad.
        numberPad.add(backSpace);

        // Add submit button and guesslabel to the bottom panel.
        // Why do the components go from left to right?
        // What is the layout manager used by the panel component?
        bottomPanel.add(submit);
        bottomPanel.add(guessLabel);

        // Add the components to the window.
        window.add(mainLabel);
        window.add(numberPad);
        window.add(feedbackLabel);
        window.add(bottomPanel);
        window.setVisible(true);
    }
}
