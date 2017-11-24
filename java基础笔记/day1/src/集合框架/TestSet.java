package 集合框架;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
/*|------set接口:存储无序的，不可重复的元素,Set中常用的方法都是Collection下定义的
*                 -----:HashSet(主要的实现类 )
*                 -----:LinkedHashSet、
*                 ------:TreeSet
*                 
*                 
*                 
* Set：存储的元素是无序的，不可重复的！
* 1.无序性：无序性！=随机性，真正的无序性，指的是元素在底层存储的位置是无序的。
* 2.不可重复性：当向Set中添加进相同的元素时侯，后面的这个不能添加进去。
* 
* 
* 说明：要求添加进Set中的元素所在的类，一定要重写equals()方法和hashCode()方法。
*  进而保证Set中元素的不可重复性！
*  
*  Set中的元素是如何存储的呢？使用了哈希算法。
*  当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算此对象的哈希值，
*  此哈希值决定了此对象在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存储到这个位置，
*  若此位置已有对象存储，再通过equals()比较这两个对象是否相同，如果相同，后一个对象就不能再添加进来。
*  万一返回false呢？都存储。(不建议如此)
*  >要求：hashCode()方法要与equals()方法一致
*/
public class TestSet {
@Test
public void testSet(){
	Set set=new HashSet();
	set.add(123);
	set.add(456);
	set.add(new String("AA"));//String中的equals方法重写了，比较的是内容
	set.add(new String("AA"));
	set.add("BB");
	set.add(null);//HashSet可以把null作为元素添加进集合
	Person p1=new Person("GG",23);
	Person p2=new Person("GG",23);//Person中的equals方法没有重写，比较的是地址
	set.add(p1);
	set.add(p2);
	System.out.println(set);
	Iterator i=set.iterator();
	while(i.hasNext()){
		System.out.println(i.next());
	}
}
}
