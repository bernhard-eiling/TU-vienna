import java.util.*;

public class ClearOperation implements Operation{
	private char c;
	
	public ClearOperation(){
	}
	
	public AsciiImage execute(AsciiImage img){
		//hellstes Zeichen festlegen
		char[] zeichen=img.getCharset().toCharArray();
		this.c=zeichen[(img.getCharset().length())-1];
		
		//Ausgabe generieren
		AsciiImage result=new AsciiImage(img);
		for(int i=0; i<img.getHeight(); i++){
			for(int j=0; j<img.getWidth(); j++){
				result.setPixel(j, i, this.c);
			}
		}
		
		return result;
	}
}


	
