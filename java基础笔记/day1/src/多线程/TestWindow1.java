package 多线程;

//使用实现Runnable接口的方式，售票

//此程序存在线程的安全问题，打印车票时，会出现重票，错票问题
class Window1 implements Runnable{
	public void run(){
		int ticket=100;
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
			}else{
				break;
			}
		}
	}
}
public class TestWindow1 {
public static void main(String []args){
	Window1 w=new Window1 ();
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
