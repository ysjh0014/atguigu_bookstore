package ���Ͽ��;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
//ArrayList:List����Ҫʵ����
/*
* List�������Collection�����ӵķ���:
* void add(int index,Object ele):���ƶ�������λ��index���Ԫ��ele
* boolean addAll(int index,Collection eles):����һ��List�е�Ԫ�ش��뵽��ǰList��
* Object get(int index):��ȡָ��������Ԫ��
* int indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ�ã�û�еĻ�������-1
* int lastIndexOf(Object obj):����obj�ڼ��������һ�γ��ֵ�λ�ã�û�еĻ�������-1
* Object remove(int index):ɾ��ָ������λ�õ�Ԫ��
* Object set(int index,Object ele):����ָ������λ�õ�Ԫ��Ϊele//�൱���޸�ָ��λ�õ�Ԫ��
* List subList(int fromIndex,int toIndex):���ش�fromIndex��toIndex������(����ҿ�)һ����list
* 
* List���õķ���:��(add(index))��ɾ(remove(index))��
*             ��(set(index,ele))����(get(index))��
*             ��(add(index,ele))������(size())��
*/
public class TestList {
	@Test
	public void test(){
		List list=new LinkedList();
		list.add(123);
		list.add("С��");
		list.add("С��");
		list.add(456);
		list.add("AAA");
		list.add(new Date());
		System.out.println(list);
	}
	@Test
	public void testList1(){
	  List list=new ArrayList();
		list.add(123);
		list.add("С��");
		list.add("С��");
		list.add(456);
		list.add("AAA");
		list.add(new Date());
		System.out.println(list);
		list.add(1,"С��");
		System.out.println(list);
		System.out.println(list.get(2));
		list.remove(0);
		System.out.println(list);
		list.set(0, "ƤƤ");
		System.out.println(list);
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		System.out.println(list.subList(1,4));
	}
}
