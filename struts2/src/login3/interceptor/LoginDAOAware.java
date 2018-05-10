package login3.interceptor;
import login3.dao.LoginDAO;

public interface LoginDAOAware {
	public void setLoginDAO(LoginDAO loginDAO);

}
