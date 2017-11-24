package 多线程;

/*
 * 方法二：同步方法：
 * 将操作共享数据的方法声明为synchronized,即此方法为同步方法，
 * 能够保证当其中一个线程执行此方法时，其他线程在外等待直至此线程执行完此方法
 * 
 * >同步方法的锁：this：当前对象
 */
class Window4 implements Runnable{
	int ticket=100;//共享数据
	//Object obj=new Object();
	
	public void run(){
		while(true){
		show();
		}
	}
	public  synchronized void show(){
		//synchronized(this){//this表示当前对象，本题中即为w
		if(ticket>0){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
		}
		//}
	}
}
public class TestWindow4 {
	public static void main(String []args){
		Window4 w=new Window4 ();
		Thread t2=new Thread(w);
		Thread t3=new Thread(w);
		Thread t4=new Thread(w);
		
		t2.setName("窗口二");
		t3.setName("窗口三");
		t4.setName("窗口四");
		
		t2.start();
		t3.start();
		t4.start();
		
		}
}
