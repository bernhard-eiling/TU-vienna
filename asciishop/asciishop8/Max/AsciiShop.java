import java.util.*;

public class AsciiShop {
	public static void main(String[] args) {
		
		//Hashmap Factories
		HashMap<String, Factory> factories=new HashMap<String, Factory>();
		factories.put("binary", new BinaryFactory());
		factories.put("clear", new ClearFactory());
		factories.put("filter", new FilterFactory());
		factories.put("load", new LoadFactory());
		factories.put("replace", new ReplaceFactory());
		
		//Bild und Stack Generieren
		Scanner sc=new Scanner(System.in);
		
		if(!sc.next().equals("create")) {
			System.out.println("INPUT MISMATCH");
			return;
		}
		
		int x=sc.nextInt();
		int y=sc.nextInt();
		String charset=sc.next();
		
		AsciiImage image=new AsciiImage(x, y, charset);
		Stack<AsciiImage> stack=new Stack<AsciiImage>();
		
		String abfall=sc.nextLine(); //Scanner spring eine Zeile weiter
		
		
		//Befehle Lesen
		while(sc.hasNext()) {
			String operation=sc.next();
			boolean unknownCommand=true;
			
			//Factories
			if(factories.containsKey(operation)) {
				unknownCommand=false;
				try {
					stack.push(image);
					//Factory aus Hashmap, Operation generieren, image an Operation weitergeben
					image=factories.get(operation).create(sc).execute(image);
				}
				
				//Exceptions Fangen
				catch(FactoryException f) {
					System.out.println("INPUT MISMATCH");
					return;
				}
				catch(OperationException o) {
					System.out.println("OPERATION FAILED");
					return;
				}
			}
			
			//Andere Operationen
			if(operation.equals("print")) {
				unknownCommand=false;
				System.out.println(image);
			}
			
			if(operation.equals("undo")) {
				unknownCommand=false;
				
				if(stack.size()==0) {
					System.out.println("STACK EMPTY");
				}
				else {
					image=new AsciiImage(stack.pop());
				}
			}
			
			//Fehlerausgabe
			if(operation.equals("create")) {
				unknownCommand=true;
			}
			
			if(unknownCommand) {
				System.out.println("UNKNOWN COMMAND");
			}
		}
	}
}
