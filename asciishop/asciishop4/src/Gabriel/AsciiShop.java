import java.util.Scanner;

/**
 * Diese Klasse ist ausführbar und beinhaltet daher die main-Methode.
 * Sie verarbeitet die Eingaben, erzeugt das AsciiImage und gibt das Ergebnis
 * aus. Methoden dieser Klasse lesen direkt von System.in ein und geben direkt
 * auf System.out aus. 
 *
 * @author Gabriel Rauter MN1026292
 * @version 1.0
 */
public class AsciiShop {
	/**
	 * Liest die Daten und Befehle ein und gibt das Ergebnis aus.
	 *
	 * @param args Dieses Programm benötigt keine Parameter
	 */
	public static void main(String[] args) {
		
		// Initialisierung der Scannerklasse mit System.in als Standardeingabe
		Scanner input = new Scanner(System.in);
		
		// Fehlerstrings setzen
		final String inputError = "INPUT MISMATCH";
		final String decodeError = "INVALID KEY";
		final String commandError = "UNKNOWN COMMAND";

		// Kontrolle ob read Befehl gegeben ist
		if (!input.next().equals("create")) {
			System.out.println(inputError);
			return;
		}
		
		// Initalisierung der höhe und breite, sowie kontrolle ob diese nach dem
		// create Befehl gegeben sind und ob sie beide größer Null sind.
		int width = 0;
		int height = 0;

		if (input.hasNextInt()) {
			width = input.nextInt();
		} else {
			System.out.println(inputError);
			return;
		}
		if (input.hasNextInt()) {
			height = input.nextInt();
		} else {
			System.out.println(inputError);
			return;
		}
		
		if (width <= 0 || height <= 0) {
			System.out.println(inputError);
			return;
		}
		
		// Instanz der Klasse AsciiImage mit Breite und Höhe des Bildes
		AsciiImage image = new AsciiImage(width, height);
		input.nextLine(); // Sprung in die nächste Zeile
		
		// Kontrolle ob ein korrekter Befehl mit korrekten Parametern folgt,
		// und gegebenfalls dessen Ausführung.
		
		while (input.hasNextLine()) {
			Scanner command = new Scanner(input.nextLine());
			String mainCommand = command.next();
			
			if (mainCommand.equals("clear")) {
				if (command.hasNext()) {
						System.out.println(inputError);
						return;
				}
				image.clear();
				
			} else if (mainCommand.equals("line")) {
				int[]x = new int[4];
				for (int i = 0; i < x.length; i++) {
					if (command.hasNextInt()) {
						x[i] = command.nextInt();
					} else {
						System.out.println(inputError);
						return;
					}
				}
				char c = 0;
				if (command.hasNext()) {
					String buchstabe = command.next();
					if (buchstabe.length() == 1) {
						c = buchstabe.charAt(0);
					} else {
						System.out.println(inputError);
						return;
					}
				}
				if (command.hasNext()) {
						System.out.println(inputError);
						return;
				}
				image.drawLine(x[0], x[1], x[2], x[3], c);
				
			} else if (mainCommand.equals("load")) {
				String stopSign = "";
				if (command.hasNext()) {
					stopSign = command.next();
				} else {
					System.out.println(inputError);
					return;
				}
				if (command.hasNext()) {
						System.out.println(inputError);
						return;
				}
				for (int i = 0; i < image.getHeight(); i++) {
					String line = input.nextLine();
					if (line.length() != image.getWidth()) {
						System.out.println(inputError);
						return;
					}
					for (int j = 0; j < line.length(); j++) {					
						image.setPixel(j, i, line.charAt(j));					
					}
				}
				if (!input.nextLine().equals(stopSign)) {
						System.out.println(inputError);
						return;
				}
				
			} else if (mainCommand.equals("print")) {
				System.out.println(image);
				
			} else if (mainCommand.equals("replace")) {
					char [] c = new char[2];
					for (int i = 0; i < 2; i++) {
					String buchstabe = command.next();
					if (buchstabe.length() == 1) {
						c[i] = buchstabe.charAt(0);
					} else {
						System.out.println(inputError);
						return;
					}
				}
				image.replace(c[0], c[1]);
				
			} else if (mainCommand.equals("transpose")) {
				image.transpose();
				
			} else if (mainCommand.equals("flip-v")) {
				image.flipV();
				
			} else if (mainCommand.equals("uniqueChars")) {
				System.out.println(image.getUniqueChars());
				
			} else if (mainCommand.equals("decode")) {
				String key = "";
				if (command.hasNext()) {
					key = command.next();
				} else {
					System.out.println(inputError);
					return;
				}
				if (!image.decode(key)) {
					System.out.println(decodeError);
					return;
				}
				
			} else {
				System.out.println(commandError);
				return;
			}
		}
	}
}