package action;
import bean.*;
import dao.UserDao;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LogAction {
	
	private User users;
	private UserDao ud;

	public LogAction() {}
	
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	public String execute( )throws Exception{
		
		
		return "success";
		
	}
	
	public String login(){	
		
		Map<String, Object> m;
		m=ActionContext.getContext().getSession();

		if(ud.checkLogin(users)){
			m.put("users", users);
			m.put("UserName",users.getUserName());
			System.out.println("字符串UserName->"+m.get("UserName"));
			System.out.println("对象user->"+users);
			return "success";
		}else{
			return "input";
		}
		
	}
	


}
