package login4.action;

import login4.dao.LoginDAO;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action { 
	String id;
	String pwd;
	
	public String execute() throws Exception {
		LoginDAO dao = new LoginDAO();
		
		if(dao.loginChk(id, pwd)) {
			return SUCCESS;
		}
		else {
			return LOGIN;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	//리다이렉트일때는 아이디와 패스워드에 접근하지못함??? ?~?...?
}
