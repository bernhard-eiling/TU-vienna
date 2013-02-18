/**
 * Diese Klasse repräsentiert einen Punkt, spezifiziert durch zwei ganzzahlige
 * Koordinaten. Diese Klasse ist unveränderlich (immutable), sprich die
 * Koordinaten sollen nachträglich nicht mehr veränderbar sein.
 *  
 * @author Gabriel Rauter MN1026292
 * @version 1.0
 */
public final class AsciiPoint {
	
	private final int x;
	private final int y;
	
	/**
	 * Erzeugt einen Punkt mit den angegebenen Koordinaten.
	 *
	 * @param x - x Koordinate des Punkts
	 * @param y - y Koordinate des Punkts
	 */
	public AsciiPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gibt die x-Koordinate des Punktes zurück.
	 *
	 * @return Die x Koordinate des Punkts als int
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gibt die y-Koordinate des Punktes zurück.
	 *
	 * @return Die y Koordinate des Punkts als int
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Gibt eine lesbare Darstellung des Punktes in der Form (x,y) zurück.
	 *
	 * @return Die Koordinaten des Punkts als String in der Form (x,y)
	 */
	@Override
	public String toString() {
		return "("+ this.getX() + ","+ this.getY() +")";
	}
}