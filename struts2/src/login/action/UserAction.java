package login.action;

import login.dao.UserDAO;
import login.model.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private String name;
	private String addr;
	private String tel;
	
	Log log = LogFactory.getLog(UserAction.class);
	
	
	public String execute() throws Exception {
		log.info(">>>> execute ");
		
		//UserInfo객체 생성
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		userInfo.setAddr(addr);
		userInfo.setTel(tel);
		log.info(">>>>> userInfo Object Create...");
		
		//사용자정보 입력을 위해 DAO 호출
		UserDAO loginDao = new UserDAO();
		
		if(loginDao.save(userInfo)) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
