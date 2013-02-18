import java.util.*;

public class BinaryFactory implements Factory {
	
	public BinaryFactory() {
	}
	
	public Operation create(Scanner sc) throws FactoryException {
		//Parameter Prüfen
		if(!sc.hasNext()) {
			throw new FactoryException("Kein Threshold");
		}
		
		String in=sc.next();
		if(in.length()<1) {
			throw new FactoryException("Kein char");
		}
		
		return new BinaryOperation(in.charAt(0));
	}
}
