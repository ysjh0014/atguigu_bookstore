package 泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 泛型的使用：
 * 1.为什么要有泛型：①解决元素存储的安全性问题
 *               ②解决获取数据元素时，需要类型强转的问题
 * 2.在集合中使用泛型
 * 3.自定义泛型类、泛型接口、泛型方法
 * 4.泛型与继承的关系
 * 5.通配符
 * 
 * 注意：
 * 泛型的核心思想：把一个集合中的内容限制为一个特定的数据类型
 * 注意事项：①静态方法中不能使用类的泛型
 *        ②如果泛型类是一个接口或抽象类，则不可创建泛型类的对象
 *        ③不能在catch中使用泛型
 *        ④从泛型类派生子类，泛型类型需具体化
 */
public class TestGeneric {
	/*
	 * 通配符的使用
	 */
	@Test
	public void test7(){
		List  list=new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add(123);
		list.add(new Person(123,"AA"));
		List <?>list1=list;
	//可以读取声明为通配符的集合类的对象	
	Iterator <?>iterator=list1.iterator();
	while(iterator.hasNext()){
		System.out.println(iterator.next());//读取时遍历过程是Object类型的
	}
	//不允许向声明为通配符的集合类中写入对象,唯一例外的是null
	//list1.add("CC");
	//list1.add(123);
	list1.add(null);
	}
	/*
	 * 通配符？
	 * List<A>、List<B>、.....都是List<?>的子类
	 * 
	 * ? extends A:可以存放A及其子类
	 * ? super A:刻意存放A及其子类
	 */
	@Test
	public void test6(){
		List <?>list=new ArrayList();
		List <Object>list1=new ArrayList<>();
		list=list1;
		List <String>list2=new ArrayList<>();
		list=list2;
		
		show(list1);
		show(list2);
		
		List <? extends Number>list3=null;//所有的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类Number的子类。
		List<Integer> list4=null;
		list3=list4;
		List <?  super Number>list5=null;
		list5=list1;
	}
	public void show(List <?> list){
		
	}
	/*
	 * 泛型与继承的关系
	 * 若类A是类B的子类，那么List<A>就不是List<B>的子接口
	 */
	@Test
	public void test5(){
		Object obj=null;
		String str="AA";
		obj=str;
		
		 Object [] obj1=null;
		 String [] str1=new String[] {"AA","BB","CC"};
		 obj1=str1;
		 
		  List <Object> list=new ArrayList<>();
		  List <String> list1=new ArrayList<>();
		  //list=list1;//是错误的，会报错
		  //假设list=list1满足
		  //list.add(123);
		  //String str=list1.get(0);//出现问题，所以假设不满足
	}
//自定义泛型类的使用
	@Test
	public void test4(){
		//当实例化泛型类的对象时，指明泛型的类型
		//指明以后，对应的类中所有使用泛型的位置，都变为实例化中指定的泛型的类型
		//2.如果我们自定义了泛型类，但是在实例化中没有使用，那么默认类型是Object类的
		Order <Integer>order=new Order<>();
		order.setT(4);
		order.add();
		//System.out.println(order.list);
		List <Integer> list=order.list;
		System.out.println(list);
		
		//当通过对象调泛型方法时，指明方法的类型
		Integer i=order.getE(34);
		System.out.println(i);
		Double d=order.getE(2.3);
		System.out.println(d);
		
		
		Integer [] in=new Integer[]{1,2,3,5};
		List <Integer> list2=new ArrayList<>();
		List <Integer> list3=order.formArrayToList(in, list2);
		System.out.println(list3);
	}
	@Test
	public void test3(){
		Map<String,Integer> map=new HashMap<>();
		map.put("AA", 78);
		map.put("BB", 87);
		map.put("DD",98);
		//map.put(22, 33);
		Set <Map.Entry<String,Integer>>  set =map.entrySet();
		for(Map.Entry<String,Integer>  str:set){
			//Map.Entry entry=(Map.Entry)str;
			System.out.println(str.getKey()+" "+str.getValue());
		}
	}
	//3.在集合中使用泛型
	@Test
	public void test2(){
		List <Integer>list=new ArrayList<>();
		list.add(78);
		list.add(87);
		//list.add(new String("AA"));
	Iterator <Integer>it=list.iterator();
	while(it.hasNext()){
		//int sor=it.next();
		System.out.println(it.next());
	}
}
//2.在集合中没有使用泛型的情况下
	@Test
	public void test1(){
		List list=new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		//①.没有使用泛型，任何Object及其子类的对象都可以添加进来
		list.add(new String("AA"));
		/*for(Object str:list){
			System.out.println(str);
		}*/
		for(int i=0;i<list.size();i++){
			//②.强转为int型时，可能报ClassCastException的异常
			int score=(Integer)list.get(i);
			System.out.println(score);
		}
}
}
