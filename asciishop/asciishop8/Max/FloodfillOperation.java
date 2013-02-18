public class FloodfillOperation implements Operation{
	private int x;
	private int y;
	private char c;
	private char oldC;
	AsciiImage result;
	
	public FloodfillOperation(int x, int y, char c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	
	public AsciiImage execute(AsciiImage img) throws OperationException {
		//Parameter prüfen
		if(this.x < 0 || this.x > img.getWidth() ||
			this.y < 0 || this.y > img.getHeight() ||
			!img.getCharset().contains(String.valueOf(this.c))) {
				throw new OperationException("unvalid parameters");
		}
				
		//Ausgabebild
		this.result=new AsciiImage(img);
		
		//Punkte an floodfill
		this.oldC=img.getPixel(this.x, this.y);
		floodfill(this.x, this.y);
		
		return this.result;
	}
	
	
	private void floodfill(int x, int y) {
		//Parameter prüfen
		if(x>=0 && x<=this.result.getWidth() &&
			y>=0 && y<=this.result.getHeight()) {
			
				//Neue Pixel setzen
				if(this.result.getPixel(x, y)==this.oldC) {
					this.result.setPixel(x, y, this.c);
					
					//Umgebung im Uhrzeigersinn
					floodfill(x+1, y);
					floodfill(x, y+1);
					floodfill(x-1, y);
					floodfill(x, y-1);
				}
			}
	}
}
