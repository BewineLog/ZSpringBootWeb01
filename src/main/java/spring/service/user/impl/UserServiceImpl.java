package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.domain.Search;
import spring.domain.User;
import spring.service.user.UserDao;
import spring.service.user.UserService;

/*
 * FileName : UserServiceImpl13.java
 *  ȸ  Ͻ  ߻ȭ interface 
 *  Component : interface  Encapsulation  밡  library
 */
@Service("userService")
//=============================================================/
//켱 1 : ޼ҵ忡  @Transactional
//켱 2 : Ŭ  @Transactional
//켱 3 : ̽  @Transactional
//======================== ߰ κ  ==========================/
@Transactional()
public class UserServiceImpl implements UserService {

	///Field
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		System.out.println("::"+getClass()+".setUserDao  Call.....");
		this.userDao = userDao;
	}
	
	///Constructor
	public UserServiceImpl() {
		System.out.println("::"+getClass()+" default Constructor Call.....");
	}

	///Method
	//==> ȸ ::  INSERT ( ȸ )
	public int addUser(User user) throws Exception {
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		///// AOP ̿ Transaction ó  Ѻκ ///////
		return userDao.addUser(user);
		// Test  Ʒ ּóϰ  κ ּ Ǯ 󺹱 ϼ.
		////////////////////////////////////////////////////////////////////////////////////////////////////
//		int result = 0;
//		System.out.println(">>>>> 1  insert =====================");
//		result =  userDao.addUser(user);
//		System.out.println(">>>>> 1  insert  : "+result);
//		System.out.println(">>>>> 2  insert =====================");
//		result = userDao.addUser(user);
//		System.out.println(">>>>> 2  insert  : "+result);
//		System.out.println(">>>>>  ????  =====================");
//		
//		return 0;
		////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	//==> ȸ ::  SELECT  ( ȸ ˻ ) 
	public User getUser(String userId) throws Exception {
		return userDao.getUser(userId);
	}
	//==> ȸ ::  UPDATE  ( ȸ   )
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}
	
	//==> ȸ ::  DELETE  ( ȸ  )
	public int removeUser(String userId) throws Exception{
		return userDao.removeUser(userId);
	}
		
	//==> ȸ ::  SELECT  (  ȸ  ˻ )	
	public List<User> getUserList(Search search) throws Exception {
		return userDao.getUserList(search);
	}
}