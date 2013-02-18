public class AverageOperation extends FilterOperation {
	
	public AverageOperation() {
	}
	
	
	public int filter(int[] values) {
		//Summe der Indiezes
		double sum=0;
		for(int i=0; i<values.length; i++) {
			sum+=values[i];
		}
		
		return (int)Math.round(sum/values.length);
	}
}
