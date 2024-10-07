package chap06;

public class Car {
	// field
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	private int maxSpeed = 350;
	private int speed;
	private int gas;
	private boolean stop;
	
	// 생성자
	// 메소드
//	void setGas(int gas) {
//		this.gas = gas;
//	}
//	
//	int getSpeed() {
//		return speed;
//	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {			
			this.speed = speed;
		}
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}

	// 가스 존재 여부 체크
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas있음");
		return true;
	}

	void run() {
		while(true) {
			if(gas > 0) {
				System.out.printf("나는 달린다. gas 잔량: %d\n", gas);
				gas--;
			} else {
				System.out.printf("나는 멈춘다. gas 잔량: %d\n", gas);
				return;
			}
		}
	} //End run
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	void run2() {
		for(int i = 10; i <= 50; i += 10) {
			speed = i;
			System.out.println("달립니다.(시속 : " + speed);
		}
	} // End run2
	
} //End Main
