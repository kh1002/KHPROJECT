package interceptor1.action;

import interceptor1.dao.SumDAO;
import interceptor1.model.NumberForAdd;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class SumAction implements Action, Preparable, ModelDriven {
	//도메인 오브젝트
	NumberForAdd num;
	private int sum = 0;
	
	public String execute() throws Exception {
		SumDAO dao = new SumDAO();
		sum = dao.add(num);
		return SUCCESS;
	}
	
	public void prepare() throws Exception  {
		num = new NumberForAdd();
	}
	
	public Object getModel() {
		return num;
	}
	
	public int getSum() {
		return sum;
	}
	
}
