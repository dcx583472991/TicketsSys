package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import common.HibernateSessionFactory;
import bean.User;

public class UserDao {
	SessionFactory sessionFactory;
	
	public UserDao(){}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkLogin(User user){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from User where UserName=? and Password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, user.getUserName());
			query.setParameter(1, user.getPassword());
			List<User> list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	
	public int registerUser(User registUser){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			System.out.println("session------->>>>"+session);
			System.out.println("transaction------->>>>"+transaction);
			num=Integer.parseInt(session.save(registUser).toString());
			transaction.commit();
		}catch(Exception e){
			num=0;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}

	public boolean resetPwd(User user, String oldPwd, String newPwd) {
		boolean flag=true;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where UserName=? and Password=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, user.getUserName());
			queryObject.setParameter(1, oldPwd);
			System.out.println("鐢ㄦ埛鍚�->"+user.getUserName());
			System.out.println("鏃у瘑鐮�->"+oldPwd);
			List<User> list=queryObject.list();
			System.out.print(list);
			if(list.size()==0){
				flag=false;
			}else{
				user=list.get(0); 
				user.setPassword(newPwd);
				transaction=session.beginTransaction();
				session.update(user);
				transaction.commit();
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	
}
