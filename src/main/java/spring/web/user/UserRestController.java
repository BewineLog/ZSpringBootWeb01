package spring.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.domain.User;

@RestController
@RequestMapping("/user/*")
public class UserRestController {
	///Field
	///Constructor
	public UserRestController(){
		System.out.println(":: UserRestController default Contructor call");
	}

	// 1.1 Client  Domain Object + Ÿ Data  JSON   .
	//û ̵Ÿ : application/json ==>  ͱȯ json 
	//http://IP:8080/user/json/user01?name=abc&age=17
	@RequestMapping(value="json/{value}" , method=RequestMethod.GET )
	public Map getUser	(	@PathVariable String value,
											@RequestParam("name") String name,
											@RequestParam("age") int age) throws Exception{
		System.out.println();
		System.out.println(value);
		System.out.println(name);
		System.out.println(age);
		
		User user = new User();
		user.setUserId("AAA");
		user.setUserName("BBB");
		user.setAge(100);
		System.out.println(user);
		
		Map map = new HashMap();
		map.put("user",user);
		//==> ܼ name=value  Data    ????
		map.put("message","ok");

		return map;
	}

	// 1.2 Client  Domain Object  .
	// û ̵Ÿ : application/json ==>  ͱȯ json 
	//http://IP:8080/Spring14/user/json/user01
//	@RequestMapping(value="json/{value}" , method=RequestMethod.GET )
//	public User getUser	(	@PathVariable String value,
//											@RequestParam("name") String name,
//											@RequestParam("age") int age) throws Exception{
//	
//		System.out.println();
//		System.out.println(value);
//		System.out.println(name);
//		System.out.println(age);
//		
//		User user = new User();
//		user.setUserId("AAA");
//		user.setUserName("BBB");
//		user.setAge(100);
//		System.out.println(user);
//		
//		return user;
//	}
	
	
	
	// 2.1 Client  Domain Object + Ÿ Data  JSON   .
	//http://192.168.0.29:8080/Spring14/user/json/getUser/user01
	@RequestMapping(value="json/getUser/{value}" , method=RequestMethod.POST )
	public Map getUser	(  	@PathVariable String value, 
											@RequestBody User user ) throws Exception{	
		System.out.println();
		System.out.println("[ From Client Data ]");
		System.out.println(value);
		System.out.println("1 : "+user);
		
		System.out.println("[To Client Data]");
		User returnUser = new User();
		returnUser.setUserId("AAA");
		returnUser.setUserName("BBB");
		System.out.println("2 : "+returnUser);
		
		Map map = new HashMap();
		map.put("user",user);
		//==> ܼ name=value  Data    ????
		map.put("message","ok");

		return map;
	}
	
	// 2.2 Client  Domain Object  .
	//http://192.168.0.29:8080/Spring14/user/json/getUser/user01
//	@RequestMapping(value="json/getUser/{value}" , method=RequestMethod.POST )
//	public User getUser	(  	@PathVariable String value, 
//											@RequestBody User user ) throws Exception{
//		System.out.println();
//		System.out.println("[ From Client Data ]");
//		System.out.println(value);
//		System.out.println("1 : "+user);
//		
//		System.out.println("[To Client Data]");
//		User returnUser = new User();
//		returnUser.setUserId("AAA");
//		returnUser.setUserName("BBB");
//		System.out.println("2 : "+returnUser);
//		
//		return returnUser;
//	}
	
}