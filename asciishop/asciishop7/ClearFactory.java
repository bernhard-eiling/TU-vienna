public class ClearFactory implements Factory {
	
	public ClearFactory() {
	}
	
	public Operation create () throws FactoryException {
		
		return new ClearFactory();
	}
}