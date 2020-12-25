package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {

	private final MathImpl mathImpl;
	
	
	
	public ProxyUtil(MathImpl mathImpl) {
		super();
		this.mathImpl = mathImpl;
	}



	public Object getProxy() {
		//获取当前类的类加载器，用来加载代理对象所属类
		ClassLoader loader = this.getClass().getClassLoader();
		//获取目标对象实现的所有接口的Class，代理类回合目标类实现相同的接口，最终通过代理对象实现功能
		Class[] interfaces = mathImpl.getClass().getInterfaces();

		//代理对象实现功能的方式
		return Proxy.newProxyInstance(loader, interfaces, (proxy, method, args) -> {
			try {
				MyLogger.before(method.getName(), Arrays.toString(args));
				Object result = method.invoke(mathImpl, args);//动态代理对象实现功能
				MyLogger.after(method.getName(), result);
				return result;
			} catch (Exception e) {
				MyLogger.throwing();
				e.printStackTrace();
			} finally {
				System.out.println("哪都有我");
			}
			return null;
		});
	}
	
}
