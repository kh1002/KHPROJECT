package chain.action;

import chain.dao.MemberDAO;
import chain.model.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MemberAction implements Action, Preparable, ModelDriven {
	
	//도메인 오브젝트
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
	
	//ModelDriven 인터페이스의 getModel 구현
	public Object getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
	
	//Preparable인터페이스의 prepare 구현
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		userInfo = new UserInfo();
	}
	
	

}
