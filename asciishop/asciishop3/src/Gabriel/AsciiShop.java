import java.util.Scanner;

/**
 * Programm welches über die Standardeingabe Zeilen einliest und einem
 * <code>AsciiImage</code> hinzufügt. Dabei kotnrolliert es die in der
 * ersten Zeile angegebene Bildhöhe und die Gleichmäßigkeit der Bildbreite
 * mithilfe des <code>AsciiImage</code> Objekts. Am Ende einer Eingabe können
 * optional die Befehle uniqueChars, flip-v, tanspose, symmetric-h oder decode
 * folgen. AsciiShop kontrolliert ob, falls ein Befehl gegeben ist, dieser
 * Korrekt ist. Am Ende wird das eingelesene Bild wieder ausgegeben. Dabei wird
 * falls angefordert die Anzahl der unterschiedlichen Zeichen oder ob das Bild
 * symmetrisch ist noch vor dem Bild ausgegeben. In der Zeile nach dem Bild
 * folgen Breite und Höhe.
 * @author sirblackheart
 */
public class AsciiShop {
	/**
	 *
	 * @param args Dieses Programm benötigt keine Parameter
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		//Fehlerstrings setzen

		final String inputError = "INPUT MISMATCH";
		final String decodeError = "INVALID KEY";

		//Kontrolle ob read Befehl gegeben ist
		if (!input.next().equals("read")) {
			System.out.println(inputError);
			return;
		}

		try {
			//Einlesen der gegeben Bildhöhe
			int imageHeight = Integer.parseInt(input.next());
			input.nextLine(); //Sprung in die nächste Zeile

			//Instanz der Klasse AsciiImage
			AsciiImage image = new AsciiImage();

			//Einlesen des Bildes
			for (int i = 0; i < imageHeight; i++) {
				if (!image.addLine(input.nextLine())) {
					System.out.println(inputError);
					return;
				}
			}

			// Kontrolle ob ein korrekter Befehl folgt, und gegebenfalls dessen
			// Ausführung
			if (input.hasNext()) {
				String command = input.next();
				if (command.equals("uniqueChars")) {
					System.out.println(image.getUniqueChars());
				} else if (command.equals("flip-v")) {
					image.flipV();
				} else if (command.equals("transpose")) {
					image.transpose();
				} else if (command.equals("symmetric-h")) {
					System.out.println(image.isSymmetricH());
				} else if (command.equals("decode")) {
					if (!image.decode(input.next())) {
						System.out.println(decodeError);
						return;
					}
				} else {
					System.out.println(inputError);
					return;
				}
			}
			// Ausgabe des Bildes
			System.out.print(image);
			System.out.println(image.getWidth() + " " + image.getHeight());
		} catch (Exception e) {
			System.out.println(inputError);
			return;
		}
	}
}