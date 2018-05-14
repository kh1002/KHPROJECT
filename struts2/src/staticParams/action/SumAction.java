package staticParams.action;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import staticParams.dao.SumDAO;
import staticParams.model.NumberForAdd;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.config.entities.Parameterizable;


public class SumAction implements Action, Parameterizable {
	//도메인 오브젝트
	NumberForAdd num;
	private int sum = 0;
	Map<String, Object> params;
	
	//Parameterizable의 setParams 메소드 구현
	public void setParams(Map<String, Object> params) {
		//paramsMap에 struts.xml의 params에 저장된 값들이 key, value형태로 저장된다.
		this.params = params;
	}
	
	//Parameterizable의 getParams 메소드 구현
	public Map<String, Object> getParams() {
		return params;
	}
	
	//Parameterizable의 addParam 메소드 구현
	public void addParam(String name, Object value) { }
	
	public String execute() throws Exception {
		num = new NumberForAdd();
		num.setNum1(params.get("num1").toString());
		num.setNum2(params.get("num2").toString());
		SumDAO dao = new SumDAO();
		sum = dao.add(num);
		return SUCCESS;
	}
	
	public int getSum() {
		return sum;
	}

}
