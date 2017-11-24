package 集合框架;

import java.util.Comparator;
 
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


import org.junit.Test;
public class TestTreeSet {
	//和下面的一样，只不过这里是用匿名类
	@Test
	public void testTreeSet2(){
      @SuppressWarnings("unchecked")
	TreeSet set=new TreeSet(new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
			if(o1 instanceof Customer&&o2 instanceof Customer){
				Customer c1=(Customer)o1;
				Customer c2=(Customer)o2;
				int i=c1.getId().compareTo(c2.getId());
				if(i==0){
					return c1.getName().compareTo(c2.getName());
					}else{
						return i;
					}
			}
			return 0;
				}
		});

	    set.add(new Customer("AA",1003));
	    set.add(new Customer("GG",1002));
	    set.add(new Customer("JJ",1008));
	    set.add(new Customer("MM",1001));
	    set.add(new Customer("DD",1005));
	    set.add(new Customer("CC",1003));
	    for(Object str:set){
	    	System.out.println(str);
	    }
	}
	/*
	 * TreeSet的定制排序:当操作的类不能改变时用定制排序
	 * 见下面的步骤：
	 * >compare()与HashCode()以及equals()三者保持一致
	 */
	@Test
	public void testTreeSet1(){
		//1.创建一个实现了Comparator接口的类对象
		Comparator com=new Comparator(){
	 //向TreeSet中添加Customer类的对象，在此compare()方法中，指明按照Customer
	//的哪个属性排序的
					
		@Override
	public int compare(Object o1, Object o2) {
	if(o1 instanceof Customer&&o2 instanceof Customer){
		Customer c1=(Customer)o1;
		Customer c2=(Customer)o2;
		int i=c1.getId().compareTo(c2.getId());;
		if(i==0){
			return c1.getName().compareTo(c2.getName());
			}else{
				return i;
			}
	}
	return 0;
		}
		};
		
	
		//2.将此对象作为形参传递给TreeSet的构造器中
		TreeSet set=new TreeSet(com);
		//3.向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象
	    set.add(new Customer("AA",1003));
	    set.add(new Customer("GG",1002));
	    set.add(new Customer("JJ",1008));
	    set.add(new Customer("MM",1001));
	    set.add(new Customer("DD",1005));
	    set.add(new Customer("CC",1003));
	    for(Object str:set){
	    	System.out.println(str);
	    }
	}
	/*
	 * TreeSet:
	 * 1.向TreeSet中添加的元素必须是同一类的。
	 * 2.可以按照添加进集合的元素的指定的顺序遍历。像String,包装类等默认按照从小到大的顺序遍历。
	 * 3.当向TreeSet中添加自定义类的对象时，有两种排序方法：1.自然排序，2.定制排序
	 * 4.自然排序：要求自定义类的实现java.lang.Comparable接口并重写其ComparableTo(Object obj),
	 * 在此方法中，指明按照自定义类的哪个属性进行排序。
	 * 
	 * 5.向TreeSet中添加元素时，首先按照compareTo()进行比较，一旦返回0,虽然仅是两个对象的此属性值相同，但是程序会认为这两个对象是相同的，
	 * 进而后一个对象不能添加进来
	 * 
	 * >compareTo()与HashCode()以及equals()保持一致
	 *   
	 */
	@Test
	public void  testTreeSet(){
		Set set=new TreeSet();
		/*set.add("AA");
		set.add("AA");
		set.add("BB");
		set.add("JJ");
		set.add(new String("GG"));
		set.add(new String("MM"));*/
		//当Person类没有实现Comparable接口时，当向TreeSet中添加Person对象时，
		//报ClassCastException错误 ,(ClassCastException是表示强制类型转换错误)
		set.add(new Person("CC",23));
		set.add(new Person("MM",21));
		set.add(new Person("GG",25));
		set.add(new Person("JJ",24));
		set.add(new Person("KK",20));
		set.add(new Person("DD",20)); 
		//增强for循环遍历
		for(Object str:set){
			System.out.println(str);
		}
		//使用迭代器遍历
		/*Iterator i=set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		//直接遍历
		//System.out.println(set);
		//System.out.println(set.size( ));
	}
}
