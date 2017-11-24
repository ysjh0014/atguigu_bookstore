package ���Ͽ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/*
 * ����Collections�Լ�Map�Ĺ����ࣺCollections
 * 
 * �����⣺����Collection��Collections
 * 
 */
public class TestCollections {
	/*
	 * Object max(Collection):����Ԫ�ص���Ȼ���򣬷��ظ��������е����Ԫ��
	 * Object max(Collection,Comparator):����Comparatorָ����˳�򣬷��ظ��������е����Ԫ��
	 * Object min(Collection)
	 * Object min(Collection,Comparator)
	 * int frequency(Collection,Object):����ָ��������ָ��Ԫ�صĳ��ִ���
	 * void copy(List dest,List src):��src�е����ݸ��Ƶ�dest��
	 * boolean replaceAll(List list,Object oldVal,Object newVal)��ʹ����ֵ�滻List��������о�ֵ
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
		//ʵ��List�ĸ���
		//List list1=new ArrayList();//�����д�����ᱨ��list1�ĳ���Ϊ0��list�ĳ���Ϊ5�����Բ��ܸ��ƽ�ȥ
		/*List list1=Arrays.asList(new Object[list.size()]);//��ȷ��д��
		Collections.copy(list1, list);
		System.out.println(list1);
		System.out.println(list);*/
		//ͨ�����µķ�����֤list���̰߳�ȫ
		List list2=Collections.synchronizedList(list);//�漰�����߳̿��ܻ᲻��ȫ
		System.out.println(list2);
	}
/*
 * reverse(List):��תList��Ԫ�ص�˳��
 * shuffle(List):��List����Ԫ�ؽ����������
 * sort(List):����Ԫ�ص���Ȼ˳���ָ����List����Ԫ�ذ���������
 * sort(List,Comparator):����ָ����Comparator������˳���List����Ԫ�ؽ�������
 * swap(List,int,int):��ָ��List�����е�i��Ԫ�غ�j��Ԫ�ؽ��н���
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
