/**
 * This Class clears the image with the least bright char
 * 
 * @version 7
 * @author Bernhard Johannes Eiling
 * 
 */

public class ClearOperation {
	private String charSet;
	private char charSetArray[];
	
	/**
	 * Creates a new ClearOperation
	 */
	public ClearOperation() {
	}
	
	/**
	 * Executes this ClearOperation and sets every char to the least brightest
	 * 
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A new AsciiImage reflecting the result of the executed Operation
	 */
	public AsciiImage execute(AsciiImage img) {
		this.charSet = img.getCharSet();
		charSetArray = charSet.toCharArray();
		
		AsciiImage result = new AsciiImage(img);
		
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				result.setPixel(x, y, charSetArray[charSetArray.length - 1]);
			}
		}
		return result;                                      
	}	
    }
