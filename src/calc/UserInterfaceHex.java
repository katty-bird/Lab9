package calc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserInterfaceHex extends UserInterface{
	
	public UserInterfaceHex(CalcEngine engine, Calculator currentCalc) {
		super(engine, currentCalc);
	}
	
    /**
     * Make the frame for the user interface in Hexadecimal system.
     */
	@Override
	 protected void makeFrame()
    {
        frame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(7, 4));
        	addButton(buttonPanel, "A");
        	addButton(buttonPanel, "B");
        	addButton(buttonPanel, "C");
        	addDecCheckBox(buttonPanel, "DEC");
        	
        	addButton(buttonPanel, "D");
            addButton(buttonPanel, "E");
            addButton(buttonPanel, "F");
            addHexCheckBox(buttonPanel, "HEX");
        	
            addButton(buttonPanel, "7");
            addButton(buttonPanel, "8");
            addButton(buttonPanel, "9");
            buttonPanel.add(new JLabel(" "));
            
            addButton(buttonPanel, "4");
            addButton(buttonPanel, "5");
            addButton(buttonPanel, "6");
            addButton(buttonPanel, "X");
            
            addButton(buttonPanel, "1");
            addButton(buttonPanel, "2");
            addButton(buttonPanel, "3");
            addButton(buttonPanel, "?");
            
            addButton(buttonPanel, "0");
            addButton(buttonPanel, "+");
            addButton(buttonPanel, "-");
            addButton(buttonPanel, "=");
            
            buttonPanel.add(new JLabel(" "));
            addButton(buttonPanel, "*");
            addButton(buttonPanel, "/");
            buttonPanel.add(new JLabel(" "));
            
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }
	
    /** 
     * The two methods below add checkBoxex to the button panel.
     * Initial setSelected values for boxes before switching: 
     * dec-false; hex-true;
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
	@Override
	protected void addDecCheckBox(Container panel, String buttonText)
    {
    	JCheckBox decButton = new JCheckBox(buttonText);
    	decButton.setSelected(false);
    	decButton.addActionListener(this);
    	panel.add(decButton);
    }
	
	@Override
    protected void addHexCheckBox(Container panel, String buttonText)
    {
    	JCheckBox hexButton = new JCheckBox(buttonText);
        hexButton.setSelected(true);
        hexButton.addActionListener(this);
    	panel.add(hexButton);
    }
	
    /**
     * An interface action has been performed.
     * Find out what it was and handle it.
     * @param event The event that has occured.
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        if(command.equals("0") ||
           command.equals("1") ||
           command.equals("2") ||
           command.equals("3") ||
           command.equals("4") ||
           command.equals("5") ||
           command.equals("6") ||
           command.equals("7") ||
           command.equals("8") ||
           command.equals("9") ) {
            int number = Integer.parseInt(command);
            calc.numberPressed(number);
        }
        else if(command.equals("A") ||
        		command.equals("B") ||
                command.equals("C") ||
                command.equals("D") ||
                command.equals("E") ||
                command.equals("F") ) {
        	int number = Integer.parseInt(command, 16);
        	calc.numberPressed(number);      	
        }
        else if(command.equals("+")) {
            calc.plus();
        }
        else if(command.equals("-")) {
            calc.minus();
        }
        else if(command.equals("=")) {
            calc.equals();
        }
        else if(command.equals("X")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        else if(command.equals("*")) {
        	calc.multiply();
        }
        else if(command.equals("/")) {
        	calc.division();
        }
        else if(command.equals("DEC")) {
        	calculator.hide();
        	calculator.createCalc();
        }
        // else unknown command.

        redisplay();
    }
    
    /**
     * Update the interface display to show the current value of the 
     * calculator in Hexadecimal system.
     */
    protected void redisplay()
    {
        display.setText("0x" + Integer.toHexString(calc.getDisplayValue()).toUpperCase());
    }
}

