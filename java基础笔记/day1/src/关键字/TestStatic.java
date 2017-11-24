package 关键字;


public class TestStatic {
	public static void main(String []args){
		test s1=new test("金龙",23);
		test s2=new test("银龙",21);//当对象创建时各个对象已各自拥有一套实例变量的副本
		//s1.nation="中国";
		System.out.println(s1);
		System.out.println(s2);
		//System.out.println(test.nation);//类变量可以通过类名直接调用
		//test.show1();
	
	}
}
	class test{
		//实例变量:(随着对象的创建而被加载的)
		String name;
		int age;
		//类变量:
		  String nation;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public test(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return "test [name=" + name + ", age=" + age + ", nation=" + nation + "]";
		}
		public  void show(){
			System.out.println("我是一个中国的运动员");
		}
		public  void show1(){
			System.out.println("nation:"+nation);
			info();//静态方法只能调用静态的方法或属性
			System.out.println("我是一个中国的运动员");
		}
		public   void info(){
			System.out.println("这是一个静态的方法！");
		}
	}
	
