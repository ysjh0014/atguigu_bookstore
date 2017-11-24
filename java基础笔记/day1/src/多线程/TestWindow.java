package 多线程;

//模拟火车站售票窗口，开启三个窗口售票，总票数100张(继承的方式)

class Window extends Thread{
	static int ticket=100;
	public void run(){
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
			}
		}
	}
}
public class TestWindow {
public static void main (String []args){
	Window win1=new Window();
	Window win2=new Window();
	Window win3=new Window();
	
	win1.setName("窗口一");
	win2.setName("窗口二");
	win3.setName("窗口三");
	
	win1.start();
	win2.start();
	win3.start();
}
}
