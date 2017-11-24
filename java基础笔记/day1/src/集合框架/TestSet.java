package ���Ͽ��;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
/*|------set�ӿ�:�洢����ģ������ظ���Ԫ��,Set�г��õķ�������Collection�¶����
*                 -----:HashSet(��Ҫ��ʵ���� )
*                 -----:LinkedHashSet��
*                 ------:TreeSet
*                 
*                 
*                 
* Set���洢��Ԫ��������ģ������ظ��ģ�
* 1.�����ԣ������ԣ�=����ԣ������������ԣ�ָ����Ԫ���ڵײ�洢��λ��������ġ�
* 2.�����ظ��ԣ�����Set����ӽ���ͬ��Ԫ��ʱ���������������ӽ�ȥ��
* 
* 
* ˵����Ҫ����ӽ�Set�е�Ԫ�����ڵ��࣬һ��Ҫ��дequals()������hashCode()������
*  ������֤Set��Ԫ�صĲ����ظ��ԣ�
*  
*  Set�е�Ԫ������δ洢���أ�ʹ���˹�ϣ�㷨��
*  ����Set����Ӷ���ʱ�����ȵ��ô˶����������hashCode()����������˶���Ĺ�ϣֵ��
*  �˹�ϣֵ�����˴˶�����Set�еĴ洢λ�ã�����λ��֮ǰû�ж���洢�����������ֱ�Ӵ洢�����λ�ã�
*  ����λ�����ж���洢����ͨ��equals()�Ƚ������������Ƿ���ͬ�������ͬ����һ������Ͳ�������ӽ�����
*  ��һ����false�أ����洢��(���������)
*  >Ҫ��hashCode()����Ҫ��equals()����һ��
*/
public class TestSet {
@Test
public void testSet(){
	Set set=new HashSet();
	set.add(123);
	set.add(456);
	set.add(new String("AA"));//String�е�equals������д�ˣ��Ƚϵ�������
	set.add(new String("AA"));
	set.add("BB");
	set.add(null);//HashSet���԰�null��ΪԪ����ӽ�����
	Person p1=new Person("GG",23);
	Person p2=new Person("GG",23);//Person�е�equals����û����д���Ƚϵ��ǵ�ַ
	set.add(p1);
	set.add(p2);
	System.out.println(set);
	Iterator i=set.iterator();
	while(i.hasNext()){
		System.out.println(i.next());
	}
}
}
