package util;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//4/4/21
//LoggingInterceptor class
//this is the LoggingInterceptor is used to log what classes and methods are called
public class LoggingInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param ctx is the Invocation Context
	 * @return ctx is returns the class and method called
	 * @throws Exception is thrown when something bad happens
	 */
	@AroundInvoke 
	public Object methodInterceptor(InvocationContext ctx) throws Exception 
	{ 
	System.out.println("******************* Intercepting call to method: " +  
	ctx.getTarget().getClass() + "." + ctx.getMethod().getName() + "()"); 
	//returns the class and method
	return ctx.proceed(); 
	} 


}
