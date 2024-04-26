package spring.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.domain.User;

/*
 * FileName : LogonCheckInterceptor.java
 *   Controller ȣ interceptor   ó/ó/Ϸó 
 *  	- preHandle() : Controller ȣ ó   
 * 			(true return ==> Controller ȣ / false return ==> Controller ȣ ) 
 *  	- postHandle() : Controller ȣ  ó
 *    	- afterCompletion() : view  ó
 *    
 *    ==> α ȸ̸ Controller ȣ : true return
 *    ==>  α ȸ̸ Controller  ȣ : false return
 */
//====================== ߰ κ. ===========================//
@Component
public class LogonCheckInterceptor extends HandlerInterceptorAdapter {

	///Field
	
	///Constructor
	public LogonCheckInterceptor(){
		System.out.println("==> LogonCheckInterceptor() default Constructor call.............");		
	}
	
	///Method
	public boolean preHandle(	HttpServletRequest request,
														HttpServletResponse response, 
														Object handler) throws Exception {
		
		System.out.println("\n[ LogonCheckInterceptor start........]");
		
		//==> α Ȯ
		HttpSession session = request.getSession(true);
		User sessionUser =null;
		if(  ( sessionUser = (User)session.getAttribute("sessionUser")  ) == null ){
			sessionUser = new User();
		}		

		//==> α ȸ̶...
		if(   sessionUser.isActive()   )  {
			
			//==> α ¿ α õ .....
			String uri = request.getRequestURI();
			
			if( uri.indexOf("logonAction") != -1 || uri.indexOf("logon") != -1){
				request.getRequestDispatcher("/user/home.jsp").forward(request, response);
				System.out.println("[ α .. α  ʿ  䱸.... ]");
				System.out.println("[ LogonCheckInterceptor end........]\n");
				return false;
			}
			
			System.out.println("[ α  ... ]");
			System.out.println("[ LogonCheckInterceptor end........]\n");
			return true;
		
		}else{ //==>  α ȭ̶...

			//==> α õ .....
			String uri = request.getRequestURI();
			
			//////////////////////////////////////////////////////////////////////////////////////////////
			//===> ߰.
			//==> logonAction ̸ Get ΰ 
			/////////////////////////////////////////////////////////////////////////////////////////////
			if( uri.indexOf("logonAction") != -1 &&  request.getMethod().equals("GET")){
				System.out.println("[ logonAction GET ٽõ  .... ]");
				request.getRequestDispatcher("/user/logon.jsp").forward(request, response);
				System.out.println("[ LogonCheckInterceptor end........]\n");
				return false;
			}
			
			if( uri.indexOf("logonAction") != -1 || uri.indexOf("logon") != -1){
				System.out.println("[ α õ  .... ]");
				System.out.println("[ LogonCheckInterceptor end........]\n");
				return true;
			}
			
			request.getRequestDispatcher("/user/logon.jsp").forward(request, response);
			System.out.println("[ α  ... ]");
			System.out.println("[ LogonCheckInterceptor end........]\n");
			return false;
			
		}
		
	}
}//end of class