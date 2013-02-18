import java.util.*;

public abstract class FilterOperation implements Operation {

	public FilterOperation() {
	}
	
	public AsciiImage execute(AsciiImage img) {
		//Ausgabebild generieren
		AsciiImage result=new AsciiImage(img);
		
		//Blockfilter, Bild zeichenweise durchlaufen
		for(int i=0; i<img.getHeight(); i++) { //Y
			for(int j=0; j<img.getWidth(); j++) { //X
				
				//Array mit Zeichenidizes
				int[] block=new int[9];
				
				//Array füllen (im Uhrzeigersinn
				block[0]=img.getCharset().indexOf(img.getPixel(j, i)); //Mitte des 3x3-Blocks
				
				if(j==img.getWidth()-1) {
					block[1]=img.getCharset().length()-1;
				} else {
					block[1]=img.getCharset().indexOf(img.getPixel(j+1, i));
				}
	
				if(j==img.getWidth()-1 || i==img.getHeight()-1) {
					block[2]=img.getCharset().length()-1;
					
				} else {
					block[2]=img.getCharset().indexOf(img.getPixel(j+1, i+1));
				}
				
				if(i==img.getHeight()-1) {
					block[3]=img.getCharset().length()-1;
				} else {
					block[3]=img.getCharset().indexOf(img.getPixel(j, i+1));
				}
				
				if(j==0 || i==img.getHeight()-1) {
					block[4]=img.getCharset().length()-1;
				} else {
					block[4]=img.getCharset().indexOf(img.getPixel(j-1, i+1));
				}
				
				if(j==0) {
					block[5]=img.getCharset().length()-1;
				} else {
					block[5]=img.getCharset().indexOf(img.getPixel(j-1, i));
				}
				
				if(j==0 || i==0) {
					block[6]=img.getCharset().length()-1;
				} else {
					block[6]=img.getCharset().indexOf(img.getPixel(j-1, i-1));
				}
				
				if(i==0) {
					block[7]=img.getCharset().length()-1;
				} else {
					block[7]=img.getCharset().indexOf(img.getPixel(j, i-1));
				}
				
				if(j==img.getWidth()-1 || i==0) {
					block[8]=img.getCharset().length()-1;
				} else {
					block[8]=img.getCharset().indexOf(img.getPixel(j+1, i-1));
				}
				
				//Array an Filter-Operation übergeben
				result.setPixel(j, i, img.getCharset().charAt(filter(block)));
			}
		}
		
		return result;
	}
	
	
	public abstract int filter(int[] values);
				
				
}
