import java.util.ArrayList;
/**
 * Creates an AsciiImage which contains the image data and the charSet.
 *
 * @version 8
 * @author Bernhard Johannes Eiling
 * 
 */
 
public class AsciiImage {
	private char image[][];
	private String charSet;
    
	/**
	 * Creates a new AsciiImage with the given width, height and charSet.
	 * Sets all pixel to the darkest one of the charSet.
	 * Checks for valid width, height and charSet.
	 *
	 * @param width		 width of the image
	 * @param height		 height of the image
	 * @param charSet	 characters which the image contains
	 * 
	 **/
    
	public AsciiImage(int width, int height, String charset) throws IllegalArgumentException  {
		this.charSet = charset;
		if (width < 0 || height < 0 || charSet.length() < 0) {
			throw new IllegalArgumentException();
		} else {
			this.image = new char[width][height];
		}
		
		for(int m = 0; m <= this.charSet.length() - 1; m++) {
			for(int n = m + 1; n <= this.charSet.length() - 1; n++) {
				if (this.charSet.charAt(m) == this.charSet.charAt(n)) {
					throw new IllegalArgumentException();
				}
			}
		}	
	
		for (int j = 0; j < this.getHeight(); j++) {
			for (int i = 0; i < this.getWidth(); i++) {
				this.image[i][j] = this.charSet.charAt(this.charSet.length() - 1);
			}
		}
	}
	
	/**
	 * Creates a copy of the AsiiImage.
	 *
	 **/
	 
	public AsciiImage(AsciiImage img) {
		this.setCharSet(img.getCharSet());
		this.image = new char[img.getWidth()][img.getHeight()];
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				this.setPixel(x, y, img.getPixel(x, y));
			}
		}
	}
	
	/**
	 * @param return	 returns the height of the image
	 *
	 **/
	public int getHeight() {
		return this.image[0].length;
	}
	
	/**
	 * @param return	 returns the width of the image
	 *
	 **/
	public int getWidth() {
		return this.image.length;
	}
	
	/**
	 *
	 * Gets the char at the position x, y
	 *
	 **/
	public char getPixel(int x, int y) throws IndexOutOfBoundsException {
		if ( x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight() ) {
			return this.image[x][y];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Gets the x, y position of a AsciiPoint
	 *
	 **/
	public char getPixel(AsciiPoint p) {
		return this.getPixel(p.getX(), p.getY());
	}
        /**
         * @param return	 returns the charSet
         *
         */
        public String getCharSet() {
        	return charSet;
        }

        /**
         * @param return	 returns all AsciiPoints containing a specified char
         *
         */
        public ArrayList<AsciiPoint> getPointList(char c) {
        	ArrayList<AsciiPoint> pointList = new ArrayList<AsciiPoint>();
        	for (int y = 0; y < this.getHeight(); y++) {
        		for (int x = 0; x < this.getWidth(); x++) {
        			if(this.getPixel(x, y) == c) {
        				pointList.add(new AsciiPoint(x, y));
        			}
        		}
        	}
        	return pointList;
        }

        /**
       	  * Sets a char at the position x, y.
       	  *
       	  */
        public void setPixel(int x, int y, char c) throws IndexOutOfBoundsException {
  	  	    
        	if ( x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight() && this.charSet.indexOf(c) >= 0 ) {
        		image[x][y] = c;
        	} else {
        		throw new IndexOutOfBoundsException();
        	}
        }
        
        /**
       	  * Sets a char at the position x, y.
       	  *
       	  */
        public void setPixel(AsciiPoint p, char c) {  
        	this.setPixel(p.getX(), p.getY(), c);
        }
    
        /**
       	  * Sets a charSet.
       	  *
       	  */
        public void setCharSet(String charSet) {
        	this.charSet = charSet;
        }
    
        /**
       	  * Returns an AsciiImage in a printable format.
       	  *
       	  * @param outputimage 	´image to be returned
       	  * @param return	 returns the formated AsciiImage
       	  *
       	  */
        public String toString() {
        	String outputImage = "";
        	for (int j = 0; j < this.getHeight(); j++) {
        		for (int i = 0; i < this.getWidth(); i++) {
        			outputImage += image[i][j];
        		}
        		outputImage += System.getProperty("line.separator");
        	}
        	return outputImage;
        }
}

