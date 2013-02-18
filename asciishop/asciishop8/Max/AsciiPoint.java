public class AsciiPoint {
	public final int x;
	public final int y;
	
	
	public AsciiPoint(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "("+this.getX()+","+this.getY()+")";
	}

}
