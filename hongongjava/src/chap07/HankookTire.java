package chap07;

public class HankookTire extends Tire{
	
	// field
	
	// constructor
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// method
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "Hankook Tire 수명" + (maxRotation - accRotation) + "회");
			
			return true;
		} else {
			System.out.println("***" + location + "Hankook Tire 펑크 ***");
			
			return false;
		}
	}
}
