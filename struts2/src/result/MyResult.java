package result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;
import com.opensymphony.xwork2.ActionInvocation;

public class MyResult extends StrutsResultSupport {
	private static Log log = LogFactory.getLog(MyResult.class);
	public void doExecute(String location, ActionInvocation invocation) throws Exception {
		log.info("start action---");
		
		if(log.isDebugEnabled()) {
			log.debug("location -->" +location);
		}
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		RequestDispatcher dispatcher = req.getRequestDispatcher(location);
		dispatcher.forward(req, res);
		
	}

}
