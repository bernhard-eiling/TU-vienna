import java.util.*;

public class BinaryOperation implements Operation {
	private char threshold;
	
	public BinaryOperation(char threshold) {
		this.threshold=threshold;
	}
	
	public AsciiImage execute(AsciiImage img) throws OperationException {
		//Leeres Outputbild
		AsciiImage out=new AsciiImage(img);
		
		//Zeichen Prüfen
		if(!img.getCharset().contains(String.valueOf(this.threshold))) {
			throw new OperationException("Zeichen nicht im Zeichensatz");
		}
		
		//Zeichen Tauschen
		for(int i=0; i<img.getHeight(); i++) { //Bild Zeichenweise
			for(int j=0; j<img.getWidth(); j++) {
				
				//Helle Pixel
				if(img.getCharset().indexOf(img.getPixel(j, i)) < img.getCharset().indexOf(this.threshold)) {
					out.setPixel(j, i, img.getCharset().charAt(0));
				}
				
				//Dunkle Pixel
				else {
					out.setPixel(j, i, img.getCharset().charAt(img.getCharset().length()-1));
				}
			}
		}
		
		return out;
	}
}
