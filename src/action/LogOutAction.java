package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;;

public class LogOutAction extends ActionSupport {
	ActionContext ac=ActionContext.getContext();
	
	public String execute( )throws Exception{	
		ac.getSession().clear();
		return "success";
	}
}
