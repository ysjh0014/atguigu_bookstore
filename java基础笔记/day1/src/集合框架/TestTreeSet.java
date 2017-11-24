package ���Ͽ��;

import java.util.Comparator;
 
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


import org.junit.Test;
public class TestTreeSet {
	//�������һ����ֻ������������������
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
	 * TreeSet�Ķ�������:���������಻�ܸı�ʱ�ö�������
	 * ������Ĳ��裺
	 * >compare()��HashCode()�Լ�equals()���߱���һ��
	 */
	@Test
	public void testTreeSet1(){
		//1.����һ��ʵ����Comparator�ӿڵ������
		Comparator com=new Comparator(){
	 //��TreeSet�����Customer��Ķ����ڴ�compare()�����У�ָ������Customer
	//���ĸ����������
					
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
		
	
		//2.���˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�������
		TreeSet set=new TreeSet(com);
		//3.��TreeSet�����Comparator�ӿ��е�compare�������漰����Ķ���
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
	 * 1.��TreeSet����ӵ�Ԫ�ر�����ͬһ��ġ�
	 * 2.���԰�����ӽ����ϵ�Ԫ�ص�ָ����˳���������String,��װ���Ĭ�ϰ��մ�С�����˳�������
	 * 3.����TreeSet������Զ�����Ķ���ʱ�����������򷽷���1.��Ȼ����2.��������
	 * 4.��Ȼ����Ҫ���Զ������ʵ��java.lang.Comparable�ӿڲ���д��ComparableTo(Object obj),
	 * �ڴ˷����У�ָ�������Զ�������ĸ����Խ�������
	 * 
	 * 5.��TreeSet�����Ԫ��ʱ�����Ȱ���compareTo()���бȽϣ�һ������0,��Ȼ������������Ĵ�����ֵ��ͬ�����ǳ������Ϊ��������������ͬ�ģ�
	 * ������һ����������ӽ���
	 * 
	 * >compareTo()��HashCode()�Լ�equals()����һ��
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
		//��Person��û��ʵ��Comparable�ӿ�ʱ������TreeSet�����Person����ʱ��
		//��ClassCastException���� ,(ClassCastException�Ǳ�ʾǿ������ת������)
		set.add(new Person("CC",23));
		set.add(new Person("MM",21));
		set.add(new Person("GG",25));
		set.add(new Person("JJ",24));
		set.add(new Person("KK",20));
		set.add(new Person("DD",20)); 
		//��ǿforѭ������
		for(Object str:set){
			System.out.println(str);
		}
		//ʹ�õ���������
		/*Iterator i=set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		//ֱ�ӱ���
		//System.out.println(set);
		//System.out.println(set.size( ));
	}
}
