package �ؼ���;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import Class��.Student;

public class TestThis {
	private String sid;
	public String sname;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public static void main(String []args){
		Student student=new Student();
		Class c=student.getClass();//�õ�Class����ķ���
		System.out.println("����:"+c.getName());//�õ�������������������
		System.out.println("����:"+c.getPackage().getName());//ֻ�õ������ڵİ�
		int mod=c.getModifiers();
		if(Modifier.isPublic(mod)){//Modifier.isPublic(mod)�����ж��Ƿ�Ϊpublic����
			System.out.println("��ķ��ʿ��Ʒ���public");
		}
		else{
			System.out.println("��ķ��ʿ��Ʒ���ȱʡ��");
		}
		System.out.println("�����б�:");
		Field fields[]=c.getFields();//�õ��������ԣ�����ֻ��Field���飬ֻ����public���͵�����
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName());//ͨ��Field�ṩ�ķ����õ����Եľ�����Ϣ
		}
		System.out.println("�����б�:");
		Method methods[]=c.getMethods();//�õ����з�����������Method���飬ֻ����public���͵ķ���
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i].getName());
		}
	}
}
