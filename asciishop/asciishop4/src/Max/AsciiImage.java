public class AsciiImage {
	private char [][] image;
	
	
	//Konstruktor
	public AsciiImage(int x, int y){
		this.image=new char[x][y];
		this.clear();	//setzt alle Pixel des AsciiImage-Objekts auf "."
	}
		
	public void setPixel(int x, int y, char c){
		this.image[x][y]=c;
	}
	
	public char getPixel(int x, int y){
		return this.image[x][y];
	}
	
	public void clear(){
		for(int a=0; a<this.image.length; a++){ //Breite
			for(int b=0; b<this.image[0].length; b++){ //Höhe
				this.setPixel(a, b, '.');
			}
		}
	}
	
	public int getWidth(){
		return this.image.length;
	}
	
	public int getHeigth(){
		return this.image[0].length;
	}
	
	public String toString(){
		String bildLesbar="";
		//Zeichenweise Array Durchlaufen
		for(int y=0; y<this.getHeigth(); y++){
			for(int x=0; x<this.getWidth(); x++){
				bildLesbar=bildLesbar+this.image[x][y];
			}
			bildLesbar=bildLesbar+"\r\n";
		}
		return bildLesbar;
	}
	
	public void replace(char oldChar, char newChar){
		//Zeilenweise durch Array
		for(int y=0; y<this.getHeigth(); y++){
			for(int x=0; x<this.getWidth(); x++){
				if(this.image[x][y]==oldChar){
					this.image[x][y]=newChar;
				}
			}
		}
	}
	
	
	//Linien Zeichnen nach DDA-Algorithmus
	public void drawLine(int x0, int y0, int x1, int y1, char c){
		
		boolean invert=false;
		
		//1. Betrag Delta x Delta y
		double deltaX=Math.abs(x1-x0);
		double deltaY=Math.abs(y1-y0);
		
		//2. Prüfen ob Delta y < Delta x, ggf alle x y Invertieren
		if(deltaX<deltaY){
			invert=true;
			
			int x0Speicher=x0;
			int x1Speicher=x1;
			x0=y0;
			x1=y1;
			y0=x0Speicher;
			y1=x1Speicher;
			
			deltaX=Math.abs(x1-x0);
			deltaY=Math.abs(y1-y0);
		}
		
		//3. Prüfen ob Anfangs- und Endpunkt zu vertauschen
		if(!(x1>=x0)){
			int x0Speicher=x0;
			int y0Speicher=y0; 
			x0=x1;
			y0=y1;
			x1=x0Speicher;
			y1=y0Speicher;
		}
		
		//4. Pixel zeichnen
		double y=(double)(y0); //y als Double für Berechnung Y-Wert
		
		if(invert){ //falls Achsen invertiert
			for(int x=x0; x<=x1; x++){ //<=, sonst fehlt letzte Zeile
				this.setPixel((int)(y), x, c);
				y=y+(deltaY/deltaX);
			}
		}
			
		else{	//falls Achsen normal
			for(int x=x0; x<x1; x++){
				this.setPixel(x, (int)(y), c);
				y=y+(deltaY/deltaX);
			}
		}
	}
	
	public void transpose(){
		//Neues Array, Breite und Höhe vertauscht
		char[][] bildTranspose=new char[this.getHeigth()][this.getWidth()];
		
		//Bild spaltenweise Durchlaufen
		for(int x=0; x<this.getWidth(); x++){
			for(int y=0; y<this.getHeigth(); y++){
				//Vertauschen von x und y Koordinate
				bildTranspose[y][x]=this.getPixel(x, y);
			}
		}
		this.image=bildTranspose;
	}

}
