package item;

public class Rect {
	public Point p1;
	public Point p2;
	public Rect(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public Rect(int x,int y,int w,int h) {
		this.p1 = new Point(x,y);
		this.p2 = new Point(x+w, y+h);
	}
	public   int pointInRect(int x,int y  )
	{
		if(x>  p1.x && x<  p2.x
				&& y>  p1.y && y< p2.y)
			return 1;
		
		else
			return 0;
		
	}
	
}
