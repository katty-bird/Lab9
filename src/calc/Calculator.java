package calc;

/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    private CalcEngine engine;
    private UserInterface gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
//       engine = new CalcEngineHex();
//       gui = new UserInterfaceHex(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
    
    /**
     * This method hides the current UserInterface.
     */
    public void hide()
    {
    	gui.frame.dispose();
        //gui.setVisible(false);
    }
    
    /**
     * Creating a UserInterface for Decimal system.
     */
    public void createCalc() {
    	engine = new CalcEngine();
        gui = new UserInterface(engine, this);
        show();
    }
    
    /**
     * Creating a UserInterface for Hexadecimal system.
     */
    public void createHexCalc() {
    	engine = new CalcEngineHex();
        gui = new UserInterfaceHex(engine, this);
        show();
    }
    
    /**
    * The main class runs the program. 
    * It starts with user interface for Decimal system.
	*/
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.createCalc();
	}
}
