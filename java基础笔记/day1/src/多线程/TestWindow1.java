package ���߳�;

//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ

//�˳�������̵߳İ�ȫ���⣬��ӡ��Ʊʱ���������Ʊ����Ʊ����
class Window1 implements Runnable{
	public void run(){
		int ticket=100;
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
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
	
	t2.setName("���ڶ�");
	t3.setName("������");
	t4.setName("������");
	
	t2.start();
	t3.start();
	t4.start();
	
	}
}
