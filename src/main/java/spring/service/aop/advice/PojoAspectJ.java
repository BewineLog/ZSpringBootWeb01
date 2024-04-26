package spring.service.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 *FileName : TestAspectJ02.java :: annotation  Advisor(Aspect) 
 *	 TestAspectJ01.java ==> work() method : point cut 
 *	 TestAspectJ02.java ==> advice   point cut     
 */

//==>Advisor(Aspect) Definition (Aspect = advice+point cut )
//@Aspect
//===================> ߰Ⱥκ=======================//
//@Component
public class PojoAspectJ {

	///Constructor
	public PojoAspectJ() {
		System.out.println(":: TestAspectJ02 Default Cosntructor");
	}

	//==>Advice  point cut 
	//==> execution(*spring.service.emp.*.*(..)::aop package sub package  Method
	@Around("execution(* spring.service..*Impl.*(..)  )")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
			
		System.out.println("[Around before] "+getClass()+".invoke() start.....");
		System.out.println("[Around before] 타겟 객체 :"+
													joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] 타겟객체 method :"+
													joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length !=0){
			System.out.println("[Around before] 타겟 객체에 호출할  "+
			                                    "method의 인자 : "+ joinPoint.getArgs()[0]);
		}
		//==> Ÿ ü Method  ȣ ϴ κ 
		Object obj = joinPoint.proceed();

		System.out.println("[Around after] 타겟 객체 호출 후 return value  : "+obj);
		System.out.println("[Around after] "+getClass()+".invoke() end.....");

		return obj;
	}
}//end of class