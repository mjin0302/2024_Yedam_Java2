package chap07;

public class KumhoTire extends Tire{
	
	// field
	
	// constructor
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// method
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "KumhoTire Tire 수명" + (maxRotation - accRotation) + "회");
			
			return true;
		} else {
			System.out.println("***" + location + "KumhoTire Tire 펑크 ***");
			
			return false;
		}
	}
}
