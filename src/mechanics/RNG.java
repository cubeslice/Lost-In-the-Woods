package mechanics;

import java.util.Random;

public class RNG {
	
	public static int randomNumber(int a) { //format: RNG.randomNumber(a)
		Random rng = new Random();
		int num = rng.nextInt(a);
		return num;
	}
	
	public static int randomNumber(int min, int max) {//format: RNG.randomRange(min,max)
		Random rng = new Random();
		int numrange = rng.nextInt(max - min + 1) + min;
		return numrange;
	}
	
}
