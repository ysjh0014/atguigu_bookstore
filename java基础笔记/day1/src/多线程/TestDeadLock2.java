package ���߳�;

//����2��

class A{
	public synchronized void foo(B b){//����A�Ķ���a
		System.out.println("��ǰ�߳�����"+Thread.currentThread().getName()+"������Aʵ����foo����");
		
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("��ǰ�߳�����"+Thread.currentThread().getName()+"��ͼ����Bʵ����last����");
		b.last();
	}
	public synchronized void last(){//����A�Ķ���a
		System.out.println("������A���last�����ڲ�");
	}
}

class B{
	public synchronized void bar(A a){//����B�Ķ���b
		System.out.println("��ǰ�߳�����"+Thread.currentThread().getName()+"��ͼ����Aʵ����last����");
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.last();
		
	}
	public synchronized void last(){
		System.out.println("������B���last�����ڲ�");
	}
}

public class TestDeadLock2 implements Runnable{
 A a=new A();
 B b=new B();
 
 public void init(){
	 Thread.currentThread().setName("���߳�");
	 a.foo(b);
	 System.out.println("�������߳�֮��");
 }
 public void run(){
	 Thread.currentThread().setName("���߳�");
	 b.bar(a);
	 System.out.println("�����˸��߳�֮��");
 }
 public static void main(String []args){
	 TestDeadLock2 d1=new TestDeadLock2();
	 new Thread(d1).start();
	 d1.init();
 }
}
