package ���߳�;

//ģ���վ��Ʊ���ڣ���������������Ʊ����Ʊ��100��(�̳еķ�ʽ)

class Window extends Thread{
	static int ticket=100;
	public void run(){
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
			}
		}
	}
}
public class TestWindow {
public static void main (String []args){
	Window win1=new Window();
	Window win2=new Window();
	Window win3=new Window();
	
	win1.setName("����һ");
	win2.setName("���ڶ�");
	win3.setName("������");
	
	win1.start();
	win2.start();
	win3.start();
}
}
