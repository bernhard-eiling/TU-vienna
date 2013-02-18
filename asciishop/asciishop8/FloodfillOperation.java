/**
 * Creates a FloodfillOperation and executes it.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */

public class FloodfillOperation implements Operation{
	
	/**
	 * @param x		 given x-coordinate
	 * @param y		 given y-coordinate
	 * @param newColor	 color the image gets filled with
	 * @param oldCoor	 color of the adjacent pixels wich get filled
	 * @param return	 processed AsciiImage
	 *
	 */
	
	private int x;
	private int y;
	private char newColor;
	private char oldColor;
	AsciiImage result;
	
	public FloodfillOperation(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.newColor = c;
	}
	
	public AsciiImage execute(AsciiImage img) throws OperationException {
		this.result = new AsciiImage(img);
		if ( x < 0 || x > result.getWidth() || y < 0 || y > result.getHeight() || result.getCharSet().indexOf(newColor) < 0 ) {
			throw new OperationException();
		} else {
			oldColor = result.getPixel(x, y);
			fill(x, y);
		}
		return result;
	}
	
	/**
	 * recursive methos which fills all pixels containing the char newPixel.
	 */
	private void fill(int x, int y) {
		if ( x >= 0 && x < result.getWidth() && y >= 0 && y < result.getHeight()) {
			if ( result.getPixel(x, y) == oldColor ) {
				result.setPixel(x, y, newColor);
			
				fill(x, y + 1); // down
				fill(x - 1, y); // left
				fill(x, y - 1); // up
				fill(x + 1, y); // right
			}
		}
	}
}
