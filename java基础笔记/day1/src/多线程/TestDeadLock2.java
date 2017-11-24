package 多线程;

//死锁2：

class A{
	public synchronized void foo(B b){//锁：A的对象a
		System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了A实例的foo方法");
		
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用B实例的last方法");
		b.last();
	}
	public synchronized void last(){//锁：A的对象a
		System.out.println("进入了A类的last方法内部");
	}
}

class B{
	public synchronized void bar(A a){//锁：B的对象b
		System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用A实例的last方法");
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.last();
		
	}
	public synchronized void last(){
		System.out.println("进入了B类的last方法内部");
	}
}

public class TestDeadLock2 implements Runnable{
 A a=new A();
 B b=new B();
 
 public void init(){
	 Thread.currentThread().setName("主线程");
	 a.foo(b);
	 System.out.println("进入主线程之后");
 }
 public void run(){
	 Thread.currentThread().setName("副线程");
	 b.bar(a);
	 System.out.println("进入了副线程之后");
 }
 public static void main(String []args){
	 TestDeadLock2 d1=new TestDeadLock2();
	 new Thread(d1).start();
	 d1.init();
 }
}
