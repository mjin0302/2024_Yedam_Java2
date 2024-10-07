package chap13;

public class Member {

	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member)obj;
			return mem.name.equals(name) && (mem.age == age);
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return name.hashCode() + age;
	}
}
