package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import bean.Book;

public class QuerryActionById extends ActionSupport {
	int id;
	Book book;
	BookDao bd;
	
	public QuerryActionById() {}
	
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	public String execute(){
		System.out.println("该订票信息的ID号"+id);
		book=bd.queryUserById(id);
		if(book!=null){
			System.out.println("该订票信息的ID号"+id);
			System.out.println("该订票信息的真实姓名"+book.getName());
			System.out.println("该订票信息的始发城市"+book.getStartCity());
			System.out.println("该订票信息的目标城市"+book.getEndCity());
			System.out.println("该订票信息的出发时间"+book.getDate());
			System.out.println("该订票信息的用户名"+book.getUserName());
			Map<String, Object> m;
			m=ActionContext.getContext().getSession();
			m.put("book", book);
//			m.put("bookId", book.getId());
//			m.put("bookName", book.getName());
//			m.put("bookStartCity", book.getStartCity());
//			m.put("bookEndCity", book.getEndCity());
//			m.put("bookDate", book.getDate());
//			m.put("bookUserName", book.getUserName());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
