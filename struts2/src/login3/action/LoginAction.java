package login3.action;

import login3.dao.LoginDAO;
import login3.interceptor.LoginDAOAware;
import login3.model.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, Preparable, ModelDriven, LoginDAOAware {
	
	UserInfo userInfo;
	LoginDAO dao;
	
	public String execute() throws Exception {
		if(dao.loginChk(userInfo)) {
			return SUCCESS;	
		}
		else {
			return LOGIN;
		}
	}
	
	public void prepare() throws Exception {
		userInfo = new UserInfo();
	}
	
	public Object getModel() {
		return userInfo;
	}
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.dao = loginDAO;
	}
}
