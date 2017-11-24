package web_bookstore02;


import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.atuigu.bookstore.domain.User");
		Object bean = clazz.newInstance();
		String name = "username";
		String value = "xfzhang";
		
		System.out.println(bean);
		
		BeanUtils.copyProperty(bean, name, value);
		
		System.out.println(bean);
	}
}
