package ���Ͽ��;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * ���ϵı���
 */
public class TestIterator {
	//ʹ����ǿforѭ��ʵ������ı���
	@Test
	public void test4(){
		int [] str=new int[]{1,2,3,4,5,6,7,8};
		for(int i:str){
			System.out.println(i);
		}
	}
	//ʹ����ǿforѭ��ʵ�ּ��ϵı���
	@Test
	public void test3(){
		Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("С��");
    	coll.add("С��");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	for(Object i:coll){
    		System.out.println(i);
    	}
	}
	//������÷�
	@Test
	public void test2(){
		Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("С��");
    	coll.add("С��");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	Iterator i=coll.iterator();
    	while((i.next())!=null){
    		System.out.println(i.next());//����ֻ�ܸ�һ�����һ���������һ�������
    	}
	}
	//��ȷ���÷�:ʹ�õ�����Iteratorʵ�ּ��ϵı���
     @Test
     public void test1(){
    	Collection coll=new ArrayList();
    	coll.add(123);
    	coll.add("С��");
    	coll.add("С��");
    	coll.add(456);
    	coll.add("AAA");
    	coll.add(new Date());
    	Iterator i=coll.iterator();
    	while(i.hasNext()){
    		System.out.println(i.next());
    	}
     }
}
