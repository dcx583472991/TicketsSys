package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Book;
import dao.BookDao;

public class QueryInPageAction extends ActionSupport {
	List<Book> bookList;
	BookDao bd;
	private Book book;
	private int id;
	private final int pageSize=5;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	ActionContext ac;
	
	public QueryInPageAction(){
		
	}
	public List<Book> getBooks() {
		return bookList;
	}
	public void setBooks(List<Book> books) {
		this.bookList = books;
	}
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public String execute()throws Exception{
		ac=ActionContext.getContext();
		String userName = (String)ac.getSession().get("UserName");
		bookList=bd.queryBooks(userName);
		System.out.println("该用户数据个数："+bookList.size());

		if(bookList.size()%pageSize==0){
			totalPage=bookList.size()/pageSize;
		}else{
			totalPage=bookList.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}

		bookList=bd.queryByPage(pageNo,pageSize,userName);
		ac.getSession().put("bookList", bookList);
		System.out.println("每页的数据："+bookList.size());
		currentPage=pageNo;
		if(bookList!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
}
