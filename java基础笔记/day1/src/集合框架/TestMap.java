package ���Ͽ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * Collection�ӿ�
 * 
 * 
 * Map�ӿڣ�
 *        |----HashMap:Map����Ҫʵ����
 *        |-----LinkedHashMap:ʹ��������ӽ�Map�е�˳�򡣹ʱ���Mapʱ���ǰ���ӵ�˳�������
 *        |-----TreeMap:������ӽ�Map�е�Ԫ�ص�keyָ�����Խ�������,Ҫ��key������ͬһ����Ķ���
 *         ���key,��Ȼ����  vs ��������
 *        |-----Hashtable:���ϵ�ʵ���࣬�̰߳�ȫ�ģ�������ʹ��
 *         |-----Properties:Hashtable��һ�����࣬���������������ļ�������ֵ��ΪString���͵�
 */
public class TestMap {
	//ʹ��Peoperties���������ļ�
	@Test
	public void test6() throws FileNotFoundException, IOException {
		Properties pros=new Properties();
		pros.load(new FileInputStream(new File("jdbc.properties")));
		String user=pros.getProperty("user");
		System.out.println(user);
		String password=pros.getProperty("password");
		System.out.println(password);
	}
	//��������
	@Test
	public void test5(){
		Comparator com=new Comparator(){

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
			TreeMap map=new TreeMap(com);
		    map.put(new Customer("AA",1001),87);
		    map.put(new Customer("CC",1001),67);
		    map.put(new Customer("MM",1004),77);
		    map.put(new Customer("GG",1002),97);
		    map.put(new Customer("DD",1005),86);
		    map.put(new Customer("CC",1003),99);
		    
		    Set set=map.keySet();
		    for(Object str:set){
		    	System.out.println(str+" "+map.get(str));
		    }
		}
	//��Ȼ����
	@Test
	public void test4(){
		Map map=new TreeMap();
	  	map.put(new Person("AA",23),89);
	  	map.put(new Person("MM",22),79);
	  	map.put(new Person("GG",23), 99);
	  	map.put(new Person("JJ",13),69);
	  	
		Set set1=map.keySet();
		for(Object obj:set1){
			System.out.println(obj+" "+map.get(obj));
		}
	}
	@Test
	public void test3(){
		Map map=new LinkedHashMap();
		map.put("AA", 213);
		map.put("BB", 456);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null,null);
		map.put(new Person("DD",23), 89);
		Set set1=map.keySet();
		for(Object obj:set1){
			System.out.println(obj+" "+map.get(obj));
		}
	}
	/*
	 * ��α���Map: 
	 * Set keySet()
	 * Collection values()
	 * Set entrySet()
	 * 
	 */
	@Test
	public void test2(){
		Map map=new HashMap();
		map.put("AA", 213);
		map.put("BB", 456);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null,null);
		map.put(new Person("DD",23), 89);
		
		//1.����key��
		Set set=map.keySet();
		for(Object str:set){
			System.out.println(str);
		}
		/*Iterator i=set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		//2.����value��
		Collection values=map.values();
		Iterator str=values.iterator();
		while(str.hasNext()){
			System.out.println(str.next());
		}
		//3.��α���key-value��
		//��ʽһ��
		/*Set set1=map.keySet();
		for(Object obj:set1){
			System.out.println(obj+" "+ map.get(obj));
		}*/
		//��ʽ����
		Set  set2=map.entrySet();
		for(Object obj:set2){
		Map.Entry entry=(Map.Entry)obj;//��Object����ת���������Ⱥŵ�
		System.out.println(entry.getKey()+" "+entry.getValue());
		//System.out.println(obj);//���Ⱥŵ�
		}
	}
/*
 * Object put(Object key,Object value):
 * Object remove(Object key):����ָ����keyɾ����key-value
 * void putAll(Map t):��һ���µ�Map���������е�Ԫ����ӽ���
 * void clear()�����Map�����е�����Ԫ��
 * Object get(Object key)����ȡָ��key��valueֵ.���޴�key,�򷵻�null
 * boolean containsKey(Object key)
 * boolean containsValue(Object value)
 * int size():���ؼ��ϵĳ���
 * boolean isEmpty()
 * boolean equals(Object obj)
 * 
 * HashMap:
 * 1.key����Set����ŵģ������ظ���value����Collection����ŵģ����ظ�
 * һ��key-value�ԣ���һ��Entry,���е�Entry����Set��ŵģ�Ҳ�ǲ����ظ���
 * 2.��HashMap�����Ԫ��ʱ�������key�������equals()�������ж�����key�Ƿ���ͬ��
 * ����ͬ��ֻ����ӽ�����ӵ��Ǹ�Ԫ��
 */
	@Test
	public void test1(){
		Map map=new HashMap();
		map.put("AA", 213);
		map.put("BB", 456);
		map.put("BB", 45);
		map.put(123, "CC");
		map.put(null,null);//���԰�null��ΪԪ�ش洢��������
		map.put(new Person("DD",23), 89);
		map.put(new Person("DD",23), 87);
		System.out.println(map.size());
		System.out.println(map);
		map.remove("BB");
		System.out.println(map);
	Object i=map.get(213);
	System.out.println(i);
	}
}
