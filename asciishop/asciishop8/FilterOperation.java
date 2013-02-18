/**
 * Creates a FilterOperation and executes it.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

public abstract class FilterOperation implements Operation {
	
	protected int cluster[] = new int[9];
	protected String charSet;
	
	public FilterOperation() {
	}

	/**
	 *
	 * Executes the FilterOperation.
	 * If the inspected pixel is outside of the image it gets the darkest brightness.
	 * Creates a cluster array containing the inspected pixel an its 8 neighbours.
	 * The cluster will be given to the appropriate FilterOperation by the inherited filter method.
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
		charSet = result.getCharSet();
		
		
		for (int y = 0; y < original.getHeight(); y++) {
			for (int x = 0; x < original.getWidth(); x++) {
				if ( x == 0 || y == 0 ) {
					cluster[0] = charSet.length() - 1;
				} else {
					cluster[0] = charSet.indexOf(original.getPixel(x - 1, y - 1));
				}
				if ( x == 0 ) {
					cluster[1] = charSet.length() - 1;
				} else {
					cluster[1] = charSet.indexOf(original.getPixel(x - 1, y));
				}
				if ( x == 0 || y == original.getHeight() - 1 ) {
					cluster[2] = charSet.length() - 1;
				} else {
					cluster[2] = charSet.indexOf(original.getPixel(x - 1, y + 1));
				}
				if ( y == 0 ) {
					cluster[3] = charSet.length() - 1;
				} else {
					cluster[3] = charSet.indexOf(original.getPixel(x, y - 1));
				} 
				cluster[4] = charSet.indexOf(original.getPixel(x, y));
				if ( y == original.getHeight() - 1 ) {
					cluster[5] = charSet.length() - 1;
				} else {
					cluster[5] = charSet.indexOf(original.getPixel(x, y + 1));
				}
				if ( x == original.getWidth() - 1 || y == 0 ) {
					cluster[6] = charSet.length() - 1;
				} else {
					cluster[6] = charSet.indexOf(original.getPixel(x + 1, y - 1));
				}
				if ( x == original.getWidth() - 1 ) {
					cluster[7] = charSet.length() - 1;
				} else {
					cluster[7] = charSet.indexOf(original.getPixel(x + 1, y));
				}
				if ( x == original.getWidth() - 1 || y == original.getHeight() - 1 ) {
					cluster[8] = charSet.length() - 1;
				} else {
					cluster[8] = charSet.indexOf(original.getPixel(x + 1, y + 1));
				}
				result.setPixel(x, y, charSet.charAt(filter(cluster)));
			}
		}
		return result;
	}
	public abstract int filter(int [] cluster);
	
}
