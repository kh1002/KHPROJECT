package login3.dao;
import login3.model.UserInfo;

public class LoginDAO {
	public boolean loginChk(UserInfo userInfo) {
		
		if("test".equals(userInfo.getId())) {
			userInfo.setName("�öѱ�");
			return true;
		}
		else {
			return false;
		}
	}
}
