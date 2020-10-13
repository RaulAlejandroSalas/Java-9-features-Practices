package ml.salastexido.forkjoin.domain;

import java.util.Random;

public class Box {
	public final int x1,y1,x2,y2;

	public Box(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public static boolean areOverlapping(Box a, Box b) {
		return !(a.x2 < a.x1 || b.x2 < a.x1 || a.y2 < b.y1 || b.y2 < a.y1 );
	}
	
	private static Random rand = new Random();
	
	public static Box newRandom(int maxX,int maxY, int maxWidth, int maxHeight) {
		int x1 = rand.nextInt(maxX),
			  x2 = x1+ rand.nextInt(Math.min(maxWidth, maxX - x1)),
			  y1 = rand.nextInt(maxY),
			  y2=  x1+ rand.nextInt(Math.min(maxHeight, maxY -y1));
		return new Box(x1,y1,x2,y2);
	}
	
	public String toString() {
		return "Box: { x1:" + x1 + "," + "x2:" + x2 + "," + "y1:" + y1 + "," + "y2:" + y2 + "}"; 
	}
	
}	
