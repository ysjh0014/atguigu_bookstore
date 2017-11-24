package 多线程;

class Window3 extends Thread {
	static int ticket=100;
	static Object obj=new Object();
	public void run(){
		while(true){
		//synchronized(this){//在本问题中，this表示：w1,w2,w3;
		synchronized(obj){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
			}
		}
			//show();
	 }
	}
	
}
	/*public synchronized void show(){
		if(ticket>0){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
		}
	}
	}*/

public class TestWindow3{
	public static void main(String []args){
		Window3 win1=new Window3();
		Window3 win2=new Window3();
		Window3 win3=new Window3();
		
		win1.setName("窗口一");
		win2.setName("窗口二");
		win3.setName("窗口三");
		
		win1.start();
		win2.start();
		win3.start();
	}
	}	
