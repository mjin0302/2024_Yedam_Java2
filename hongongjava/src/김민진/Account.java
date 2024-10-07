package 김민진;

public class Account {
	
	// field
	private String ano;					// 계좌번호
	private String owner;				// 소유자
	private int balence;				// 잔액
	public  int MIN_BALANCE = 0;		// 잔액 최소값
	public  int MAX_BALANCE = 1000000;	// 잔액 최대값
	
	//private int inputAno;
	//private Account[] accounts;

	// constructor
	public Account() {};
	
	public Account(String ano, String owner, int balence) {
		this.ano = ano;
		this.owner = owner;
		this.balence = balence;
	};

//	// method
//	public boolean isAnoMatch(String ano) {
//		if(!this.ano.equals(ano)) {
//			return true;
//		} else {
//			return false;
//		}
//	    //return this.ano.equals(ano);  
//	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalence() {
		return balence;
	}
	public void setBalence(int balence) {
		this.balence = balence;
	}

}
