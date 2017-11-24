package ����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * ���͵�ʹ�ã�
 * 1.ΪʲôҪ�з��ͣ��ٽ��Ԫ�ش洢�İ�ȫ������
 *               �ڽ����ȡ����Ԫ��ʱ����Ҫ����ǿת������
 * 2.�ڼ�����ʹ�÷���
 * 3.�Զ��巺���ࡢ���ͽӿڡ����ͷ���
 * 4.������̳еĹ�ϵ
 * 5.ͨ���
 * 
 * ע�⣺
 * ���͵ĺ���˼�룺��һ�������е���������Ϊһ���ض�����������
 * ע������پ�̬�����в���ʹ����ķ���
 *        �������������һ���ӿڻ�����࣬�򲻿ɴ���������Ķ���
 *        �۲�����catch��ʹ�÷���
 *        �ܴӷ������������࣬������������廯
 */
public class TestGeneric {
	/*
	 * ͨ�����ʹ��
	 */
	@Test
	public void test7(){
		List  list=new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add(123);
		list.add(new Person(123,"AA"));
		List <?>list1=list;
	//���Զ�ȡ����Ϊͨ����ļ�����Ķ���	
	Iterator <?>iterator=list1.iterator();
	while(iterator.hasNext()){
		System.out.println(iterator.next());//��ȡʱ����������Object���͵�
	}
	//������������Ϊͨ����ļ�������д�����,Ψһ�������null
	//list1.add("CC");
	//list1.add(123);
	list1.add(null);
	}
	/*
	 * ͨ�����
	 * List<A>��List<B>��.....����List<?>������
	 * 
	 * ? extends A:���Դ��A��������
	 * ? super A:������A��������
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
		
		List <? extends Number>list3=null;//���еİ�װ�ࣨInteger��Long��Byte��Double��Float��Short�����ǳ�����Number�����ࡣ
		List<Integer> list4=null;
		list3=list4;
		List <?  super Number>list5=null;
		list5=list1;
	}
	public void show(List <?> list){
		
	}
	/*
	 * ������̳еĹ�ϵ
	 * ����A����B�����࣬��ôList<A>�Ͳ���List<B>���ӽӿ�
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
		  //list=list1;//�Ǵ���ģ��ᱨ��
		  //����list=list1����
		  //list.add(123);
		  //String str=list1.get(0);//�������⣬���Լ��費����
	}
//�Զ��巺�����ʹ��
	@Test
	public void test4(){
		//��ʵ����������Ķ���ʱ��ָ�����͵�����
		//ָ���Ժ󣬶�Ӧ����������ʹ�÷��͵�λ�ã�����Ϊʵ������ָ���ķ��͵�����
		//2.��������Զ����˷����࣬������ʵ������û��ʹ�ã���ôĬ��������Object���
		Order <Integer>order=new Order<>();
		order.setT(4);
		order.add();
		//System.out.println(order.list);
		List <Integer> list=order.list;
		System.out.println(list);
		
		//��ͨ����������ͷ���ʱ��ָ������������
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
	//3.�ڼ�����ʹ�÷���
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
//2.�ڼ�����û��ʹ�÷��͵������
	@Test
	public void test1(){
		List list=new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		//��.û��ʹ�÷��ͣ��κ�Object��������Ķ��󶼿�����ӽ���
		list.add(new String("AA"));
		/*for(Object str:list){
			System.out.println(str);
		}*/
		for(int i=0;i<list.size();i++){
			//��.ǿתΪint��ʱ�����ܱ�ClassCastException���쳣
			int score=(Integer)list.get(i);
			System.out.println(score);
		}
}
}
