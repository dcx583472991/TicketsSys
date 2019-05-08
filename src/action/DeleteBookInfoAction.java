package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;

public class DeleteBookInfoAction extends ActionSupport {
	private int id;
	BookDao bd;
	
	public DeleteBookInfoAction(){}
	
	public BookDao getBd() {
		return bd;
	}

	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute(){
		if(bd.deleteBook(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
