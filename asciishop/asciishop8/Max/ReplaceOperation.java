import java.util.ArrayList;
public class ReplaceOperation implements Operation {

	private char oldChar;
	private char newChar;

	
	public ReplaceOperation(char oldChar, char newChar) {
		this.oldChar = oldChar;
		this.newChar = newChar;
	}

	
	public AsciiImage execute(AsciiImage img) throws OperationException {

		if (img.getCharset().indexOf(newChar) < 0) {
			throw new OperationException("Invalid char");
		}

		AsciiImage result = new AsciiImage(img);

		ArrayList<AsciiPoint> region = img.getPointList(oldChar);
		for (AsciiPoint p : region) {
			result.setPixel(p, newChar);
		}

		return result;

	}

}
