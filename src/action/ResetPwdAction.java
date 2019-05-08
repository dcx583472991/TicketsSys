package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDao;

public class ResetPwdAction extends ActionSupport {
	String oldPwd;
	String newPwd;
	String newPwd2;
	
	User user;
	UserDao ud;
	
	public ResetPwdAction() {}
	
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getNewPwd2() {
		return newPwd2;
	}
	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}
	
	public String execute(){
		Map map=ActionContext.getContext().getSession();
		user=(User) map.get("users");
		if(ud.resetPwd(user, oldPwd, newPwd)){
			return SUCCESS;
		}else{
			this.addFieldError("oldPwd","���������");
			return INPUT;
		}
	}
	
}
