package web_bookstore02;

import java.util.UUID;

import org.junit.Test;

import com.atuigu.bookstore.domain.User;
import com.atuigu.bookstore.service.UserService;
import com.atuigu.bookstore.service.impl.UserServiceImpl;

public class UserServiceTest {

	@Test
	public void testRegist() {
		UserService service = new UserServiceImpl();
		boolean success = service.regist(new User(UUID.randomUUID().toString(), "xfzhang5",
				"1234", "tt@qq.com"));
		System.out.println(success);
		
	}
	
	@Test
	public void testLogin() {
		UserService service = new UserServiceImpl();
		boolean success = service.login("xfzhang9", "123456");
		System.out.println(success);
		
	}
}
