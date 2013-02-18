/**
 * Creates a ClearFactory and returns a new ClearOperation.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public class ClearFactory implements Factory {
	
	public ClearFactory() {
	}
	
	public Operation create(Scanner sc) {
		
		return new ClearOperation();
	}
}