import java.util.Scanner;

public class AsciiShop {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	AsciiImage image = new AsciiImage();
	String picture = "";
	String tempInput = "";

	boolean inputMismatch = false;
	boolean symmetrie = false;
	boolean checkSymmetrie = false;
	int expectedLines = 0;
	int uniqueChars = 0;
	boolean unique = false;

	// lesen und ueberpruefen des read-Befehls
	if (input.next().equals("read")) {
	    expectedLines = input.nextInt();
	} else {
	    inputMismatch = true;
	    System.out.println("fehlender read befehl");
	}

	// einlesen des Bildes
	for (int i = 0; expectedLines > i; i++) {
	    inputMismatch = image.addLine(input.next());
	}

	// Ueberpruefung und Ausfuehrung der Befehle
	if (input.hasNext()) {
	    tempInput = input.next();
	    if (tempInput.equals("flip-v")) {
		image.flipV();
	    } else if (tempInput.equals("transpose")) {
		image.transpose();
		expectedLines = image.getHeight();
	    } else if (tempInput.equals("uniqueChars")) {
		uniqueChars = image.getUniqueChars();
		unique = true;
	    } else if (tempInput.equals("symmetric-h")) {
		symmetrie = image.isSymmetricH();
		checkSymmetrie = true;
	    } else {
		inputMismatch = true;
	    }
	}

	// Ueberpruefung ob die Zeilenanzahl des Bildes gleich der erwarteten
	// Zeilenanzahl ist
	if (image.getHeight() != expectedLines) {
	    inputMismatch = true;
	}
	
	// Ausgabe der Anzahl der verschiedenen Zeichen des Bildes
	if (unique)
	    System.out.println(uniqueChars);
	if (checkSymmetrie)
	    System.out.println(symmetrie);
	
	// Ausgabe des Bildes oder des INPUT MISMATCH
	if (inputMismatch) {
	    System.out.println("INPUT MISMATCH");
	} else {
	    picture = image.toString();
	    System.out.println(picture);
	}

	// Ausgabe der Höhe und Breite des Bildes
	if (!inputMismatch)
	    System.out.println(image.getWidth() + " " + image.getHeight());
    }
}
