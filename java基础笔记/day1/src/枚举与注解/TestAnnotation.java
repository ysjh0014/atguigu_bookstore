package ö����ע��;

import java.util.ArrayList;
import java.util.List;

/*
 * ע�������
 * 1.��JDK5.0��ʼ��java�����˶�Ԫ����(MetaData)��֧�֣�Ҳ����Annotation(ע��)
 * 2.Annotatiion ��ʵ���Ǵ�����������ǣ���Щ��ǿ����ڱ��룬����أ�����ʱ����ȡ��
 * ��ִ����Ӧ�Ĵ���ͨ��ʹ��Annotation,����Ա�����ڲ��ı�ԭ���߼�������£���Դ�ļ���Ƕ��һЩ������Ϣ
 * 3.Annotation ���������η�һ����ʹ�ã����������ΰ����࣬����������������Ա�������������ֲ�������������
 * ��Щ��Ϣ��������Annotation �ġ�name=value������
 * 4.Annotation �ܱ�����Ϊ����Ԫ��(�࣬��������Ա������)����Ԫ����
 * 
 */


/*
 * ע�⣺
 * 1.JDK�ṩ�ĳ��õ�ע��
 *   @Override:�޶���д���෽������ע��ֻ�����ڷ���
 *   @Deprecated:���ڱ�ʾĳ������Ԫ��(�࣬������)�ѹ�ʱ
 *   @SuppressWarnings:���Ʊ���������
 * 2.����Զ���һ��ע��
 * 3.Ԫע��:ע������ע���ע��
 */
public class TestAnnotation {
public static void main(String []args){
	Person p=new Person();
	p.walk();
	p.eat();
	
	
	 @SuppressWarnings({ "rawtypes", "unused" })
	List list=new ArrayList();
	 
	 @SuppressWarnings("unused")
	int i=0;
	// System.out.println(i);
}
}
@MyAnnotation(value="atguigu")
class Person{
	String name;
	int age;
	
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void walk(){
		System.out.println("��·");
	}
	@Deprecated
	public void eat(){
		System.out.println("�Է�");
	}
}
@MyAnnotation(value="atguigu")
class Student extends Person{
	@Override 
	public void walk(){
		System.out.println("ѧ����·");
	}
	@Override
	public void eat(){
		System.out.println("ѧ���Է�");
	}
}