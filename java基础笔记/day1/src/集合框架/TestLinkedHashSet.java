package ���Ͽ��;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
/*
 * LinkedHashSet:ʹ������ά����һ����ӽ������е�˳�򣬵��µ����Ǳ���LinkedHashSet����Ԫ��ʱ��
 * �ǰ�����ӽ�ȥ��˳������ģ�
 * 
 * �ص㣺linkedHashSet���������Ե���HashSet�����ڵ���������Set���ȫ��Ԫ��ʱ�кܺõ�����.
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
