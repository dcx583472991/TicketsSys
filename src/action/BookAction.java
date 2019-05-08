package action;
import bean.Book;
import dao.BookDao;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BookAction extends ActionSupport {
	Book book;
	private BookDao bd;
	private List<Book> bookList;
	ActionContext ac;
	//无参构造方法
	public BookAction() {
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


	public String execute( )throws Exception{	
		ac=ActionContext.getContext();
		String UserName = (String)ac.getSession().get("UserName");
		System.out.println("表单提交的UserNaem->"+book.getUserName());
		System.out.println("表单提交的Name->"+book.getName());
		if(bd.insertBooking(book,UserName)>0){
			bookList=bd.getTickets(UserName);
			System.out.println("booklist的值"+bookList);
			ac.getSession().put("bookList", bookList);
			return "success";
		}
		else
			return "input";
		
	}
	
	public void validate()
	{
		if(book.getName()==null || book.getName().equals("") )
			this.addFieldError("Name","用户名不能为空");	
	
		if(book.getStartCity()==null || book.getStartCity().equals(""))
			this.addFieldError("StartCity","始发城市不能为空");
		
		if(book.getEndCity()==null || book.getEndCity().equals(""))
			this.addFieldError("EndCity","目的城市不能为空");

	}



}
