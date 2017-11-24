package 集合框架;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/*
 * 操作Collections以及Map的工具类：Collections
 * 
 * 面试题：区分Collection与Collections
 * 
 */
public class TestCollections {
	/*
	 * Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素
	 * Object max(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
	 * Object min(Collection)
	 * Object min(Collection,Comparator)
	 * int frequency(Collection,Object):返回指定集合中指定元素的出现次数
	 * void copy(List dest,List src):将src中的内容复制到dest中
	 * boolean replaceAll(List list,Object oldVal,Object newVal)：使用新值替换List对象的所有旧值
	 */
	@Test
	public void test1(){
		List list=new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		list.add(456);
		Object obj=Collections.max(list);
		System.out.println(obj);
		int count=Collections.frequency(list, 456);
		System.out.println(count);
		//实现List的复制
		//List list1=new ArrayList();//错误的写法，会报错，list1的长度为0，list的长度为5，所以不能复制进去
		/*List list1=Arrays.asList(new Object[list.size()]);//正确的写法
		Collections.copy(list1, list);
		System.out.println(list1);
		System.out.println(list);*/
		//通过如下的方法保证list的线程安全
		List list2=Collections.synchronizedList(list);//涉及到多线程可能会不安全
		System.out.println(list2);
	}
/*
 * reverse(List):反转List中元素的顺序
 * shuffle(List):对List集合元素进行随机排序
 * sort(List):根据元素的自然顺序对指定的List集合元素按升序排序
 * sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
 * swap(List,int,int):将指定List集合中的i处元素和j处元素进行交换
 */
	@Test
	public void test(){
		List list=new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	Collections.swap(list, 0, 2);
		System.out.println(list);
	}
}
