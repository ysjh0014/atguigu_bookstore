package ���߳�;

/*
 * ��������ͬ��������
 * �������������ݵķ�������Ϊsynchronized,���˷���Ϊͬ��������
 * �ܹ���֤������һ���߳�ִ�д˷���ʱ�������߳�����ȴ�ֱ�����߳�ִ����˷���
 * 
 * >ͬ������������this����ǰ����
 */
class Window4 implements Runnable{
	int ticket=100;//��������
	//Object obj=new Object();
	
	public void run(){
		while(true){
		show();
		}
	}
	public  synchronized void show(){
		//synchronized(this){//this��ʾ��ǰ���󣬱����м�Ϊw
		if(ticket>0){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
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
		
		t2.setName("���ڶ�");
		t3.setName("������");
		t4.setName("������");
		
		t2.start();
		t3.start();
		t4.start();
		
		}
}
