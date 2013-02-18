import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

/**
 * The main-class. Reads in commands, processes the input and prints out the output.
 * 
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */
public class AsciiShop {
    public static void main(String[] args) {
    	    
    	    /**
    	     * @param sc	 Scanner which reads input
    	     * @param imgStack	 saves AsciiImages to provide the undo-functionality
    	     * @param factories	 HashMap including the factorys to create operations
    	     *
    	     */
    	    Scanner sc = new Scanner(System.in);
    	    Stack<AsciiImage> imgStack = new Stack<AsciiImage>();
    	    HashMap<String, Factory> factories = new HashMap<String, Factory>();
    	    factories.put("binary", new BinaryFactory());
    	    factories.put("clear", new ClearFactory());
    	    factories.put("filter", new FilterFactory());
    	    factories.put("load", new LoadFactory());
    	    factories.put("replace", new ReplaceFactory());
    	    factories.put("floodfill", new FloodfillFactory());
	
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
    	    	    	    	    /**
    	    	    	    	     * The scanner reads i a command wich will be used as a key to identify the
    	    	    	    	     * respective factory to be created
    	    	    	    	     *
    	    	    	    	     */
    	    	    	    	    command = sc.next();
    	    	    	    	    if (factories.containsKey(command)) {
    	    	    	    	    	    try {
    	    	    	    	    	    	    imgStack.push(image);
    	    	    	    	    	    	    image = factories.get(command).create(sc).execute(image);
    	    	    	    	    	    } catch (FactoryException fEx) {
    	    	    	    	    	    	    System.out.println("INPUT MISMATCH");
    	    	    	    	    	    	    return;
    	    	    	    	    	    } catch (OperationException oEx) {
    	    	    	    	    	    	    System.out.println("OPERATION FAILED");
    	    	    	    	    	    	    return;
    	    	    	    	    	    }
    	    	    	    	    } else if(command.equals("undo")) {
				    	    if (imgStack.empty()) {
				    	    	    System.out.println("STACK EMPTY");
				    	    } else {
				    	    	    image = imgStack.pop();
				    	    }
				    } else if(command.equals("print")) {
    	    	    	    	    	    System.out.println(image.toString());
				    } else {
				    	    System.out.println("UNKNOWN COMMAND");
				    }
			    }
		    }
	    }
    }
}

