package 集合框架;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
/*
 * Collection接口:14个抽象方法
 *      |------List接口:存储有序的，可以重复的元素
 *                 ----:ArrayList(主要的实现类)、底层是数组
 *                ------:LinkedList(对于频繁的插入、删除操作)、底层是链表
 *                ------:Vector(古老的实现类，线程安全的，但效率更低，基本不用)
 *      |------set接口:存储无序的，不可重复的元素
 *                 -----:HashSet(主要的实现类 )
 *                 -----:LinkedHashSet、
 *                 ------:TreeSet
 */
public class TestCollection {
	@Test//进行测试
	   public void testCollection(){
		   Collection coll=new ArrayList();
		   //1.size():返回集合中元素的个数
		  System.out.println( coll.size());
		  //2.add(Object obj):向集合中添加一个元素
		  coll.add(123);
		  coll.add("小明");
		  coll.add(new Date());//Data类中显示当前时间
		  System.out.println(coll.size());
		  System.out.println(coll);
		  //3.addAll(Collection coll):将形参coll中的元素添加到当前集合中
		  Collection coll1=new ArrayList();//这里也可以直接写成Arrays.asList(形参);
		  Collection coll2=Arrays.asList(7,8,9);
		  coll1.add(456);
		  coll1.add("小李");
		  coll.addAll(coll1);
		  System.out.println(coll);
		  coll.addAll(coll2);
		  System.out.println(coll);
		  //4.isEmpty():判断集合是否为空
		  System.out.println(coll.isEmpty());
		  //5.clear():清空集合
		  coll.clear();
		  System.out.println(coll.size());
		}
		@Test
		public void testCollection2(){
			 //6.contains(Object obj):判断集合中是否包含指定的obj元素,如果是则返回true,否则返回false
			  //判断的依据：根据元素所在类的equals方法进行判断  要求:自定义类要重写equals
			  Collection coll=new ArrayList();
			  coll.add(123);
			  coll.add("小明");
			  boolean b1=coll.contains(123);
			  System.out.println(b1);//这里为false是因为实现类ArrayList中的equals方法被重写了
			  b1=coll.contains("小明");//这里为false是因为实现类ArrayList中的equals方法被重写了
			  System.out.println(b1);
			  //7.containsAll(Collection coll):判断当前集合是否含有coll所有元素
			  Collection coll1=new ArrayList();
			  coll1.add(123);
			  coll1.add("小明");
			  boolean b3=coll1.containsAll(coll);
			  System.out.println(b3);
			 //8.retainAll(Collection coll):求当前集合与coll的共有元素，然后返回给当前集合
			  Collection coll2=new ArrayList();
			  coll2.add(123);
			  coll2.add("小丽");
			  coll2.retainAll(coll);
			 System.out.println(coll2);
			 //9.remove(Object obj):删除集合中的obj元素，若删除成功，返回true,否则返回false;
			 coll1.remove(123);
			 System.out.println(coll1);
			 //10.removeAll(Collection coll):从当前集合中删除包含在coll中的元素
			coll1.removeAll(coll2);
			 System.out.println(coll1);
			 //11.equals(Object obj):判断集合中所有的元素是否完全相等
			 //System.out.println(coll);
			 Collection coll3=new ArrayList();
			 coll3.add(123);
			 coll3.add("小明");
			 System.out.println(coll3.equals(coll));
			 //12.hashCode():计算哈希值
			 System.out.println(coll.hashCode());
			 System.out.println();
			 //13.toArray():将集合转化为数组
			 Object [] obj=coll.toArray();
			 for(int i=0;i<obj.length;i++){
				 System.out.print(obj[i]+"  ");
			 }
			 System.out.println();
			 //14.iterator():返回一个Iterator接口实现类的对象,进而实现集合的遍历
			 Iterator iterator=coll.iterator();
			 //方法1：不用
			/* for(int i=0;i<coll.size();i++){
				 System.out.println(iterator.next()+"  ");
			 }
			 System.out.println();*/
			while(iterator.hasNext()){//hasNext():判断下一个元素是否有值,有则返回true,否则返回false
				System.out.print(iterator.next()+"  ");
			}
			 System.out.println();
			 
		}
}
