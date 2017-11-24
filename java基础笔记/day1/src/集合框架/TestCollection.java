package ���Ͽ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
/*
 * Collection�ӿ�:14�����󷽷�
 *      |------List�ӿ�:�洢����ģ������ظ���Ԫ��
 *                 ----:ArrayList(��Ҫ��ʵ����)���ײ�������
 *                ------:LinkedList(����Ƶ���Ĳ��롢ɾ������)���ײ�������
 *                ------:Vector(���ϵ�ʵ���࣬�̰߳�ȫ�ģ���Ч�ʸ��ͣ���������)
 *      |------set�ӿ�:�洢����ģ������ظ���Ԫ��
 *                 -----:HashSet(��Ҫ��ʵ���� )
 *                 -----:LinkedHashSet��
 *                 ------:TreeSet
 */
public class TestCollection {
	@Test//���в���
	   public void testCollection(){
		   Collection coll=new ArrayList();
		   //1.size():���ؼ�����Ԫ�صĸ���
		  System.out.println( coll.size());
		  //2.add(Object obj):�򼯺������һ��Ԫ��
		  coll.add(123);
		  coll.add("С��");
		  coll.add(new Date());//Data������ʾ��ǰʱ��
		  System.out.println(coll.size());
		  System.out.println(coll);
		  //3.addAll(Collection coll):���β�coll�е�Ԫ����ӵ���ǰ������
		  Collection coll1=new ArrayList();//����Ҳ����ֱ��д��Arrays.asList(�β�);
		  Collection coll2=Arrays.asList(7,8,9);
		  coll1.add(456);
		  coll1.add("С��");
		  coll.addAll(coll1);
		  System.out.println(coll);
		  coll.addAll(coll2);
		  System.out.println(coll);
		  //4.isEmpty():�жϼ����Ƿ�Ϊ��
		  System.out.println(coll.isEmpty());
		  //5.clear():��ռ���
		  coll.clear();
		  System.out.println(coll.size());
		}
		@Test
		public void testCollection2(){
			 //6.contains(Object obj):�жϼ������Ƿ����ָ����objԪ��,������򷵻�true,���򷵻�false
			  //�жϵ����ݣ�����Ԫ���������equals���������ж�  Ҫ��:�Զ�����Ҫ��дequals
			  Collection coll=new ArrayList();
			  coll.add(123);
			  coll.add("С��");
			  boolean b1=coll.contains(123);
			  System.out.println(b1);//����Ϊfalse����Ϊʵ����ArrayList�е�equals��������д��
			  b1=coll.contains("С��");//����Ϊfalse����Ϊʵ����ArrayList�е�equals��������д��
			  System.out.println(b1);
			  //7.containsAll(Collection coll):�жϵ�ǰ�����Ƿ���coll����Ԫ��
			  Collection coll1=new ArrayList();
			  coll1.add(123);
			  coll1.add("С��");
			  boolean b3=coll1.containsAll(coll);
			  System.out.println(b3);
			 //8.retainAll(Collection coll):��ǰ������coll�Ĺ���Ԫ�أ�Ȼ�󷵻ظ���ǰ����
			  Collection coll2=new ArrayList();
			  coll2.add(123);
			  coll2.add("С��");
			  coll2.retainAll(coll);
			 System.out.println(coll2);
			 //9.remove(Object obj):ɾ�������е�objԪ�أ���ɾ���ɹ�������true,���򷵻�false;
			 coll1.remove(123);
			 System.out.println(coll1);
			 //10.removeAll(Collection coll):�ӵ�ǰ������ɾ��������coll�е�Ԫ��
			coll1.removeAll(coll2);
			 System.out.println(coll1);
			 //11.equals(Object obj):�жϼ��������е�Ԫ���Ƿ���ȫ���
			 //System.out.println(coll);
			 Collection coll3=new ArrayList();
			 coll3.add(123);
			 coll3.add("С��");
			 System.out.println(coll3.equals(coll));
			 //12.hashCode():�����ϣֵ
			 System.out.println(coll.hashCode());
			 System.out.println();
			 //13.toArray():������ת��Ϊ����
			 Object [] obj=coll.toArray();
			 for(int i=0;i<obj.length;i++){
				 System.out.print(obj[i]+"  ");
			 }
			 System.out.println();
			 //14.iterator():����һ��Iterator�ӿ�ʵ����Ķ���,����ʵ�ּ��ϵı���
			 Iterator iterator=coll.iterator();
			 //����1������
			/* for(int i=0;i<coll.size();i++){
				 System.out.println(iterator.next()+"  ");
			 }
			 System.out.println();*/
			while(iterator.hasNext()){//hasNext():�ж���һ��Ԫ���Ƿ���ֵ,���򷵻�true,���򷵻�false
				System.out.print(iterator.next()+"  ");
			}
			 System.out.println();
			 
		}
}
