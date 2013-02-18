import java.util.Scanner;
import java.util.Stack;

/**
 * The main-class. Reads in commands, processes the input and prints out the output.
 * 
 * @version 7
 * @author Bernhard Johannes Eiling
 * 
 */
public class AsciiShop {
    public static void main(String[] args) {
    	    
    	    /**
    	     * @param sc	 Scanner shich reads input
    	     * @param imgStack	 saves AsciiImages to provide the undo-functionality
    	     *
    	     */
    	    Scanner sc = new Scanner(System.in);
    	    Stack<AsciiImage> imgStack = new Stack<AsciiImage>();
    	    
	
    	    while (sc.hasNext()) {
    	    	    String command = sc.next();
    	    	    int x = 0;
    	    	    int y = 0;
    	    	    String inputData = "";
    	    	    /**
    	    	     * Creates a new AsciiImage and processes the commands read in by the Scanner
    	    	     */
    	    	    if (!command.equals("create")) {
    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    return;
    	    	    } else {
    	    	    	    
    	    	    	    if (sc.hasNextInt()) {
    	    	    	    	    x = sc.nextInt();
    	    	    	    } else {
    	    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    	    return;
    	    	    	    }
    	    	    	    if (sc.hasNextInt()) {
    	    	    	    	    y = sc.nextInt();
    	    	    	    } else {
    	    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    	    return;
    	    	    	    }
    	    	    	    if (sc.hasNext()) {
    	    	    	    	    inputData = sc.next();
    	    	    	    } else {
    	    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    	    return;
    	    	    	    }
    	    	    	    
    	    	    	    AsciiImage image = new AsciiImage(x, y, inputData);
		    
    	    	    	    while (sc.hasNext()) {
    	    	    	    	    command = sc.next();
    	    	    	    	    
    	    	    	    	    /**
    	    	    	    	     * CLEAR OPERATION
    	    	    	    	     */
    	    	    	    	    if(command.equals("clear")) {
    	    	    	    	    	    imgStack.push(image);
    	    	    	    	    	    ClearOperation clear = new ClearOperation();
    	    	    	    	    	    image = clear.execute(image);
    	    	    	    	    	    
    	    	    	    	    /**
    	    	    	    	     * PRINT OPERATION
    	    	    	    	     */
    	    	    	    	    } else if(command.equals("print")) {
    	    	    	    	    	    System.out.println(image.toString());
    	    	    	    	    
    	    	    	    	    /**
    	    	    	    	     * REPLACE OPERATION
    	    	    	    	     */
    	    	    	    	    } else if(command.equals("replace")) {
    	    	    	    	    	    imgStack.push(image);
					Factory replaceFactory = new ReplaceFactory();
					Operation replaceOperation = new ReplaceOperation(replaceFactory.create(sc));
					image = replaceOperation.execute(image);
					/*
    	    	    	    	    	    try {
    	    	    	    	    	    	    ReplaceOperation replace = new ReplaceOperation((char)sc.next().charAt(0), (char)sc.next().charAt(0));
    	    	    	    	    	    	    image = replace.execute(image);
    	    	    	    	    	    } catch (OperationException ex) {
    	    	    	    	    	    	    System.out.println("OPERATION FAILED");
    	    	    	    	    	    	    return;
    	    	    	    	    	    }
    	    	    	    	    }
			
    	    	    	    	    /**
    	    	    	    	     * LOAD OPERATION
    	    	    	    	     */
    	    	    	    	    else if(command.equals("load")) {
    	    	    	    	    	    imgStack.push(image);
					
					/*
    	    	    	    	    	    String breaker = "";
    	    	    	    	    	    String loadImage = "";
    	    	    	    	    	    String dump = "";
    	    	    	    	    	    
    	    	    	    	    	    if(sc.hasNext()){
    	    	    	    	    	    	    breaker = sc.next();
    	    	    	    	    	    	    dump = sc.nextLine();
    	    	    	    	    	    } else {
    	    	    	    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    	    	    	    return;
    	    	    	    	    	    }
    	    	    	    	    	    
    	    	    	    	    	    String input = "";
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
				    }
				    
				    /**
    	    	    	    	     * MEDIANFILTER OPERATION
    	    	    	    	     */
				    else if(command.equals("filter")) {
				    	    if ( sc.next().equals("median") ) {
				    	    	    imgStack.push(image);
				    	    	    MedianOperation median = new MedianOperation();
				    	    	    image = median.execute(image);
				    	    } else {
				    	    	    System.out.println("INPUT MISMATCH");
				    	    }
				    }
					
					/**
					 * BINARY OPERATION
					 */
					else if(command.equals("binary")) {
					}
			    
				    /**
    	    	    	    	     * UNDO OPERATION
    	    	    	    	     */
				    else if(command.equals("undo")) {
				    	    if (imgStack.empty()) {
				    	    	    System.out.println("STACK EMPTY");
				    	    } else {
				    	    	    image = imgStack.pop();
				    	    }
				    }
			
				    /**
				     * Prints out an error when the command is unknown.
				     */
				    else {
				    	    System.out.println("UNKNOWN COMMAND");
				    }
			    }
		    }
	    }
    }
}

