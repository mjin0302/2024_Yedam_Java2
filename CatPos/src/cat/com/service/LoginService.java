package cat.com.service;

import java.util.regex.Pattern;

import cat.com.ConsoleShow;
import cat.com.dao.LoginDAO;
import cat.com.vo.Member;

public class LoginService extends ConsoleShow {
	
	// field
	String id;
	String pass;
	String name;
	String phone;
	
	boolean stop;
	
	Member mem = new Member();
	LoginDAO login = new LoginDAO();
	
	// 하나 이상의 대문자, 숫자, 특수문자를 입력하세요
	private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    
    // method	
    // 정규식 체크 함수
    public boolean isValid(String pass) {
    	
        if (pass == null) {
            return false;
        }
        return pattern.matcher(pass).matches();
    }
	
    // 로그인
	public Member login() {
		// TODO 아이디 중복체크하기
		System.out.print("아이디 입력 ▷ ");
		id = sc.nextLine();
		
		System.out.print("\n비밀번호 입력 ▷ ");
		pass = sc.nextLine();
		
		mem = login.loginChk(id, pass);
		
		return mem;
		
	} // End of loginService()
	
	boolean run = true;
	
	public String signInService() {
		
		while(run) { // 아이디 중복 체크
			System.out.print("아이디를 입력하세요 ▷ ");
			id = sc.nextLine();
			
			String result = login.idChk(id);
			if(result == null) {
				run = false; 
			} else System.out.println("\n중복된 아이디 입니다. 다시 입력하세요");
		}
		
		run = true;
		while(run) {	// 비밀번호 정규식 체크
			System.out.println("\n대문자, 숫자, 특수문자 포함 8자리 이상! 단, 특수문자는 !@#$%^&*()-+=] 만 해당");
			System.out.print("비밀번호를 입력하세요 ▷ ");
			pass = sc.nextLine();
			
			// 비밀번호 정규식 체크
			boolean passBoo = isValid(pass);
			if(passBoo == true) run = false;
		}
		
		System.out.print("\n이름을 입력하세요 ▷ ");
		name = sc.nextLine();
		
		System.out.print("\n폰번호를 입력하세요 ▷ ");
		phone = sc.nextLine();
		
		int cnt = login.signIn(new Member(id, pass, name, phone));
		if(cnt > 0) {
			return name;
		}
		return null;
	} // signInService

} // End of Class LoginService
