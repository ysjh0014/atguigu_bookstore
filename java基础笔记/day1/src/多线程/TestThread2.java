package ���߳�;
//��ϰ��
//    �����������̣߳�������һ�����1-100֮���ż������һ�����1-100֮�������
class SubThread2 extends Thread{
	public void run(){
		for(int i=1;i<100;i+=2){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
class SubThread3 extends Thread{
	public void run(){
		for(int i=2;i<=100;i+=2){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
public class TestThread2 {
	public static void main(String []args){
 SubThread2 st2=new SubThread2();
 SubThread3 st3=new SubThread3();
 st2.start();
 st3.start();
		
		
  //�̳���Thread���������Ķ���(�ڶ��ִ�������ķ���)
   /* new Thread(){
	   public void run(){
			 for(int i=1;i<100;i+=2){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
}.start();

   new Thread(){
	   public void run(){
			for(int i=2;i<=100;i+=2){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
}.start();*/
	}
}
