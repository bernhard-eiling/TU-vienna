/**
 * Die Klasse AsciiImage kann ein AsciiBild Zeilenweise einlesen, auf seine
 * Korrektheit überprüfen und es manipulieren.
 * Kontrolle: anzahl unterschiedlicher Zeichen, horizontale symmetrie
 * Manipulation: vertikal drehen, Zeilen und Spalten tauschen
 * @author Gabriel Rauter MN1026292
 * @version 1.0
 */
public class AsciiImage {

	private int width;
	private int height;
	private String image;

	/**
	 * Erstellt ein leeres Bild mit einer Anfangsbreite und Höhe von 0
	 */
	public AsciiImage() {
		this.image = "";
		this.width = 0;
		this.height = 0;
	}

	/**
	 * addLine fügt eine neue Zeile zum Ascii Bild dazu, wobei die erste Zeile
	 * nicht leer sein darf. Dabei wird jeweil die Höhe des Bildes ums eins
	 * erhöht und nach der ersten Zeile immer wieder kontrolliert ob die gleiche
	 * Breite eingehalten wird.
	 *
	 * @param line <code>String</code> welcher dem AsciiImage hinzugeüft werden
	 * soll
	 * @return gibt <code>false</code> zurück fals die erste Zeile leer oder eine
	 * der folgende Zeilen eine verschiedene Länge hat, ansonsten
	 * wird <code>true</code> zurückgegeben.
	 */
	public boolean addLine(String line) {
		if (this.height == 0) {
			if (line.equals("")) {
				return false;
			}
			this.image = line;
			this.width = line.length();
			this.height = 1;
			return true;
		}
		if (line.length() != this.width) {
			return false;
		}
		this.image = this.image + line;
		this.height++;
		return true;
	}

	/**
	 * Gibt die Weite/Breite des eingelesenen Bildes zurück
	 *
	 * @return gibt <code>0</code> zurück, falls noch keine Zeile eingelesen
	 * wurde, ansonsten die Breite als int
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Gibt die Höhe/Anzhal der Zeilen des eingelesenen Bildes zurück
	 *
	 * @return gibt <code>0</code> zurück, falls noch keine Zeile eingelesen
	 * wurde, ansonsten die Anzahl der eingelesen Zeilen = Höhe des Bildes
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Gibt das Bild mit gesetzten Zeilenumbrüchen als String zurück
	 *
	 * @return Das Bild als <code>String</code> mit systemabhängigen Zeilenumbrüchen
	 */
	@Override
	public String toString() {
		String outputImage = "";
		for (int i = 0; i < image.length(); i+=this.width) {
				outputImage = outputImage + this.image.substring(i, i + this.width) + System.getProperty("line.separator");
		}
		return outputImage;
	}

	/**
	 * Kontrolliert aus wievielen unterschiedliche Zeichen das Bild besteht
	 *
	 * @return gibt die Anzahl der unterschiedlichen Zeichen des Bildes als
	 * <code>int</code> zurück
	 */
	public int getUniqueChars() {
		String uniqueChars = "";
		for (int i = 0; i < this.image.length(); i++) {
			if (!uniqueChars.contains(this.image.substring(i,i+1))) {
				uniqueChars = uniqueChars + this.image.substring(i,i+1);
			}
		}
		return uniqueChars.length(); }

	/**
	 * Dreht das Bild in der vertikalen, dabei wird das Orginalbild erstetzt
	 */
	public void flipV() {
		String flippedImage = "";
		for (int i = this.image.length(); i > 0; i -= this.width) {
			flippedImage = flippedImage + this.image.substring(i - this.width, i);
		}
		this.image = flippedImage;
	}

	/**
	 * vertauscht Zeilen und Spalten des Bildes, sprich aus der ersten Zeile im
	 * Bild wird die erste Spalte usw., dabei wird das Orginalbild erstetzt
	 */
	public void transpose() {
		String transposedImage = "";
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				transposedImage = transposedImage + this.image.substring(j*this.width+i,j*this.width+i+1);
			}
		}
	int tempHeight = this.height;
	this.height = this.width;
	this.width = tempHeight;
	this.image = transposedImage;
	}

	/**
	 * Überprüft, ob das Bild horizontal symmetrisch ist
	 *
	 * @return gibt <code>true</code> falls das Bild horizontal symmetrisch ist,
	 * ansonsten <code>false</code>
	 */
	public boolean isSymmetricH() {
		String line = "";
		int symetryLength = this.width/2;
		for (int i = 0; i < this.image.length(); i+=this.width) {
			line = image.substring(i, i+this.width);
			for (int j = 0; j < symetryLength-1; j++) {
				if (!line.substring(j, j+1).equals(line.substring((line.length()-j-1), (line.length()-j)))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Decodiert ein Bild mithile eines Transpositionschlüssels, dabei wird das
	 * Orginalbild erstetzt. Der Schlüssel muss ein Teiler der Gesamtlänge des
	 * Bildes sein und dar nur aus den Ziffern 0-9 bestehen, wobei jede Ziffer
	 * nur einmal vorkommen darf.
	 *
	 * @return gibt <code>true</code> falls der Schlüssel korrekt ist,
	 * ansonsten <code>false</code>
	 */
	public boolean decode(String key) {
		//Kontrolle der Schlüssellänge
		if (this.image.length()%key.length() != 0) {
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
		String decodedImage = "";
		for (int i = 0; i <= this.image.length()-key.length(); i+=key.length()) {
			String codeSub = this.image.substring(i, i+key.length());
			for (int j = 0; j < key.length(); j++) {
				decodedImage = decodedImage + codeSub.charAt(Integer.parseInt(key.substring(j,j+1)));
			}
		}
		this.image = decodedImage;
		return true;
	}
}