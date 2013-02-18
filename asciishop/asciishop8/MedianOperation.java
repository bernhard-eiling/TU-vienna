import java.util.ArrayList;

/**
 *
 * This class creates a MedianOperation which renders a specified pixel to the average brightness level of its adjacent pixels
 * 
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */
import java.util.Arrays;
 
public class MedianOperation extends FilterOperation{

	/**
	 *
	 * Creates a new MedianOperation
	 *
	 **/
	public MedianOperation() {
	}
	
	/**
	 *
	 * Executes the MedianOperation:
	 * Sorts the Pixels by brightness and returns the pixel in the middle of the cluster array
	 *
	 */
	
	public int filter(int[] cluster) {
		Arrays.sort(cluster);
		return cluster[4];
	}
}
