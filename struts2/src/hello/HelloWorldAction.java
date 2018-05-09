package hello;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String name;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception {
		msg = "Hello," + name;
		return SUCCESS;
	}
}
