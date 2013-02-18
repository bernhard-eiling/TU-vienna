import java.util.Scanner;

public class AsciiShop {

    public static void main(String[] args) {

	int keyArray[] = new int[10];
	boolean inputMismatch = false;
	boolean invalidKey = false;
	boolean validPicture = true;
	int readLines = 0;
	int numLine = 0; // Anzahl der Decodierungs-Bloecke
	String key = "";
	int numBlocks = 0;
	String currentLine = "";
	String lastLine = "";
	String picture = "";
	String pictureDecoded = "";
	String tempNext = "";
	String tempBlock = "";
	char blockArray[] = new char[0];

	Scanner input = new Scanner(System.in);

	while (input.hasNext()) {

	    // //////////////
	    // First Line
	    // //////////////
	    // auslesen des read int
	    if (numLine <= 0) {
		if (input.next().equals("read")) {
		    readLines = input.nextInt();
		} else {
		    inputMismatch = true;
		}
	    }

	    // ////////////////
	    // Following Lines
	    // ////////////////
	    tempNext = input.next();

	    // key aus dem String auslesen und in ein Array als int schreiben
	    if (tempNext.equals("decode")) {
		key = input.next();
		for (int i = 0; key.length() > i; i++) {
		    keyArray[i] = (int) key.charAt(i) - 48; // es wird - 48
							    // gerechnet da die
							    // Zahlen in
							    // Asciicode
							    // ausgegeben werden
		}
		validPicture = false;

		// Schreiben der Lines in einen String
	    } else {
		currentLine = tempNext;
		picture += currentLine;
		numLine++;
	    }

	    // Ueberpruefung der gleichbleibenden Zeilenlaenge
	    if (numLine > 1 && lastLine.length() != currentLine.length()) {
		inputMismatch = true;
	    }

	    lastLine = currentLine;

	}
	// //////////////////////////////////
	// Ueberpruefung des Schluessels
	// //////////////////////////////////////

	if (key != "") {
	    // die Elemente des Arrays vergleichen um die Richtigkeit des key zu
	    // gewaehrleisten
	    for (int i = 0; i < key.length() - 1; i++) {
		for (int j = 1; j < key.length(); j++) {
		    if (i != j && keyArray[i] == keyArray[j]) {
			invalidKey = true;
		    }
		}
	    }

	    // Ueberpruefung ob die Laenge des keys kompatibel mit mit der Laenge
	    // des Bilds ist
	    if (picture.length() % key.length() != 0) {
		invalidKey = true;
	    }
	}

	// ///////////////////////////////////////////

	// Vergleich Anzahl der Zeilen mit der "read"-Zahl
	if (numLine != readLines) {
	    inputMismatch = true;
	}

	// /////////////////////////////
	// Decodieren des Bildes
	// ///////////////////////////////

	if (key != "") {
	    numBlocks = picture.length() / key.length();

	    for (int i = 0; numBlocks > i; i++) {
		tempBlock = picture.substring(key.length() * i, key.length()
			* (i + 1));
		// einlesen des blocks in ein char array danach neuanordnung
		// durch
		// das keyArray
		blockArray = tempBlock.toCharArray();
		for (int k = 0; blockArray.length > k; k++) {
		    pictureDecoded += blockArray[keyArray[k]];
		}
	    }

	    // Ausgabe des decodierten Bildes
	    if (!inputMismatch && !invalidKey) {
		for (int i = 0; i < numLine; i++) {
		    System.out.println(pictureDecoded.substring(
			    i * currentLine.length(),
			    (i + 1) * currentLine.length()));
		}
		System.out.println(currentLine.length() + " " + readLines);
	    }
	}

	// Ausgabe des eingelesenen Bildes
	if (validPicture && !inputMismatch && !invalidKey) {
	    for (int i = 0; i < numLine; i++) {
		System.out.println(picture.substring(i * currentLine.length(),
			(i + 1) * currentLine.length()));
	    }
	    System.out.println(currentLine.length() + " " + readLines);
	}

	if (inputMismatch)
	    System.out.println("INPUT MISMATCH");
	if (invalidKey)
	    System.out.println("INVALID KEY");

    }
}
