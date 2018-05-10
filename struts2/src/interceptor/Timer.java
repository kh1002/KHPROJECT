package interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Timer extends AbstractInterceptor {
	private static Log log = LogFactory.getLog(Timer.class);
	
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		
		String result = invocation.invoke();
		
		long execTime = System.currentTimeMillis() - start;
		log.info("Action 수행 시간 >>>>> " + execTime + "ms");
		return result;
	}

}
