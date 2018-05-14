package servletConfig.dao;

import servletConfig.model.UserInfo;

public class LoginDAO {
	
	public boolean loginChk(UserInfo userInfo) {
		
		//db연결 후 넘어오는 사용자 정보를 가지고 로그인 체크
		//id가 test이면 로그인 성공
		
		if("test".equals(userInfo.getId())) {
			userInfo.setName("대왕문어");
			return true;
		}
		else {
			return false;
		}
	}
}
