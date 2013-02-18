import java.util.*;
public class AsciiImage {
	private char[][] image;
	private String charset;
	
	
	public AsciiImage(int width, int height, String charset) throws IllegalArgumentException {
		
		//Breite/Höhe
		if(width<=0 || height<=0) {
			throw new IllegalArgumentException();
		}
		this.image=new char[width][height]; //Maße Zuweisen
		
		//Charset
		if(charset.length()==0) {
			throw new IllegalArgumentException();
		}
		char[] c=charset.toCharArray(); //Zeichensatz Prüfen
		for(int i=0; i<c.length-1; i++) {
			for(int j=i+1; j<c.length; j++) {
				if(c[i]==c[j]) {
					throw new IllegalArgumentException();
				}
			}
		}
		this.charset=charset;
		
		//Pixel Füllen(clear)
		for(int i=0; i<this.getHeight(); i++) {
			for(int j=0; j<this.getWidth(); j++) {
				this.setPixel(j, i, c[(this.getCharset().length())-1]);
			}
		}
	}
	
	
	public AsciiImage(AsciiImage img) {
		//Charset Übergeben
		this.charset=img.getCharset();
		
		//Pixel Übergeben
		this.image=new char[img.getWidth()][img.getHeight()];
		for(int i=0; i<img.getHeight(); i++) {
			for(int j=0; j<img.getWidth(); j++) {
				this.setPixel(j, i, img.getPixel(j, i));
			}
		}
	}
	
	
	public String getCharset() {
		return this.charset;
	}
	
	public int getHeight() { //Höhe bzw. Y-Wert
		return this.image[0].length;
	}
	
	
	public char getPixel(int x, int y) throws IndexOutOfBoundsException {
		//Index Prüfen
		if(x<0 || x>this.getWidth() || y<0 || y>this.getHeight()) {
			throw new IndexOutOfBoundsException();
		}
		return this.image[x][y];
	}
		
	
	
	public char getPixel(AsciiPoint p) throws IndexOutOfBoundsException {
		return this.getPixel(p.getX(), p.getY());
	}
	
	
	public ArrayList<AsciiPoint> getPointList(char c) {
		ArrayList<AsciiPoint> list=new ArrayList();
		for(int i=0; i<this.getHeight(); i++) {
			for(int j=0; j<this.getWidth(); j++) {
				if(this.getPixel(j, i)==c) {
					list.add(new AsciiPoint(j, i));
				}
			}
		}
		return list;
	}
	
	
	public int getWidth() { //Breite bzw. X-Wert
		return this.image.length;
	}
	
	
	public void setPixel(int x, int y, char c) throws IndexOutOfBoundsException {
		//Index Prüfen
		if(x<0 || x>this.getWidth() || y<0 || y>this.getHeight()) {
			throw new IndexOutOfBoundsException();
		}
		if(!charset.contains(String.valueOf(c))) {
				throw new IndexOutOfBoundsException();
		}
		
		this.image[x][y]=c;
	}
	
	
	public void setPixel(AsciiPoint p, char c) throws IndexOutOfBoundsException {
		this.setPixel(p.getX(), p.getY(), c);
	}
	
	
	public String toString() {
		String out="";
		//Zeichen zeilenweise zu String
		for(int i=0; i<this.getHeight(); i++) {
			for(int j=0; j<this.getWidth(); j++) {
				out+=this.getPixel(j, i);
			}
			out+="\r\n";
		}
		return out;
	}
}
		
		
	
	
	
