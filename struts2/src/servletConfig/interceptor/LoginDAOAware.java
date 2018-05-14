package servletConfig.interceptor;

import servletConfig.dao.LoginDAO;

public interface LoginDAOAware {
	public void setLoginDAO(LoginDAO loginDAO);
}
