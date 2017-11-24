package 枚举与注解;

import java.util.ArrayList;
import java.util.List;

/*
 * 注解概述：
 * 1.从JDK5.0开始，java增加了对元数据(MetaData)的支持，也就是Annotation(注解)
 * 2.Annotatiion 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，
 * 并执行相应的处理，通过使用Annotation,程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 * 3.Annotation 可以像修饰符一样被使用，可用于修饰包，类，构造器，方法，成员变量，参数，局部变量的声明，
 * 这些信息被保存在Annotation 的“name=value”对中
 * 4.Annotation 能被用来为程序元素(类，方法，成员变量等)设置元数据
 * 
 */


/*
 * 注解：
 * 1.JDK提供的常用的注解
 *   @Override:限定重写父类方法，该注释只能用于方法
 *   @Deprecated:用于表示某个程序元素(类，方法等)已过时
 *   @SuppressWarnings:抑制编译器警告
 * 2.如何自定义一个注解
 * 3.元注解:注解已有注解的注解
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
		System.out.println("走路");
	}
	@Deprecated
	public void eat(){
		System.out.println("吃饭");
	}
}
@MyAnnotation(value="atguigu")
class Student extends Person{
	@Override 
	public void walk(){
		System.out.println("学生走路");
	}
	@Override
	public void eat(){
		System.out.println("学生吃饭");
	}
}