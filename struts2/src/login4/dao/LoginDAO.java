package login4.dao;

public class LoginDAO {
	
	public boolean loginChk(String id, String pwd) {
		
		//db���� �� �Ѿ���� ����� ������ ������ �α��� üũ
		//id�� test�̸� �α��μ���
		if("test".equals(id)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
