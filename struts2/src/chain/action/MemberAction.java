package chain.action;

import chain.dao.MemberDAO;
import chain.model.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MemberAction implements Action, Preparable, ModelDriven {
	
	//������ ������Ʈ
	UserInfo userInfo;
	public String execute() throws Exception {
		MemberDAO dao = new MemberDAO();
		
		if(dao.save(userInfo)) {
			return SUCCESS;
		}
		else {
			return LOGIN;
		}
	}
	
	//ModelDriven �������̽��� getModel ����
	public Object getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
	
	//Preparable�������̽��� prepare ����
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		userInfo = new UserInfo();
	}
	
	

}
