package result;

import com.opensymphony.xwork2.Action;

public class HelloDispatcherAction implements Action {
	public String execute() throws Exception {
		return "success";
	}

}
