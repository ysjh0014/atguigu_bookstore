package 集合框架;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
//ArrayList:List的主要实现类
/*
* List中相对于Collection新增加的方法:
* void add(int index,Object ele):在制定的索引位置index添加元素ele
* boolean addAll(int index,Collection eles):将另一个List中的元素传入到当前List中
* Object get(int index):获取指定索引的元素
* int indexOf(Object obj):返回obj在集合中首次出现的位置，没有的话，返回-1
* int lastIndexOf(Object obj):返回obj在集合中最后一次出现的位置，没有的话，返回-1
* Object remove(int index):删除指定索引位置的元素
* Object set(int index,Object ele):设置指定索引位置的元素为ele//相当于修改指定位置的元素
* List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex结束的(左闭右开)一个子list
* 
* List常用的方法:增(add(index))、删(remove(index))、
*             改(set(index,ele))、查(get(index))、
*             插(add(index,ele))、长度(size())、
*/
public class TestList {
	@Test
	public void test(){
		List list=new LinkedList();
		list.add(123);
		list.add("小明");
		list.add("小丽");
		list.add(456);
		list.add("AAA");
		list.add(new Date());
		System.out.println(list);
	}
	@Test
	public void testList1(){
	  List list=new ArrayList();
		list.add(123);
		list.add("小明");
		list.add("小丽");
		list.add(456);
		list.add("AAA");
		list.add(new Date());
		System.out.println(list);
		list.add(1,"小花");
		System.out.println(list);
		System.out.println(list.get(2));
		list.remove(0);
		System.out.println(list);
		list.set(0, "皮皮");
		System.out.println(list);
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		System.out.println(list.subList(1,4));
	}
}
