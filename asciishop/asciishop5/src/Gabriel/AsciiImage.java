
import java.util.ArrayList;

/**
 * Diese Klasse repräsentiert ein ASCII-Bild, es speichert die Zeichen des
 * Bildes und bietet entsprechende Methoden zur Modifikation und zur Abfrage
 * von Eigenschaften, wie beispielsweise Höhe und Breite. Methoden dieser
 * Klasse lesen weder direkt von System.in ein, noch geben sie direkt auf
 * System.out aus. 
 *
 * @author Gabriel Rauter MN1026292
 * @version 1.0
 */
public class AsciiImage {

	private char [][] image;

	/**
	 * Erzeugt ein ASCII-Bild der spezifizierten Größe. Anfangs sind alle Pixel
	 * auf den Wert ‘.’ gesetzt. Sie dürfen an dieser Stelle davon ausgehen, dass
	 * Breite und Höhe beide größer 0 sind. Überprüfen Sie diese Bedingung an
	 * geeigneter Stelle in der Klasse AsciiShop.
	 *
	 * @param width - Die Breite der Zeichenfläche bzw. des Bildes.
	 * @param height - Die Höhe der Zeichenfläche bzw. des Bildes.
	 */
	public AsciiImage(int width, int height) {
		this.image = new char[width][height];
		this.clear();
		
	}
	
