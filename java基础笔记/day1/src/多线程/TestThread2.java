package 多线程;
//练习：
//    创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数
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
		
		
  //继承于Thread类的匿名类的对象(第二种创建对象的方法)
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
