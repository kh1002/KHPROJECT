package servletConfig.action;

import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import servletConfig.dao.LoginDAO;
import servletConfig.interceptor.LoginDAOAware;
import servletConfig.model.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.NoParameters;

public class LoginAction implements Action, Preparable, ModelDriven, LoginDAOAware
									,SessionAware, ServletRequestAware, RequestAware {
	
	//������ ������Ʈ
	UserInfo userInfo;
	LoginDAO dao;
	Map sessionMap;
	Map requestMap;
	
	HttpServletRequest request;
	Log log = LogFactory.getLog(LoginAction.class);
	
	public String execute() throws Exception {
		//LoginDAO dao = new LoginDAO();
		if(dao.loginChk(userInfo)) {
			sessionMap.put("userInfo", userInfo); //�ڡڡڷα��α�ɿ��� Ư�� �������� ������ ����ϴ°���
			log.info(">>>>>> requestURI : " + request.getRequestURI());
			log.info(">>>>>> request ID : " +requestMap.get("id").toString());
			log.info(">>>>>> request PWD : " + requestMap.get("pwd").toString());
			
			return SUCCESS;
		}
		else {
			return LOGIN;
		}
	}
	
	//Preparable�������̽��� prepare ����
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		userInfo = new UserInfo();
	}

	//ModelDriven �������̽��� getModel ����
	public Object getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
	
	//LoginDAUInterceptor���� LoginDAO�� �����Ѵ�.
	public void setLoginDAO(LoginDAO loginDAO) {
		// TODO Auto-generated method stub
		this.dao = loginDAO;
	}
	
	//SessionAware�� setSession ����
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.sessionMap = session;
	}

	//RequestAware�� setRequest ����
	public void setRequest(Map requestMap) {
		// TODO Auto-generated method stub
		this.requestMap = requestMap;
	}
	
	//ServletRequestAware�� serServletRequest ����
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	

	
	

}
