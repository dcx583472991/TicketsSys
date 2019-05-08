package action;
import com.opensymphony.xwork2.ActionSupport;

import bean.Book;
import dao.BookDao;

public class UpdataBookInfoAction extends ActionSupport {
	private int id;
	private Book book;
	private BookDao bd;
	
	public UpdataBookInfoAction(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookDao getBd() {
		return bd;
	}

	public void setBd(BookDao bd) {
		this.bd = bd;
	}

	
	public String execute(){
		System.out.println("UpdataBookInfoAction的Book对象信息"+book);
		System.out.println("UpdataBookInfoAction订票信息的ID号"+book.getId());
		System.out.println("UpdataBookInfoAction订票信息的真实姓名"+book.getName());
		System.out.println("UpdataBookInfoAction订票信息的始发城市"+book.getStartCity());
		System.out.println("UpdataBookInfoAction订票信息的目标城市"+book.getEndCity());
		System.out.println("UpdataBookInfoAction订票信息的目标城市"+book.getDate());
		System.out.println("UpdataBookInfoAction订票信息的用户名"+book.getUserName());
		if(bd.updateUserByID(book.getId(),book)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
