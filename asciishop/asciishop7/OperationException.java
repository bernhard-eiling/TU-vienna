/**
 *
 * This class extends the Exception to create a special OperationException class 
 * used to throw Exceptions caused be Operations
 * 
 * @version 7
 * @author Bernhard Johannes Eiling
 * 
 */
public class OperationException extends Exception {
	
	public OperationException() {
		super();
	}
	
	public OperationException (String message) {
		super(message);
	}
}
