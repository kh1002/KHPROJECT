package servletConfig.dao;

import servletConfig.model.UserInfo;

public class LoginDAO {
	
	public boolean loginChk(UserInfo userInfo) {
		
		//db���� �� �Ѿ���� ����� ������ ������ �α��� üũ
		//id�� test�̸� �α��� ����
		
		if("test".equals(userInfo.getId())) {
			userInfo.setName("��չ���");
			return true;
		}
		else {
			return false;
		}
	}
}
