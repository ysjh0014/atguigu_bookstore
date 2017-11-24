package 泛型;

import java.util.HashMap;
import java.util.List;

/*
 * 创建DAO类的对象，分别调用其save、get、update、list、delete方法来操作User对象
 * 使用Junit单元测试类进行测试
 * 
 */
public class TestDAO {
	public static void main(String []args){
		DAO<User>dao=new DAO<User>();
		
		//dao.map=new HashMap<String,User>();//如果前面没有初始化，就是直接为Map<String,T>map;可以在这里初始化
		dao.save("1001", new User(1,32,"梁朝伟"));
		dao.save("1002", new User(2,34,"汤唯"));
		dao.save("1003", new User(3,23,"刘嘉玲"));
		User u=dao.get("1002");//
		System.out.println(u);
		
		dao.update("1002", new User(4,45,"成龙"));
	   dao.delete("1003");
	   List<User> list=dao.list();
	   System.out.println(list);
		
	}

}
