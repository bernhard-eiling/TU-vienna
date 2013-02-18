/**
 * Diese Klasse implementiert einen Stack (vgl. Stapelspeicher), der seine Größe
 * dynamisch anpasst. Er kann eine beliebige Anzahl an AsciiImage-Objekten
 * speichern, wobei der Zugriff immer nur auf das oberste Element möglich ist.
 * Diese Implementierung nutzt intern ein Array zum Speichern der Elemente.
 *  
 * @author Gabriel Rauter MN1026292
 * @version 1.0
 */
public class AsciiStack {
	
	private AsciiImage[] stack;
	private int increment;
	
	/**
	 * Erzeugt einen Stack, der initial increment Elemente speichern kann.
	 *
	 * @param increment - Gibt an wie groß der Stack anfangs ist und um wieviel
	 * der Stack bei Bedarf vergrößert bzw. verkleinert werden soll.
	 */
	public AsciiStack(int increment) {
		this.increment = increment;
		this.stack = new AsciiImage[this.increment];
	}

	/**
	 * Gibt die Anzahl der Stack bereit stehenden Plätze zurück (sprich wie groß
	 * das zu Grunde liegende Array ist). Aufgrund der Vorgehensweise bei
	 * Vergößerung und Verkleinerung, ist das Ergebnis dieser Methode immer ein
	 * Vie lfaches von increment.
	 *
	 * @return Anzahl der Stack bereit stehenden Plätze
	 */
	public int capacity() {
		return this.stack.length;
	}

	/**
	 * Überprüft, ob zumindest ein Element am Stack liegt.
	 *
	 * @return Liefert true, falls der Stack lehr ist.
	 */
	public boolean empty(){
		if (peek() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt das oberste Element am Stack zurück und entfernt dieses. Liegt kein
	 * Element am Stack, so wird null zurückgegeben. Sind nach dem
	 * Entfernen mehr als increment Plätze leer, so wird der Stack um increment
	 * verkleinert.
	 *
	 * @return Liefert das Bild vor der letzten Änderung und springt eins
	 * in der History zurück
	 */
	public AsciiImage pop() {
		if (!this.empty()) {
			AsciiImage swap = new AsciiImage(this.stack[this.size()-1]);
			if ((this.size()-1 < this.capacity()-this.increment) && (this.capacity() > this.increment)) {	
				AsciiImage[] copy = new AsciiImage[this.capacity()-this.increment];
				for(int i = 0; i < this.size(); i++) {
					copy[i] = new AsciiImage(this.stack[i]);
				}
				this.stack = copy;
			}
			this.stack[this.size()-1] = null;
			return swap;
		}
		return null;
	}


	/**
	 * Gibt das oberste Element am Stack zurück ohne es zu entfernen.
	 * Liegt nichts am Stack, so wird null zurückgegeben.
	 *
	 * @return Liefert das Bild vor der letzten Änderung.
	 */
	public AsciiImage peek() {
		if (!this.empty()) {
			return this.stack[this.size()-1];
		}
		return null;
	}
	
	/**
	 * Legt ein AsciiImage oben auf den Stack. Ist der Stack zu diesem Zeitpunkt
	 * voll, so wird der Stack um increment vergrößert um so das Bild speichern
	 * zu können.
	 *
	 * @param img - das auf dem Stack zu speichernde Bild.
	 */
	public void push(AsciiImage img) {
		for (int i = this.capacity()-this.increment; i < this.capacity(); i++) {
			if (this.stack[i] == null) {
				this.stack[i] = img;
				return;
			}
		}
		AsciiImage[] copy = new AsciiImage[this.capacity()+this.increment];
		for(int i = 0; i < this.capacity(); i++) {
			copy[i] = new AsciiImage(this.stack[i]);
		}
		copy[this.capacity()] = img;
		stack = copy;
	}

	/**
	 * Gibt die Anzahl der im Stack belegten Plätze zurück.
	 *
	 * @return Anzahl der belegten Plätze als int.
	 */
	public int size() {
		int size = this.capacity();
		for (int i = this.capacity()-1; i > this.capacity()-this.increment-1; i--) {
			if (this.stack[i] == null) {
				size--;
			}
		}
		return size;
	}
}