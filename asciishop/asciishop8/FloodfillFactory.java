/**
 * Creates a FloodfillFactory, reads in the parameters for the Operation,
 * checks if the parameters are valid and creates a new FloodfillOperation.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public class FloodfillFactory implements Factory {
	
	private int x;
	private int y;
	private char c;
	
	public FloodfillFactory() {
	}
	
	public Operation create(Scanner sc) throws FactoryException {
		if ( !sc.hasNextInt() ) {
			throw new FactoryException("no valid parameters");
		} else {
			if (sc.hasNextInt()) {
				x = sc.nextInt();
			} else {
				throw new FactoryException("not a int");
			}
			if (sc.hasNextInt()) {
				y = sc.nextInt();
			} else {
				throw new FactoryException("not a int");
			}
			if (sc.hasNext()) {
				c = sc.next().charAt(0);
			} else {
				throw new FactoryException("not a char");
			}
		}
		return new FloodfillOperation(x, y, c);
	}
}
