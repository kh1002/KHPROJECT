package checkbox.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import checkbox.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class CheckBoxAction implements Action, Preparable, ModelDriven {
	User user;
	Log log = LogFactory.getLog(CheckBoxAction.class);
	
	public String execute() throws Exception {
		log.info(">>>> male   : " + user.getMale());
		log.info(">>>> female : " + user.getFemale());
		return SUCCESS;
	}

	public void prepare() throws Exception {
		user = new User();
	}
	
	public Object getModel() {
		return user;
	}
	
}
