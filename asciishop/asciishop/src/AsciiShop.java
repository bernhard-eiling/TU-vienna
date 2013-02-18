import java.util.Scanner;

public class AsciiShop {

    public static void main(String[] args) {

	boolean fail = false;		// gibt an ob das Ascii-Bild gültig ist oder nicht
	int numLine = 0;		// Anzahl der Zeilen
	String currentLine = "";	// gegenwärtig gelesene Zeile
	String lastLine = "";		// zuletzt gelesene Zeile
	
	Scanner input = new Scanner(System.in);
	while (input.hasNextLine()) {
	    numLine++;								// ein counter der die Zeilenanzahl zählt
	    currentLine = input.nextLine();					// auslesen einer Zeile vom Scanner
	    if (numLine > 1 && currentLine.length() != lastLine.length())	// wenn die gegenwärtige Zeile und die letzte Zeile ungleich lang sind ist das Ascii-Bild ungültig
		fail = true;
	    lastLine = currentLine;						// lastLine wird zu currentLine um im nächsten Durchlauf mit der neuen currentLine verglichen werden zu können
	}
	if (fail) {
	    System.out.println("INPUT MISMATCH");				// Ausgabe für ein ungültiges Ascii-Bild
	}
	if (!fail) {
	    System.out.println(currentLine.length() + " " + numLine);		// Ausgabe für ein gültiges Ascii-Bild (Länge jeder Zeile, Anzahl der Zeilen)
	}
    }
}
