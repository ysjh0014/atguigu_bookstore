package ���߳�;

//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ

/*
 * �˳�������̵߳İ�ȫ���⣬��ӡ��Ʊʱ���������Ʊ����Ʊ����
 *  1.�̰߳�ȫ������ڵ�ԭ�� 
 *       ����һ���߳��ڲ����������ݹ����У�δִ����ϵ�����£�������̲߳�����������¹������ݴ����˰�ȫ����
 *       
 *  2.���������̵߳İ�ȫ���⣺
 *        ������һ���̲߳���������������Ժ������̲߳��л�����빲�����ݵĲ���
 *  
 *  3.java���ʵ���̵߳İ�ȫ���̵߳�ͬ������
 *  
 *        ��ʽһ��ͬ�������
 *        synchronized(ͬ��������){
 *        //��Ҫ��ͬ���Ĵ����(��Ϊ�����������ݵĴ���)
 *        }
 *        1.�������ݣ�����̹߳�ͬ������ͬһ������(����)
 *        2.ͬ�������������κ�һ����Ķ������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ�д������ﱻͬ���Ĵ��룬�׳ƣ���
 *        Ҫ�����е��̱߳��빲��ͬһ����
 *        ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ�������ʹ��this���䵱���������ڼ̳еķ�ʽ�У�����this
 *        
 *        ��ʽ����ͬ��������
 *     �������������ݵķ�������Ϊsynchronized,���˷���Ϊͬ��������
 *    �ܹ���֤������һ���߳�ִ�д˷���ʱ�������߳�����ȴ�ֱ�����߳�ִ����˷���
 *    
 *    
 * 4.�̵߳�ͬ���ı׶ˣ�����ͬһ��ʱ��ֻ����һ���̷߳��ʹ������ݣ�Ч�ʱ����
 */
//����һ��
class Window2 implements Runnable{
	int ticket=100;//��������
	Object obj=new Object();
	
	public void run(){
		while(true){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this){//this��ʾ��ǰ���󣬱����м�Ϊw
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ��"+ticket--);
			}
			}
		}
	}
}
public class TestWindow2 {
public static void main(String []args){
	Window2 w=new Window2 ();
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