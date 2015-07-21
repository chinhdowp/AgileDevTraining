package superStarTrek;

public class Random {
	public Random(int value) {
		randomValue = value;
	}
	
	public int next(int i) {
		return randomValue;
	}
	
	int randomValue = 0;

}
