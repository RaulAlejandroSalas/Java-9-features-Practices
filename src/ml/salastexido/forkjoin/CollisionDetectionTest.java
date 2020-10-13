package ml.salastexido.forkjoin;

import java.util.ArrayList;

import ml.salastexido.forkjoin.domain.Box;

public class CollisionDetectionTest {

	//screen dimensions
	public static final int XRES = 1920, 
									  YRES=1080, 
									  MAXX=200, 
									  MAXY = 200;
	
	public static ArrayList<Box> makeRandomBoxes(int n){
		ArrayList<Box> result = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			result.add(Box.newRandom(XRES, YRES,MAXX,MAXY));
		}
		return result;
	}
	
	public static void main(String[] args) {
		final int TEST_SIZE = 5_000;
    	ArrayList<Box> world = makeRandomBoxes(TEST_SIZE);

	}

}
