package 集合框架;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * 集合的遍历
 */
public class TestIterator {
	//使用增强for循环实现数组的遍历
	@Test
	public void test4(){
		int [] str=new int[]{1,2,3,4,5,6,7,8};
		for(int i:str){
			System.out.println(i);
		}
	}
	//使用增强for循环实现集合的遍历
	@Test
	public void test3(){
		Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("小明");
    	coll.add("小丽");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	for(Object i:coll){
    		System.out.println(i);
    	}
	}
	//错误的用法
	@Test
	public void test2(){
		Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("小明");
    	coll.add("小丽");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	Iterator i=coll.iterator();
    	while((i.next())!=null){
    		System.out.println(i.next());//这里只能隔一个输出一个，且最后一个会出错
    	}
	}
	//正确的用法:使用迭代器Iterator实现集合的遍历
     @Test
     public void test1(){
    	Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("小明");
    	coll.add("小丽");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	Iterator i=coll.iterator();
    	while(i.hasNext()){
    		System.out.println(i.next());
    	}
     }
}
