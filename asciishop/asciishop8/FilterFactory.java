/**
 * Creates a FilterFactory, reads in the parameters for the Operation,
 * checks if the parameters are valid and creates a new AverageOperation.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public class FilterFactory implements Factory {
	
	public FilterFactory() {
	}
	
	public Operation create(Scanner sc) throws FactoryException {
		String command = sc.next();
		if(command.equals("median")) {
			return new MedianOperation();
		} else if (command.equals("average")) {
			return new AverageOperation();
		} else {
			throw new FactoryException("no valid command");
		}
	}
}