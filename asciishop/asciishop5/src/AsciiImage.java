import java.util.ArrayList;

public class AsciiImage {
    
    private char image[][];
    ///////////////
    // CONSTRUCTORS
    ///////////////
    public AsciiImage(int width, int height) {

	this.image = new char[width][height];
	
	
	for (int j = 0; j < this.getHeight(); j++) {
	    for (int i = 0; i < this.getWidth(); i++) {
		image[i][j] = '.';
	    }
	}
    }
    
    public AsciiImage(AsciiImage img) {
	this.image = new char[img.getWidth()][img.getHeight()];
	for (int y = 0; y < img.getHeight(); y++) {
	    for (int x = 0; x < img.getWidth(); x++) {
		this.setPixel(x, y, img.getPixel(x, y));
	    }
	}
    }
    
    
    //////////////////
    // METHODS
    //////////////////
    public void clear() {
	// clears the image by writing '.' in every position
	for (int y = 0; y < this.getHeight(); y++) {
	    for (int x = 0; x < this.getWidth(); x++) {
		image[x][y] = '.';
	    }
	}
    }
    public void drawLine(int x0, int y0, int x1, int y1, char c) {

	float disX = x1 - x0;
	float disY = y1 - y0;
	
	// checking if slope is under or equal 45 degree
	if (Math.abs(disX) >= Math.abs(disY)) {
	    float slope = 0;
	    int stepX = 0;
	    // checking if line goes up or down
	    if(disY >= 0) {
		
		// checking if line goes left or right
		if (disX >= 0) {
		    slope = disY / disX;
		    stepX = 1;
		} else {
		    disX = -disX;
		    slope = disY/disX;
		    stepX = -1;
		}
	    } else {
		
		// checking if line goes left or right
		if (disX >= 0) {
		    disY = -disY;
		    slope = -disY /disX;
		    stepX = 1;
		} else {
		    disX = -disX;
		    slope = disY /disX ;
		    stepX = -1;
		}
	    }
	    int posX = x0;
	    float posY = y0;
	    for (int i = 0; i <= disX; i ++) {
		image[posX][(int)(posY + 0.5)] = c;
		posX += stepX;
		posY += slope;
	    }
	}
	
	// checking if slope is over 45 degree
	if (Math.abs(disX) < Math.abs(disY)) {
	    float slope = 0;
	    int stepY = 0;
	 // checking if line goes left or right
	    if (disX >= 0) {
		// checking if line goes up or down
		if (disY >= 0) {
		    slope = disX/disY;
		    stepY = 1;
		} else {
		    disY = -disY;
		    slope = disX/disY;
		    stepY = -1;
		}
	    } else {
		// checking if line goes up or down
		if (disY >= 0) {
		    slope = disX/disY;
		    stepY = 1;
		} else {
		    disY = -disY;
		    slope = disX/disY;
		    stepY = -1;
		}
	    }
	    float posX = x0;
	    int posY = y0;
	    for (int i = 0; i <= disY; i ++) {
		image[(int)(posX + 0.5)][posY] = c;
		posX += slope;
		posY += stepY;
	    }
	}
    }
    
    public AsciiPoint getCentroid(char c) {
	double sumX = 0;
	double sumY = 0;
	ArrayList<AsciiPoint> pointList = this.getPointList(c);
	for (int i = 0; i < pointList.size(); i++) {
	    sumX += pointList.get(i).getX();
	    sumY += pointList.get(i).getY();
	}
	if (!pointList.isEmpty()) {
	    return new AsciiPoint ((int)(Math.round(sumX/this.getPointList(c).size())), (int)(Math.round(sumY/this.getPointList(c).size())));
	} else {
	    return null;
	}
    }
    public int getHeight() {
	return this.image[0].length;
    }
    public int getWidth() {
	return this.image.length;
    }
    public char getPixel(int x, int y) {
	return image[x][y];
    }
    public char getPixel(AsciiPoint p) {
	return this.getPixel(p.getX(), p.getY());
    }
    public void replace(char oldChar, char newChar) {
	for (int j = 0; j < this.getHeight(); j++) {
	    for (int i = 0; i < this.getWidth(); i++) {
		if (image[i][j] == oldChar) {
		    image[i][j] = newChar;
		}
	    }
	}
	
    }
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
    public void growRegion(char c) {
	ArrayList<AsciiPoint> pointList = this.getPointList(c);
	for(int i = 0; i < pointList.size(); i++) {
	    if (this.getPixel(pointList.get(i).getX()- 1, pointList.get(i).getX()) == '.' ) {
		this.setPixel(pointList.get(i).getX()- 1, pointList.get(i).getX(), c);
	    }
	    if (this.getPixel(pointList.get(i).getX()+ 1, pointList.get(i).getX()) == '.' ) {
		this.setPixel(pointList.get(i).getX()+ 1, pointList.get(i).getX(), c);
	    }
	    if (this.getPixel(pointList.get(i).getY(), pointList.get(i).getY() - 1) == '.' ) {
		this.setPixel(pointList.get(i).getY(), pointList.get(i).getY() - 1, c);
	    }
	    if (this.getPixel(pointList.get(i).getY(), pointList.get(i).getY() + 1) == '.' ) {
		this.setPixel(pointList.get(i).getY(), pointList.get(i).getY() + 1, c);
	    }
	}
    }
    public void setPixel(int x, int y, char c) {
	image[x][y] = c;
    }
    public void setPixel(AsciiPoint p, char c) {
	this.setPixel(p.getX(), p.getY(), c);
    }
    public void transpose() {
	// creating a new arary with switched width and height to be filled with the transposed image
	char transposedImage[][] = new char[this.getHeight()][this.getWidth()];
	for (int j = 0; j < this.getHeight(); j++) {
	    for (int i = 0; i < this.getWidth(); i++) {
		transposedImage[j][i] = image[i][j];
	    }
	}
	image = transposedImage;
	
    }
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
