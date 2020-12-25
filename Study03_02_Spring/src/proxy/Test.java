package proxy;

import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		
		Properties properties = System.getProperties();
		properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		/*MathI math = new MathImpl();
		int result = math.div(1, 1);
		System.out.println(result);*/
		
		ProxyUtil proxy = new ProxyUtil(new MathImpl());
		MathI math = (MathI)proxy.getProxy();
		int i = math.div(4, 1);
		System.out.println(i);
		
	}
	
}
