package interceptor1.dao;

import interceptor1.model.NumberForAdd;

public class SumDAO {
	public int add(NumberForAdd num) {
		return num.getNum1() + num.getNum2();
	}

}
