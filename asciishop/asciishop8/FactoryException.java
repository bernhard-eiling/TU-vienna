/**
 * This class extends the Exception to create a special FactoryException class 
 * used to throw Exceptions caused be Factories
 * 
 * @version 7
 * @author Bernhard Johannes Eiling
 * 
 */
public class FactoryException extends Exception {
	
	public FactoryException() {
		super();
	}
	
	public FactoryException (String message) {
		super(message);
	}
}
