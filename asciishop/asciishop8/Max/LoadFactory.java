import java.util.*;
public class LoadFactory implements Factory {
	
	public LoadFactory() {
	}
	
	public Operation create(Scanner sc) throws FactoryException {
		String eof=sc.next();
		String abfall=sc.nextLine(); //Scanner spring eine Zeile weiter
		
		if(!sc.hasNext()){
			throw new FactoryException("Keine Bilddaten vorhanden");
		}
		
		//Bild Lesen
		String bild=""; //leerer Bildstring
		
		while(sc.hasNext()) {
			String line=sc.nextLine();
			if(line.equals(eof)) {
				break;
			}
			else {
				bild=bild+line+"\r\n";
			}
			if(!sc.hasNextLine()) {
				throw new FactoryException("Keine End of File Zeile");
			}
		}
		
		return new LoadOperation(bild);
	}
}
