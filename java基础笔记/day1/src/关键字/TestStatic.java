package �ؼ���;


public class TestStatic {
	public static void main(String []args){
		test s1=new test("����",23);
		test s2=new test("����",21);//�����󴴽�ʱ���������Ѹ���ӵ��һ��ʵ�������ĸ���
		//s1.nation="�й�";
		System.out.println(s1);
		System.out.println(s2);
		//System.out.println(test.nation);//���������ͨ������ֱ�ӵ���
		//test.show1();
	
	}
}
	class test{
		//ʵ������:(���Ŷ���Ĵ����������ص�)
		String name;
		int age;
		//�����:
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
			System.out.println("����һ���й����˶�Ա");
		}
		public  void show1(){
			System.out.println("nation:"+nation);
			info();//��̬����ֻ�ܵ��þ�̬�ķ���������
			System.out.println("����һ���й����˶�Ա");
		}
		public   void info(){
			System.out.println("����һ����̬�ķ�����");
		}
	}
	
