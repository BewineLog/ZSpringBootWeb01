package spring.service.user;

import java.util.List;

///==> ߰ κ
import org.apache.ibatis.annotations.Mapper;

import spring.domain.Search;
import spring.domain.User;

/* 
 * FileName : UserDao.java  ( Data Access Object ) 
 *  ͺ̽   ϴ ۽ýϽ   ̽
*/ 
//===========================================================
//==>  κ
//==> ߰ κ UserDaoImpl  ./==> @Mapper 
@Mapper
public interface UserDao{
	
	//==> ȸ ::  INSERT ( ȸ )
	public int addUser(User user) throws Exception;
	
	//==> ȸ ::  SELECT  ( ȸ ˻ ) 
	public User getUser(String userId) throws Exception ;

	//==> ȸ ::  UPDATE  ( ȸ   )
	public int updateUser(User user) throws Exception ;
	
	//==> ȸ ::  DELETE  ( ȸ  )
	public int removeUser(String userId) throws Exception;
	
	//==> ȸ ::  SELECT  ( ȸ  ˻ )
	public List<User> getUserList(Search search) throws Exception;
	
}//end of class