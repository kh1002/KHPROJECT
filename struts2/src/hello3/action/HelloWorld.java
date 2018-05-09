package hello3.action;

import com.opensymphony.xwork2.ActionSupport;


//ActionSupport 클래스를 상속받아 구현해 hello를 출력하는 HelloWorld 클래스 
public class HelloWorld extends ActionSupport {
	private String name;
	private String msg;
	
	//유효성 검사. 그러나 execute()에서 실행되지는 않음. 인터럽트에서 가로챌 때 검사수행
	public void validate() {
		if(name == null || "".equals(name)) {
			addFieldError("name", "Enter 너의이름은");
		}
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception {
		msg = "Hello," +name;
		return SUCCESS;
	}

}
