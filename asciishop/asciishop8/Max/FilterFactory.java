import java.util.*;

public class FilterFactory implements Factory {
	
	public FilterFactory() {
	}
	
	public Operation create(Scanner sc) throws FactoryException {
		//Parameter
		if(!sc.hasNext()) {
			throw new FactoryException("Kein Parameter");
		}
		
		String parameter=sc.next();
		
		if(parameter.equals("median")) {
			return new MedianOperation();
		}
		
		if(parameter.equals("average")) {
			return new AverageOperation();
		}
		else {
			throw new FactoryException("Falscher Parameter");
		}
	}
}
