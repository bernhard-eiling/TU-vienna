import java.util.*;
public interface Factory {
	
	public Operation create(Scanner sc) throws FactoryException;
		
}
