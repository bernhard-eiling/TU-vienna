/**
 * Creates a BinaryFactory, reads in the parameters for the Operation,
 * checks if the parameters are valid and creates a new BinaryOperation.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public class BinaryFactory implements Factory {
	
	public BinaryFactory() {
	}

	public Operation create(Scanner sc) throws FactoryException {
		String threshold = "";
		if (sc.hasNext()) {
			threshold = sc.next();
		} else {
			throw new FactoryException("no threshold");
		}
		if (threshold.length() > 1) {
			throw new FactoryException("threshold too long");
		}
		return new BinaryOperation(threshold.charAt(0));
	}
}