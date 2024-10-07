package chap08;

public interface RemoteControl {
	
	// 상수
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	// 추상 메소드
	public void turnON();
	public void turnOff();
	public void setVolume(int volume);
	
}
