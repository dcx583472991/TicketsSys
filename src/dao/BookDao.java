package dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import bean.Book;
import common.HibernateSessionFactory;

public class BookDao {

	
	SessionFactory sessionFactory;
	
	public BookDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public int insertBooking(Book book, String UserName){
		Session session = null;
		int num=0;
		try{
			session=sessionFactory.openSession();
			book.setUserName(UserName);
			Transaction trans=session.beginTransaction();
			num=Integer.parseInt(session.save(book).toString());
			trans.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getTickets(String UserName){
		List<Book> bookList=new ArrayList<Book>();
		Session session=null;
		System.out.println("UserName = "+UserName);
		try{
			session=sessionFactory.openSession();
			System.out.println("session = "+session);
			//System.out.println("session的UserName用户名："+(String)ac.getSession().get("UserName"));
			bookList=session.createQuery("from Book where UserName='"+UserName+"'").list();
			System.out.println(bookList);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return bookList;
	}
	
	public boolean deleteBook(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Book books=(Book)session.get(Book.class, id);
			Transaction trans=session.beginTransaction();
			session.delete(books);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}


	public Book queryUserById(int id) {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Book books=(Book)session.get(Book.class, id);
			return books;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}	
	}


	public boolean updateUser(Book newBook) {
		System.out.println("newBook订票信息的ID号"+newBook.getId());
		System.out.println("newBook订票信息的真实姓名"+newBook.getName());
		System.out.println("newBook订票信息的始发城市"+newBook.getStartCity());
		System.out.println("newBook订票信息的目标城市"+newBook.getEndCity());
		System.out.println("newBook订票信息的出发时间"+newBook.getDate());
		System.out.println("newBook订票信息的用户名"+newBook.getUserName());
		
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(newBook);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
		
	}

	public boolean updateUserByID(int id,Book newBook){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Book oldBook=(Book)session.get(Book.class, id);
			
			oldBook.setEndCity(newBook.getEndCity());
			oldBook.setDate(newBook.getDate());
			oldBook.setStartCity(newBook.getStartCity());

			Transaction trans=session.beginTransaction();
			session.update(oldBook);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	
	public List<Book> queryByPage(int pageNo,int pageSize,String userName){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			System.out.println("session的UserName用户名："+userName);
			String queryString="from Book where userName='"+userName+"'";
			Query query=session.createQuery(queryString);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<Book> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	
	public List<Book> queryBooks(String userName){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			System.out.println("session的UserName用户名："+userName);
			String queryString="from Book where userName='"+userName+"'";
			Query query=session.createQuery(queryString);
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

}
