import java.util.Scanner;

/**
 * This class loads a new image into the old one and checks if the data is valid.
 * 
 * @version 6
 * @author Bernhard Johannes Eiling
 * 
 */
 
public class LoadOperation {
	
	private String data;
	private String input;
	private Scanner sc;
	
	/**
	* Creates a new LoadOperation.
	* 
	* @param data 		 data for the new image
	* @param sc		 creates a new Scanner to read in the data
	*
	**/
	public LoadOperation(String data) {
		this.data = data;
		sc = new Scanner(data);
	}
	
	/**
	* Executes the LoadOperation by writing the new data into a created AsciiImage.
	* Valid line length, image height and charSet will be checked.
	* 
	* @param result		 returns the AsciiImage to write the data into
	* @param charSet	 charSet which will be checked
	* @param y		 counter for the image height
	*
	**/
	public AsciiImage execute (AsciiImage img) throws OperationException {
		AsciiImage result = new AsciiImage(img);
		String charSet = result.getCharSet();
		int y = 0;

		while(sc.hasNext()) {
			input = sc.nextLine();
			
			for (int t = 0; t < input.length(); t++ ) {
				if ( charSet.indexOf(input.charAt(t)) < 0 ) {
					throw new OperationException();
				}
			}
			
			if (input.length() != img.getWidth() || y >= img.getHeight() ) {
				throw new OperationException();
			} else {
				for (int x = 0; x < input.length(); x++) {
					result.setPixel(x, y, input.charAt(x));
				}
			y++;
			}
		}
		
		if (y != img.getHeight()) {
			throw new OperationException();
		}
		return result;
	}
}
