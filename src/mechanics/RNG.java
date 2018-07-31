package mechanics;

import java.util.Random;

public class RNG {
	
	public int randomNumber(int a) {
		Random rng = new Random();
		int rnum = rng.nextInt(a);
		return rnum;
	}
	
}
