package action;

import bean.Book;
import dao.BookDao;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QuerryAllByUserNameAction extends ActionSupport {
	ActionContext ac;
	Book book;
	private BookDao bd;
	
	public QuerryAllByUserNameAction() {}
	
	public BookDao getBd() {
		return bd;
	}

	public void setBd(BookDao bd) {
		this.bd = bd;
	}

	private List<Book> bookList;
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public String execute( )throws Exception{
		ac=ActionContext.getContext();
		String UserName = (String)ac.getSession().get("UserName");
		bookList=bd.getTickets(UserName);
		if(bookList.size()>0){
			System.out.println("booklist的值"+bookList);
			ac.getSession().put("bookList", bookList);
			return "success";
		}
		else
			return "input";
		
	}
}
