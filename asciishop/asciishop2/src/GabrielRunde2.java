//eprog - AsciiShop, Runde#02
//Runde:  2
//Thema:  "Asciishop A"
//Name:   Gabriel Rauter
//Matrnr: 1026292

/**
* Liest ein ein Bild über die Standardeingabe, welches optional entschlüsselt wird.
* In der ersten Zeile muss der Befehl "read x" stehen.
* Wobei x die Höhe (in Zeilen) des Bildes angibt.
* Optional kann bei einem im caesar Code verschlüsselten Bild der Befehl
* "decode xyz..." stehen. Wobei xyz... der Schlüssel zum decodieren ist.
*/

import java.util.Scanner;

class AsciiShop {

	public static void main(String[] args) {
	
		//Fehlerstrings setzen
		final String inputError = "INPUT MISMATCH";
		final String decodeError = "INVALID KEY";
		
		Scanner input = new Scanner(System.in);
		
		//Bild einlesen
		String [] asciiImage = readImage(input);
		
		//Höhe und breite des Bildes setzen
		int imageWidth = Integer.parseInt(asciiImage[1]);
		int imageHeigth = Integer.parseInt(asciiImage[2]);
		
		//Fals ein Fehler beim einlesen, Fehlermeldung ausgeben, ansonsten nachschaun ob
		//der decode Befehl gegeben ist
		if (asciiImage[0].equals(inputError)) {
			System.out.println(inputError);
		} else {
			if (input.hasNextLine()) {
				if (input.next().equals("decode")) {
					String key = input.next();
					//Fals der decode Befehl korekkt ist, das bild entschlüsseln
					if (checkKey(key, asciiImage[0].length())) {
						String decodedImage = (decodeImage(key, asciiImage[0]));
						//Dann das Bild wieder korrekt ausgeben
						for (int i = 0; i < decodedImage.length(); i+=imageWidth) {
							System.out.print(decodedImage.substring(i, i + imageWidth) + "\n");
						}
						//Höhe und Breite des Bildes ausgeben
						System.out.print(imageWidth + " " + imageHeigth);
					} else {
						//Ansonsten ausgeben, dass Schlüssel fehlerhaft ist
						System.out.println(decodeError);
					}
				} else {
					//Fehler ausgeben, da Anzahl der Zeilen falsch angegeben wurde
					//oder der decode Befehl fehlerhaft ist
					System.out.println(inputError);
				}
			} else {
				//Fals das Bild nicht decodiert ist, normal ausgeben 
				for (int j = 0; j < asciiImage[0].length(); j+=imageWidth) {
					System.out.print(asciiImage[0].substring(j, j + imageWidth) + "\n");
				}
				//Höhe und Breite des Bildes ausgeben
				System.out.print(imageWidth + " " + imageHeigth);
			}
		}
	}
	
	static String[] readImage(Scanner input) {
		String [] error = {"INPUT MISMATCH", "0", "0"};
		//Fehler ausgeben, da der Befehl read nicht korrekt ist
		if (!input.next().equals("read")) {
			return error;
		}
		//Versuchen die angegebene Anzahl an Zeilen einzulesen, ansonsten Fahler ausgeben
		try {
			int imageHeight = Integer.parseInt(input.next());
			input.nextLine();
			String curRow = "";
			String prevRow = "";
			String asciiImage = "";
			for (int i = 0; i < imageHeight; i++) {
				curRow = input.nextLine();
				if (i != 0) {
					if (prevRow.length() != curRow.length()) {
						return error;
					}
				}
				asciiImage = asciiImage + curRow;
				prevRow = curRow;
			}
			String [] asciiImageInfo = {asciiImage, String.valueOf(curRow.length()), String.valueOf(imageHeight)};
			return asciiImageInfo;
		} catch (Exception e) {
			return error;
		}
		
	}
	
	static boolean checkKey(String key, int imageLength) {
		//Kontrolle der Schlüssellänge
		if (imageLength%key.length() != 0) {
			return false;
		}
		//Kontrolle des Schlüssels über "regex"
		for (int i = 0; i < key.length(); i++) {
			String number = String.valueOf(i);
			if (!key.matches("[0-9]*[" + number + "]{1}[0-9]*")) {
				return false;
			}
		}
		return true;
	}
	
	static String decodeImage (String key, String image) {
		//Austausch der Zeichen entsprechend dem gegebenen Schlüssel
		String decodedImage = "";
		for (int i = 0; i <= image.length()-key.length(); i+=key.length()) {
			String codeSub = image.substring(i, i+key.length());
			for (int j = 0; j < key.length(); j++) {
				decodedImage = decodedImage + codeSub.charAt(Integer.parseInt(key.substring(j,j+1)));
			}
			
		}
		return decodedImage;
	}
}
