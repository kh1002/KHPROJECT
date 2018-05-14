package staticParams.dao;

import staticParams.model.NumberForAdd;

public class SumDAO {
	public int add(NumberForAdd num) {
		return Integer.parseInt(num.getNum1()) + Integer.parseInt(num.getNum2());
	}

}
