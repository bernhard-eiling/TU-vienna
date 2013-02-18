public class AsciiImage {

    private boolean wrongPicture = false;
    private String wholePicture = "";
    private int firstLineLength;
    private int numLine = 0;

    public AsciiImage() {

    }

    // Hinzufuegen einzelner lines zum Gesamtbild
    public boolean addLine(String line) {
	// ueberpruefen ob erste Zeile laenger als 0
	if (numLine <= 0 && line.length() < 1) {
	    wrongPicture = true;
	} else {
	    firstLineLength = line.length();
	}

	// ueberpruefen ob alle Zeilen gleich lang sind
	if (numLine > 0 && firstLineLength != line.length()) {
	    wrongPicture = true;
	}

	wholePicture += line;
	numLine++;

	return wrongPicture;
    }

    //gibt Zeilenlaenge zurueck
    public int getWidth() {
	return firstLineLength;
    }

    // gibt Zeilenanzahl zurueck
    public int getHeight() {
	return numLine;
    }
    
    // ueberprueft ob ob das Bild symmetrisch ist
    public boolean isSymmetricH() {
	boolean sym = true;
	for (int i = 0; i< numLine; i++) {
	    for (int k = 0; k < firstLineLength; k++) {
		if ( getPixel(k,i) != getPixel( firstLineLength - k -1, i)) {
		    sym = false;
		}
	    }
	}
	
	return sym;
    }

    // formatiert den Bildstring in ein anzeigbares Bild
    public String toString() {
	String outputPicture = "";
	for (int i = 0; numLine > i; i++) {
	    if (numLine - 1 > i) {
	    outputPicture += wholePicture.subSequence(i * firstLineLength,
		    (i + 1) * firstLineLength) + System.getProperty("line.separator");
	    }
	    if (numLine - 1 == i) {
		outputPicture += wholePicture.subSequence(i * firstLineLength,
			    (i + 1) * firstLineLength);
	    }
	}
	return outputPicture;
    }

    //zaehlt die Anzahl der unterschiedlichen Zeichen im Bild
    public int getUniqueChars() {
	String uniqueChars = "";
	for (int i = 0; wholePicture.length() > i; i++) {
	    if (!uniqueChars.contains(wholePicture.substring(i, i + 1))) {
		uniqueChars += wholePicture.charAt(i);
	    }

	}
	return uniqueChars.length();
    }

    // dreht das Bild an der X-Achse
    public void flipV() {
	String tempWholePicture = "";
	for (int i = numLine; 0 < i; i--) {
	    tempWholePicture += wholePicture.substring((i - 1) * firstLineLength, i * firstLineLength);
	}
	wholePicture = tempWholePicture;
    }
    
    // gibt ein Zeichen an der Position x, y zurueck
    private char getPixel(int x, int y) {
	return wholePicture.charAt(y * firstLineLength + x);
    }

    // transponiert das Bild
    public void transpose() {
	String tempWholePicture = "";
	for(int i = 0; i < firstLineLength; i++) {
	    for(int k = 0; k < numLine; k++) {
		tempWholePicture += getPixel(i,k);
		
	    }
	}
	// vertauschen der Hoehe und Breite des Bildes damit es nach dem transponieren korrekt formatiert wird
	int tempNumLine = 0;
	tempNumLine = numLine;
	numLine = firstLineLength;
	firstLineLength = tempNumLine;
	wholePicture = tempWholePicture;
    }
    
}
