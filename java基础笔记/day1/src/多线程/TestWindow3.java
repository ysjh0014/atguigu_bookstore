package ���߳�;

class Window3 extends Thread {
	static int ticket=100;
	static Object obj=new Object();
	public void run(){
		while(true){
		//synchronized(this){//�ڱ������У�this��ʾ��w1,w2,w3;
		synchronized(obj){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
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
			System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
		}
	}
	}*/

public class TestWindow3{
	public static void main(String []args){
		Window3 win1=new Window3();
		Window3 win2=new Window3();
		Window3 win3=new Window3();
		
		win1.setName("����һ");
		win2.setName("���ڶ�");
		win3.setName("������");
		
		win1.start();
		win2.start();
		win3.start();
	}
	}	
