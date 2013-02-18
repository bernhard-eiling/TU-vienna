/**
 * The interface for the Factory.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public interface Factory {
	Operation create(Scanner sc) throws FactoryException;
}
