package ���Ͽ��;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestEmployee {
	//��������
	@Test
	public void test1(){
		Comparator com=new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1&&o2 instanceof Employee1 ){
					Employee1 q1=(Employee1)o1;
					Employee1 q2=(Employee1)o2;
					MyDate birth1=q1.getBirthday();
					MyDate birth2=q2.getBirthday();
					if(birth1.getYear()!=birth2.getYear()){
						//return birth1.getYear().compareTo(birth2.getYear());
						//����compareTo()���бȽϣ�һ������0,��Ȼ������������Ĵ�����ֵ��ͬ�����ǳ������Ϊ��������������ͬ�ģ�
						  //������һ����������ӽ���
					return birth1.getYear()-birth2.getYear();
					}
					else{
						if(birth1.getMonth()!=birth2.getMonth()){
							//return birth1.getMonth().compareTo(birth2.getMonth());
							return birth1.getMonth()-birth2.getMonth();
						}
						else{
							//return birth1.getDay().compareTo(birth2.getDay());
							return birth1.getDay()-birth2.getDay();
						}
					}
				}
				return 0;
			}
			
		};
		TreeSet set=new TreeSet(com);
		Employee1 e1=new Employee1("С��",19,new MyDate(1976,4,12));
		Employee1 e2=new Employee1("С��",15,new MyDate(1954,3,7));
		Employee1 e3=new Employee1("С��",14,new MyDate(1954,9,12));
		Employee1 e4=new Employee1("С��",11,new MyDate(1954,3,12));
		Employee1 e5=new Employee1("С��",22,new MyDate(1945,4,21));
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		/*for(Object str:set){
			System.out.println(str);
		}*/
		Iterator i=set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
@Test
public void test(){
	TreeSet set=new TreeSet();
	Employee e1=new Employee("С��",19,new MyDate(1998,1,12));
	Employee e2=new Employee("С��",15,new MyDate(1992,5,23));
	Employee e3=new Employee("С��",14,new MyDate(1989,2,12));
	Employee e4=new Employee("С��",11,new MyDate(1993,6,6));
	Employee e5=new Employee("С��",22,new MyDate(1991,3,24));
	set.add(e1);
	set.add(e2);
	set.add(e3);
	set.add(e4);
	set.add(e5);
	/*for(Object str:set){
		System.out.println(str);
	}*/
	Iterator i=set.iterator();
	while(i.hasNext()){
		System.out.println(i.next());
	}
}
}
