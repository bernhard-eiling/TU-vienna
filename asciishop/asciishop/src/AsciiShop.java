import java.util.Scanner;

public class AsciiShop {

    public static void main(String[] args) {

	boolean fail = false;		// gibt an ob das Ascii-Bild g�ltig ist oder nicht
	int numLine = 0;		// Anzahl der Zeilen
	String currentLine = "";	// gegenw�rtig gelesene Zeile
	String lastLine = "";		// zuletzt gelesene Zeile
	
	Scanner input = new Scanner(System.in);
	while (input.hasNextLine()) {
	    numLine++;								// ein counter der die Zeilenanzahl z�hlt
	    currentLine = input.nextLine();					// auslesen einer Zeile vom Scanner
	    if (numLine > 1 && currentLine.length() != lastLine.length())	// wenn die gegenw�rtige Zeile und die letzte Zeile ungleich lang sind ist das Ascii-Bild ung�ltig
		fail = true;
	    lastLine = currentLine;						// lastLine wird zu currentLine um im n�chsten Durchlauf mit der neuen currentLine verglichen werden zu k�nnen
	}
	if (fail) {
	    System.out.println("INPUT MISMATCH");				// Ausgabe f�r ein ung�ltiges Ascii-Bild
	}
	if (!fail) {
	    System.out.println(currentLine.length() + " " + numLine);		// Ausgabe f�r ein g�ltiges Ascii-Bild (L�nge jeder Zeile, Anzahl der Zeilen)
	}
    }
}
