package spring.service.user;

import java.util.List;

import spring.domain.Search;
import spring.domain.User;

/*
 * FileName : UserService.java
 *  ȸ  Ͻ  ߻ȭ interface
 *  Component : interface  Encapsulation  밡  lib
 */
public interface UserService {
		
	//==> ȸ ::  INSERT ( ȸ )
	public int addUser(User user) throws Exception;
	
	//==> ȸ ::  SELECT  ( ȸ ˻ ) 
	public User getUser(String userId) throws Exception;

	//==> ȸ ::  UPDATE  ( ȸ   )
	public int updateUser(User user) throws Exception;
	
	//==> ȸ ::  DELETE  ( ȸ  )
	public int removeUser(String userId) throws Exception;
	
	//==> ȸ ::  SELECT  ( ȸ  ˻ )
	public List<User> getUserList(Search search) throws Exception;
	
}