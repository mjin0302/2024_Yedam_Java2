package chap07;

public class Tire {
	
	// field
	public int 	  maxRotation;
	public int 	  accRotation;		// 최대 회전수
	public String location;
	
	// constructor
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// method
	public boolean roll() {
		accRotation++;
		
		if(accRotation < maxRotation) {
			System.out.println(location + "Tire 수명" + (maxRotation - accRotation) + "회");
			
			return true;
		} else {
			System.out.println("***" + location + "Tire 펑크 ***");
			
			return false;
		}
	}
}
