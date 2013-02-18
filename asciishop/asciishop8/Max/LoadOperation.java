import java.util.*;

public class LoadOperation implements Operation {
	private String data;
	private Scanner sc; //Scanner für Bildzeilen
	
	
	//Konstruktor
	public LoadOperation(String data) {
		this.data=data;
		this.sc=new Scanner(this.data);
	}
	
	
	public AsciiImage execute(AsciiImage img) throws OperationException {
		//Ausgabebild
		AsciiImage result=new AsciiImage(img);
		
		//Zeilen
		int h=0; //Zeilenanzahl
		
		for(int i=0; i<img.getHeight(); i++) { //Y-Koordinate
			String line=sc.nextLine();
			h+=1;
		
			if(line.length()!=img.getWidth()) { //Zeilenlänge
				throw new OperationException("OPERATION FAILED");
			}
			
			
			
			for(int j=0; j<img.getWidth(); j++) { //X-Koordinate
				if(!img.getCharset().contains(String.valueOf(line.charAt(j)))) {
					throw new OperationException("OPERATION FAILED");
				}
				result.setPixel(j, i, line.charAt(j));
			}
		}
		if(h!=img.getHeight()) { //Zeilenanzahl
			throw new OperationException("OPERATION FAILED");
		}
		
		return result;
	}
}
