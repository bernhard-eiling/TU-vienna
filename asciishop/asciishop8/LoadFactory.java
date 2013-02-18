/**
 * Creates a LoadFactory, reads in the parameters for the Operation,
 * checks if the parameters are valid and creates a new LoadOperation.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.util.Scanner;

public class LoadFactory implements Factory {
	
	public LoadFactory() {
	}
	
	public Operation create (Scanner sc) throws FactoryException {
		String eof = "";
    	    	String loadImage = "";
    	    	String dump = "";
		String input = "";
    	    	    	    	    	    
    	    	if(sc.hasNext()){
    	    	    	   eof = sc.next();
    	    	    	   dump = sc.nextLine();
    	    	} else {
    	    	    	   throw new FactoryException("no EOF");
    	    	}
		while(sc.hasNext()) {
			input = sc.next();
			//dump = sc.nextLine();
			if (input.equals(eof)) {
				return new LoadOperation(loadImage);
			} else {
				loadImage += input + "\r\n";
			}
			if (!sc.hasNextLine()) {
				throw new FactoryException("no EOF");
			}
		}	              
    	    	return new LoadOperation(loadImage);
	}
}