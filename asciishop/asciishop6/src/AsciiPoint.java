/**
 * This class creates an AsciiPoint which contains a x-coordinate, a y-coordinate
 * and a char.
 * 
 * @param x	 x-coordinate
 * @param y	 y-coordinate
 *
 * @version 6
 * @author Bernhard Johannes Eiling
 * 
 */
 
public class AsciiPoint {
    private final int x;
    private final int y;
    
    /**
     * Creates an AsciiPoint
     * 
     **/
    public AsciiPoint(int x, int y) {
	this.x = x;
	this.y = y;
    }
    
    /**
     * returns the x-coordinate
     *
     **/
    public int getX() {
	return this.x;
    }
    
    /**
     * returns the y-coordinate
     *
     **/
    public int getY() {
	return this.y;
    }
    
    /**
     * @param output	 formatted image to print
     * @param return	 returns the formatted image
     *
     **/
    public String toString() {
	String output = ("(" + this.getX() + "," + this.getY() + ")");
	return output;
    }
}
