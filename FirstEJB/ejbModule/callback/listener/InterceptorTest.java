package callback.listener;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorTest {
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {
		System.out.println("*** Intercepting call to Stateless Session Bean before method call: " + ctx.getMethod().getName());
		 return ctx.proceed();
		//System.out.println("*** Intercepting call to Stateless Session Bean after method call: " + ctx.getMethod().getName());	
	}
}
