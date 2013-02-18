import java.util.Scanner;

public class LoadFactory implements Factory {
	
	public LoadFactory() {
	}
	
	public Operation create (Scanner sc) throws FactoryException {
		String eof = "";
    	    	String loadImage = "";
    	    	//String dump = "";
		String input = "";
    	    	    	    	    	    
    	    	if(sc.hasNext()){
    	    	    	   eof = sc.nextLine();
    	    	    	   //dump = sc.nextLine();
    	    	} else {
    	    	    	   throw new FactoryException("no EOF"); 
    	    	    	   return;
    	    	}
		while(sc.hasNext()) {
			input.nextLine();
			if (input.equals(eof)) {
				return new LoadOperation(loadImage);
			} else {
				loadImage += input + "\r\n";
			}
			if (!sc.hasNextLine()) {
				throw new FactoryException("no EOF");
			}
		}	              
    	    	/*
    	    	for (int i = 0; i < image.getHeight(); i++) {
    	    	    	    input = sc.nextLine();
    	    	    	    if(input.length() != image.getWidth()) {
				  	 System.out.println("INPUT MISMATCH");
				  	 return;
			} else {
				  loadImage += input + "\r\n";
			}
		}
				  	    
		if (!breaker.equals(sc.nextLine())) {
				  	    	    System.out.println("INPUT MISMATCH");
				  	    	    return;
				  	    } else {
				  	    	    try {
				  	    	    	    LoadOperation load = new LoadOperation(loadImage);
				  	    	    	    image = load.execute(image);
				  	    	    } catch (OperationException ex) {
				  	    	    	    System.out.println("OPERATION FAILED");
			}
		}
		*/
		//return new LoadOperation(
	}
}