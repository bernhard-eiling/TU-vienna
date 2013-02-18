import java.util.*;

public class MedianOperation extends FilterOperation {
	
	public MedianOperation() {
	}
	
	
	public int filter(int[] values) {
		//Array nach Wert sortieren
		Arrays.sort(values);
		
		//Median zur�ckgeben
		return values[4];
	}
}
				
