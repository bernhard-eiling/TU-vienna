import java.util.ArrayList;

/**
 *
 * This class creates a MedianOperation which renders a specified pixel to the average brightness level of its adjacent pixels
 * 
 * @version 6
 * @author Bernhard Johannes Eiling
 * 
 */
 
public class MedianOperation {
	
	private char cluster[] = new char [9];
	private char brightness[] = new char [9];
	private int clusterCounter = 0;
	
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
	 * If the inspected pixel outside of the image it gets the darkest brightness. Afterwards the brightness of all adjacent pixels 
	 * and the specified pixels will be compared and the specified pixel gets the valus of the average brightness.
	 *
	 * @param original		 the image from which the brightness of each pixel will be read
	 * @param result		 the image to which the altered brightness values will be writen
	 * @param charSet		 used as an indicator to get the average brightness level for each pixel
	 * @param cluster		 an array to save the 9 pixels which will be compared
	 * @param brightness		 an array to save the ordered pixels
	 * @param clusterCounter	 index to save the pixels into the brightness-array
	 *
	 */
	public AsciiImage execute(AsciiImage img) {
		AsciiImage original = new AsciiImage(img);
		AsciiImage result = new AsciiImage(img);
		String charSet = result.getCharSet();
		
		
		for (int y = 0; y < original.getHeight(); y++) {
			for (int x = 0; x < original.getWidth(); x++) {
				if ( x == 0 || y == 0 ) {
					cluster[0] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[0] = original.getPixel(x - 1, y - 1);
				}
				if ( x == 0 ) {
					cluster[1] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[1] = original.getPixel(x - 1, y);
				}
				if ( x == 0 || y == original.getHeight() - 1 ) {
					cluster[2] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[2] = original.getPixel(x - 1, y + 1);
				}
				if ( y == 0 ) {
					cluster[3] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[3] = original.getPixel(x, y - 1);
				} 
				cluster[4] = original.getPixel(x, y);
				if ( y == original.getHeight() - 1 ) {
					cluster[5] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[5] = original.getPixel(x, y + 1);
				}
				if ( x == original.getWidth() - 1 || y == 0 ) {
					cluster[6] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[6] = original.getPixel(x + 1, y - 1);
				}
				if ( x == original.getWidth() - 1 ) {
					cluster[7] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[7] = original.getPixel(x + 1, y);
				}
				if ( x == original.getWidth() - 1 || y == original.getHeight() - 1 ) {
					cluster[8] = charSet.charAt(charSet.length() - 1 );
				} else {
					cluster[8] = original.getPixel(x + 1, y + 1);
				}

				// sorting the cluster by brightness
				for (int j = 0; j < charSet.length(); j++) {
					for (int i = 0; i < cluster.length; i++) {
						if (cluster[i] == charSet.charAt(j)) {
							brightness[clusterCounter] = charSet.charAt(j);
							clusterCounter++;
						}
					}
				}
				clusterCounter = 0;
				result.setPixel(x, y, brightness[4]);
			}
		}
		return result;
	}
}
