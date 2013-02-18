import java.util.Scanner;

public class BinaryFactory implements Factory {
	
	public BinaryFactory() {
	}

	public Operation create (Scanner sc) throws FactoryException {
		if (sc.hasNext()) {
			return new BinaryOperation(sc.next());
		} else {
			throw new FactoryException("no threshold");
		}
	}
}