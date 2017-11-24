package 集合框架;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
/*
 * LinkedHashSet:使用链表维护了一个添加进集合中的顺序，导致当我们遍历LinkedHashSet集合元素时，
 * 是按照添加进去的顺序遍历的！
 * 
 * 特点：linkedHashSet插入性能略低于HashSet，但在迭代器访问Set里的全部元素时有很好的性能.
 */
public class TestLinkedHashSet {	
@Test
public void testLinkedHashSet(){
	Set set=new LinkedHashSet();
	set.add(123);
	set.add(456);
	set.add(new String("AA"));
	set.add(new String("AA"));
	set.add("BB");
	set.add(null);
	Iterator i=set.iterator();
	while(i.hasNext()){
		System.out.println(i.next());
	}
}
}
