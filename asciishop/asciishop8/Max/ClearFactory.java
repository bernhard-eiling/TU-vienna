import java.util.*;
public class ClearFactory implements Factory {
	
	public ClearFactory() {
	}
	
	public Operation create(Scanner sc) {
		return new ClearOperation();
	}
}
