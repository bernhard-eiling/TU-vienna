
public class MedianFactory implements Factory {
	
	public MedianFactory() {
	}
	
	public Operation create() {
		return new MedianOperation();
	}
}