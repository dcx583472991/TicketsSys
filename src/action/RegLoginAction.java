package action;


import dao.UserDao;
import bean.User;

public class RegLoginAction {
	
	private UserDao ud;
	private User registUser;

	public RegLoginAction() {}

	public UserDao getUd() {
		return ud;
	}


	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
	public User getRegistUser() {
		return registUser;
	}


	public void setRegistUser(User registUser) {
		this.registUser = registUser;
	}


	public String regist(){
		System.out.println(registUser.getUserName());
		System.out.println(registUser.getPassword());
		System.out.println(registUser.getRePassword());
		if(registUser.getUserName().equals("") || registUser.getPassword().equals(""))
			return "input";

		if(ud.registerUser(registUser)>0){
			return "success";
		}
		else
			return "input";
			
		

	}
}