	/**
	 * Ist ein Kopierkonstruktor. Er erzeugt ein neues AsciiImage mit dem 
	 * gleichen Inhalt, wie das übergebene Bild.
	 *
	 * @param img - Ein AsciiImage Objekt
	 */
	public AsciiImage(AsciiImage img) {
		this.image = new char[img.getWidth()][img.getHeight()];
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				this.setPixel(x, y, img.getPixel(x, y));
			}
		}
	}
	
	/**
	 * Setzt alle Pixel des Bildes auf das Zeichen ‘.’.
	 */
	public final void clear() {
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				this.setPixel(x, y, '.');
			}
		}
	}
	
	/**
	 * Gibt die Breite des Bildes (die Länge der Zeilen) zurück.
	 *
	 * @return die Breite (Spalten) des Bildes als int zurück.
	 */
	public int getWidth() {
		return this.image.length;
	}
	
	/**
	 * Gibt die Höhe des Bildes (die Anzahl der Zeilen) zurück.
	 *
	 * @return gibt die Höhe (Zeilen) des Bildes als int zurück.
	 */
	public int getHeight() {
		return this.image[0].length;
	}
	
	/**
	 * Gibt das an den übergebenen Koordinaten/Indizes gespeicherte Zeichen
	 * zurück. Sie dürfen an dieser Stelle davon ausgehen, dass die x und y
	 * gültige Koordinaten sind.
	 *
	 * @param x - Die x Koordinate des gesuchten Pixels/Charakter (Spalte).
	 * @param y - Die y Koordinate des gesuchten Pixels/Charakter (Zeile).
	 * @return Gibt den Chararcter der sich an der Koordinate (x,y) befindet
	 * zurück.
	 */
	public char getPixel(int x, int y) {
		return image[x][y];
	}
	
	/**
	 * Gibt, analog zur Methode public char getPixel(int x, int y), das Zeichen,
	 * an der durch p spezifizierten Stelle, zurück.
	 *
	 * @param p - Ein AsciiPoint mit den Koordinaten des gesuchten
	 * Pixels/Charakter (Spalte).
	 * @return Gibt den Chararcter der sich an der Koordinate (x,y) befindet
	 * zurück.
	 */
	public char getPixel(AsciiPoint p) { 
		return this.getPixel(p.getX(), p.getY());
	}
	
	/**
	 * Speichert an den übergebenen Koordinaten/Indizes das übergebene Zeichen.
	 *
	 * @param x - Die x Koordinate des zu setzenden Pixels/Charakter (Spalte).
	 * @param y - Die y Koordinate des zu setzenden Pixels/Charakter (Zeile).
	 * @param c - Der and der Koordinate (x,y) zu setzende Chararcter.
	 */
	public void setPixel(int x, int y, char c) {
		image[x][y] = c;
	}
	
	/**
	 * Speichert, analog zur Methode public char setPixel(int x, int y, char c),
	 * das übergebene Zeichen an der durch den p spezifizierten Stelle.
	 *
	 * @param p - ein AsciiPoint mit den Koordinate des zu setzenden
	 * Pixels/Charakter (Spalte).
	 * @param c - Der an der Koordinate (x,y) zu setzende Chararcter.
	 */
	public void setPixel(AsciiPoint p, char c) {
		this.setPixel(p.getX(), p.getY(), c);
	}
	
	/**
	 * Gibt eine ArrayList aller Pixel eines bestimmten Zeichens zurück.
	 * In dieser ArrayList sind Objekte vom Typ AsciiPoint, sollte es keine
	 * Punkte mit dem angegebenen Zeichen geben, so wird eine leere Liste
	 * zurückgegeben werden.
	 *
	 * @param c - Der gesuchte Chararcter.
	 * @return Gibt eine ArrayList aller AsciiPoint an denen das Zeichen c
	 * vorkommt. Ist leer, falls das Zeichen nicht vorkommt.
	 */
	public ArrayList<AsciiPoint> getPointList(char c) {
		ArrayList<AsciiPoint> pointList = new ArrayList();
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (this.getPixel(x, y) == c) {
					pointList.add(new AsciiPoint(x, y));
				}
			}
		}
		return pointList;
	}
	
	/**
	 * Vergrößert die die Flächen aller Pixel des Zeichens c, in dem es an diese
	 * Pixel angrenzende Hintergrundpixel (also Pixel mit dem Zeichen ‘.’) auf
	 * das Zeichen c setzt.
	 *
	 * @param c - Der Chararcter dessen Umrandung erweitert werden soll.
	 */
	public void growRegion(char c) {
		ArrayList<AsciiPoint> pointList = this.getPointList(c);
		for (int i = 0; i < pointList.size(); i++) {
			if (pointList.get(i).getX() < this.getWidth()-1 && this.getPixel(pointList.get(i).getX()+1, pointList.get(i).getY()) == '.') {
				this.setPixel(pointList.get(i).getX()+1, pointList.get(i).getY(), c);
			}
			if (pointList.get(i).getX() > 0 && this.getPixel(pointList.get(i).getX()-1, pointList.get(i).getY()) == '.') {
				this.setPixel(pointList.get(i).getX()-1, pointList.get(i).getY(), c);
			}
			if (pointList.get(i).getY() < this.getHeight()-1 && this.getPixel(pointList.get(i).getX(), pointList.get(i).getY()+1) == '.') {
				this.setPixel(pointList.get(i).getX(), pointList.get(i).getY()+1, c);
			}
			if (pointList.get(i).getY() > 0 && this.getPixel(pointList.get(i).getX(), pointList.get(i).getY()-1) == '.') {
				this.setPixel(pointList.get(i).getX(), pointList.get(i).getY()-1, c);
			}
		}
	}
	
	/**
	 * Verkleinert die die Flächen aller Pixel des Zeichens c, in dem es es
	 * löscht, falls es maximal einen nachbar mit gleichem Zeichen hat.
	 *
	 * @param c - Der Chararcter dessen allein vorkommende Pixel gelöscht werden
	 * sollen.
	 */
	public void straightenRegion(char c) {
		int removal;
		ArrayList<AsciiPoint> pointList = new ArrayList();
		while (true) {
			removal = 0;
			pointList = this.getPointList(c);
			for (int i = 0; i < pointList.size(); i++) {
				int nachbarn = 0;
				if (pointList.get(i).getX() < this.getWidth()-1 && this.getPixel(pointList.get(i).getX()+1, pointList.get(i).getY()) == c) {
					nachbarn++;
				}
				if (pointList.get(i).getX() > 0 && this.getPixel(pointList.get(i).getX()-1, pointList.get(i).getY()) == c) {
					nachbarn++;
				}
				if (pointList.get(i).getY() < this.getHeight()-1 && this.getPixel(pointList.get(i).getX(), pointList.get(i).getY()+1) == c) {
					nachbarn++;
				}
				if (pointList.get(i).getY() > 0 && this.getPixel(pointList.get(i).getX(), pointList.get(i).getY()-1) == c) {
					nachbarn++;
				}
				if (nachbarn <= 1) {
					this.setPixel(pointList.get(i), '.');
					removal++;
				}
			}
			if (removal == 0) {
				break;
			}
		}
	}
	
	/**
	 * Ersetzt alle Vorkommen eines bestimmten Zeichens oldChar im Bild durch
	 * ein anderes Zeichen newChar.
	 *
	 * @param oldChar  - Der zu ersetzende Pixel/Charakter.
	 * @param newChar  - Der ersetzende Pixel/Charakter.
	 */
	public void replace(char oldChar, char newChar) {
		ArrayList<AsciiPoint> pointList = this.getPointList(oldChar);
		for (int i = 0; i < pointList.size(); i++) {
				this.setPixel(pointList.get(i).getX(), pointList.get(i).getY(), newChar);
		}
	}
	
	/**
	 * Vertauscht Zeilen und Spalten des Bildes, sprich aus der ersten Zeile im
	 * Bild wird die erste Spalte usw. Dabei ändern sich Höhe und Breite des
	 * Bildes.
	 */
	public void transpose() {
		char[][] transposedImage = new char[this.getHeight()][this.getWidth()];
			for (int x = 0; x < this.getWidth(); x++) {
				for (int y = 0; y < this.getHeight(); y++) {
					transposedImage[y][x] = this.getPixel(x, y);
				}
			}
		this.image = transposedImage;
	}
	
	/**
	 * zeichnet eine Linie zwischen den Koordinaten (x0,y0) und (x1,y1).
	 * Anfangs- und Endpunkt sind dabei inkludiert. c spezifiziert das zu
	 * verwendende Zeichen.
	 *
	 * @param x0 - x Startkoordinate der zu zeichnenden Linie.
	 * @param y0 - y Startkoordinate der zu zeichnenden Linie.
	 * @param x1 - x Endkoordinate der zu zeichnenden Linie.
	 * @param y1 - y Endkoordinate der zu zeichnenden Linie.
	 * @param c - Der zum Zeichnen verwendete Pixel/Charakter.
	 */
	public void drawLine(int x0, int y0, int x1, int y1, char c) {
		int swap;
		double steigung = 0;
		if (x1 < x0) {
			swap = x0;
			x0 = x1;
			x1 = swap;
			swap = y0;
			y0 = y1;
			y1 = swap;
		}
		double deltaY = Math.abs(y1 - y0);
		double deltaX = Math.abs(x1 - x0);
		double x = x0;
		double y = y0;
		if (deltaX == 0) {
			if (y0>y1) {			
				for (y=y0; y>=y1; y--) {
					this.setPixel((int)x, (int)(y), c);
				}
			} else {
				for (y=y0; y<=y1; y++) {
					this.setPixel((int)x, (int)(y), c);
				}
			}
		} else {
			if (deltaX < deltaY) {
				steigung = deltaX / deltaY;
				if (y0>y1) {	
					for (y=y0; y>=y1; y--) {
						this.setPixel((int)(x+0.5), (int)(y), c);
						x += steigung;
					}
				} else {	
					for (y=y0; y<=y1; y++) {
						this.setPixel((int)(x+0.5), (int)(y), c);
						x += steigung;
					}
					
				}
			} else {
				steigung = deltaY / deltaX;
				if (y0>y1) {	
					for (x=x0; x<=x1; x++) {
						this.setPixel((int)x, (int)(y+0.5), c);
						y -= steigung;
					}
				} else {
					for (x=x0; x<=x1; x++) {
						this.setPixel((int)x, (int)(y+0.5), c);
						y += steigung;
					}
				}
			}
		}
	}
    
	/**
	 * Bestimmt den Schwerpunkt aller Pixel mit dem Zeichen c und gibt diesen
	 * als AsciiPoint zurück. Kommt das Zeichen nicht vor, so wird null
	 * zurückgegeben.
	 *
	 * @param c - Der Chararcter dessen Schwerpunkt berrechnet werden soll.
	 * @return Die Koordinaten des Schwehrpunkts als AsciiPoint.
	 */
	public AsciiPoint getCentroid(char c) {
		//bestimmt den Schwerpunkt aller Pixel mit dem Zeichen c und gibt diesen
		//als AsciiPoint zurück. Kommt das Zeichen nicht vor, so wird null
		//zurückgegeben.
		double tempX = 0;
		double tempY = 0;
		ArrayList<AsciiPoint> pointList = this.getPointList(c);
		for (int i = 0; i < pointList.size(); i++) {
			tempX += pointList.get(i).getX();
			tempY += pointList.get(i).getY();
		}
		long x = Math.round(tempX/pointList.size());
		long y = Math.round(tempY/pointList.size());
		if (!pointList.isEmpty()) {
			return new AsciiPoint((int)x, (int)y);
		}
		return null;
	}
    
	/**
	 * Kontrolliert aus wievielen unterschiedliche Zeichen das Bild besteht
	 *
	 * @return gibt die Anzahl der unterschiedlichen Zeichen des Bildes als
	 * <code>int</code> zurück
	 */
	public int getUniqueChars() {
		String uniqueChars = "";
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				if (!uniqueChars.contains(this.getPixel(x, y)+"")) {
					uniqueChars = uniqueChars + this.getPixel(x, y);
				}
			}
		}
		return uniqueChars.length();
	}

	/**
	 * Dreht das Bild in der vertikalen, dabei wird das Orginalbild erstetzt
	 */
	public void flipV() {
		char[][] flipedImage = new char[this.getWidth()][this.getHeight()];
			int k = 0;
			for (int y = this.getHeight(); y > 0; y--) {
				for (int x = 0; x < this.getWidth(); x++) {
					flipedImage[x][k] = this.getPixel(x, y-1);
				}
				k++;
			}
		this.image = flipedImage;
	}

	/**
	 * Decodiert ein Bild mithile eines Transpositionschlüssels, dabei wird das
	 * Orginalbild erstetzt. Der Schlüssel muss ein Teiler der Gesamtlänge des
	 * Bildes sein und dar nur aus den Ziffern 0-9 bestehen, wobei jede Ziffer
	 * nur einmal vorkommen darf.
	 *
	 * @param key - Der Schlüssel um das Bild zu decodieren.
	 * @return gibt <code>true</code> falls der Schlüssel korrekt ist,
	 * ansonsten <code>false</code>
	 */
	public boolean decode(String key) {
		int flaeche = this.getWidth()*this.getHeight();
		//Kontrolle der Schlüssellänge
		if (flaeche%key.length() != 0) {
			return false;
		}
		//Kontrolle des Schlüssels über "regex"
		for (int i = 0; i < key.length(); i++) {
			String number = String.valueOf(i);
			if (!key.matches("[0-9]*[" + number + "]{1}[0-9]*")) {
				return false;
			}
		}
		//Austausch der Zeichen entsprechend dem gegebenen Schlüssel
		char[][] decodedImage = new char[this.getWidth()][this.getHeight()];
		int k = 0;
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				int j = Integer.valueOf(key.charAt(k)+"");
				if (k > x) {	
					if (j+x-k < 0) {
						decodedImage[x][y] = this.getPixel(this.getWidth()+(j+x-k), y-1);
					} else {
						decodedImage[x][y] = this.getPixel(j+x-k, y);
					}
				} else {
					if (j+x-k >= this.getWidth()) {
						decodedImage[x][y] = this.getPixel((j+x-k)-this.getWidth(), y+1);
					} else {
						decodedImage[x][y] = this.getPixel(j+x-k, y);
					}
				}
				k++;
				if (k == key.length()) {
					k = 0;
				}
			}
		}
		this.image = decodedImage;
		return true;
	}
	
	/**
	 * Gibt eine lesbare Darstellung des ASCII-Bildes zurück. Die einzelnen
	 * Zeilen sind dabei durch Zeilenumbrüche getrennt werden.
	 *
	 * @return Das Bild als <code>String</code> mit systemabhängigen
	 * Zeinenumbrüchen
	 */
	@Override
	public String toString() {
		String outputImage = "";
		for (int i = 0; i < this.getHeight(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {
				outputImage = outputImage + this.getPixel(j, i);
			}
			outputImage = outputImage + System.getProperty("line.separator");
		}
		return outputImage;
	}
}