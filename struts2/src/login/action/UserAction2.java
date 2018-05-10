package login.action;

import login.dao.UserDAO;
import login.model.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.Action;

public class UserAction2 implements Action {
	UserInfo userInfo;
/*	private String name;
	private String addr;
	private String tel;
	를 UserInfo userInfo; 가 대신한다.
*/
	
	Log log = LogFactory.getLog(UserAction.class);
	
	
	public String execute() throws Exception {
		log.info(">>>>> execute ");
		
		//UserInfo 객체 생성
		UserInfo userInfo = new UserInfo();
		log.info(">>>>> userInfo Object Create...");
		
		//사용자 정보 입력을 위해 DAO호출
		UserDAO loginDao = new UserDAO();
		
		if(loginDao.save(userInfo)) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
