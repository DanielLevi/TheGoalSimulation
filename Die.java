
public class Die {

	private int dieValue;
	
	public void roll() {
		dieValue = (int) (Math.random()*6 + 1);
	}
	
	public int getValue() {
		return dieValue;
	}
}
