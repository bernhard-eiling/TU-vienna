/**
 * Creates an AverageOperation which sums up the value of the cluster and devids it by the
 * number of elements the array is contained of.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

import java.lang.Math;

public class AverageOperation extends FilterOperation {
	
	public AverageOperation() {
		
	}
	
	public int filter(int[] cluster) {
		double sum = 0;
		for(int i = 0; i < cluster.length; i++) {
			sum += cluster[i];
		}
		return (int)Math.round(sum/cluster.length);
	}
}
