package ���߳�;

/*
 * �������̵߳ķ�ʽ����ͨ��ʵ�ֵķ�ʽ
 * 
 * �Ա�һ�¼̳еķ�ʽ vsʵ�ֵķ�ʽ
 *   1.��ϵ��public class Thread implements Runnable
 *   2.�ĸ���ʽ�ã�  ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ
 *      why?  �ٱ�����java�е��̳еľ�����
 *            ���������߳�Ҫ����ͬһ����Դ(������)�����ʺ�ʹ��ʵ�ֵķ�ʽ
 */

//1.����һ��ʵ����Runnable�ӿڵ���
class PrintNum1 implements Runnable{
//2.ʵ�ֽӿڵĳ��󷽷�
	public void run(){
		//���߳�ִ�еĴ���
		for(int i=1;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);	
			}
	}
}
public class TestThread3 {
public static void main(String []args){
	//3.����һ��Runnable�ӿ�ʵ����Ķ���
	PrintNum1 p=new PrintNum1();
	//Ҫ������һ�����̣߳��������start()
	//4.���˶�����Ϊ�βδ��ݸ�Thread��Ĺ�����������Thread��Ķ��󣬴˶���Ϊһ���߳�
	Thread t1=new Thread(p);
	//5.����start()�����������̲߳�ִ��run()
	t1.start();//�����̣߳�ִ��Thread��������ʱ�������βεĶ����run()����
	
	Thread t2=new Thread(p);
	t2.start();
}
}
