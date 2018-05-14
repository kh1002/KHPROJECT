package login4.dao;

public class LoginDAO {
	
	public boolean loginChk(String id, String pwd) {
		
		//db연결 후 넘어오는 사용자 정보를 가지고 로그인 체크
		//id가 test이면 로그인성공
		if("test".equals(id)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
