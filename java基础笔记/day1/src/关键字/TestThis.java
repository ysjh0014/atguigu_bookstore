package 关键字;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import Class类.Student;

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
		Class c=student.getClass();//得到Class对象的方法
		System.out.println("类名:"+c.getName());//得到类名，包含包的名字
		System.out.println("包名:"+c.getPackage().getName());//只得到类所在的包
		int mod=c.getModifiers();
		if(Modifier.isPublic(mod)){//Modifier.isPublic(mod)可以判断是否为public类型
			System.out.println("类的访问控制符是public");
		}
		else{
			System.out.println("类的访问控制符是缺省的");
		}
		System.out.println("属性列表:");
		Field fields[]=c.getFields();//得到所有属性，返回只是Field数组，只包含public类型的属性
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName());//通过Field提供的方法得到属性的具体信息
		}
		System.out.println("方法列表:");
		Method methods[]=c.getMethods();//得到所有方法，类型是Method数组，只包含public类型的方法
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i].getName());
		}
	}
}
