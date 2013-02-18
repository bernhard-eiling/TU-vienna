/**
 * This class processes a given AsciiImage into a binary AsciiImage
 * 
 * @version 7
 * @author Bernhard Johannes Eiling
 * 
 */
 
public class BinaryOperation {
	/**
	 *
	 * @param threshold	 char to determine the treshold for every pixel,
	 *		 	 the pixel will be changed to the brightess or darkesst char in the charSet
	 */
	private char threshold;
	
	public BinaryOperation(char threshold) {
		this.threshold = threshold;
	}
	
	public AsciiImage execute(AsciiImage img) throws OperationException {
		AsciiImage result = new AsciiImage(img);
		String charSet = img.getCharSet();
		if (charSet.indexOf(threshold) < 0) {
			throw new OperationException("threshold not contained in charSet");
		} else {
			int positionThreshold = charSet.indexOf(threshold);
			System.out.println("positionThreshold: " + positionThreshold);
			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					// @param i	position of pixel in charSet
					for (int i = 0; i < charSet.length(); i++) {
						if (img.getPixel(x, y) == charSet.charAt(i)) {
							if (charSet.indexOf(charSet.charAt(i)) < positionThreshold) {
								result.setPixel(x, y, charSet.charAt(0));
							} else {
								result.setPixel(x, y, charSet.charAt(charSet.length() - 1));
							}
						}
					}
				}
			}
		}
		return result;
	}
}
