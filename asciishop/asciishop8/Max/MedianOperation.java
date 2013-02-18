import java.util.*;

public class MedianOperation extends FilterOperation {
	
	public MedianOperation() {
	}
	
	
	public int filter(int[] values) {
		//Array nach Wert sortieren
		Arrays.sort(values);
		
		//Median zurückgeben
		return values[4];
	}
}
				
