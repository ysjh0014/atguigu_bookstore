package ���߳�;

/*
 * ����һ�����̣߳����1-100֮����Ȼ���������ͬ���ģ����߳�ִ��ͬ���Ĳ���
 * ����һ���̳�java.lang.Thread��
 */
//����һ���̳���Thread������
class SubThread extends Thread{
	//2.��дThread���run()������������ʵ�ִ����߳�Ҫ��ɵĹ���
	public void run(){
		for(int i=1;i<=100;i++){
		System.out.println(Thread.currentThread().getName()+":"+i);	
		}
	}
}
public class TestThread {
public static void main(String []args){
	//3.����һ������Ķ���
	
	SubThread st=new SubThread();
	SubThread st2=new SubThread();
	//4.�����̵߳�Start(),�������̣߳�������Ӧ��run()����
	//5.һ���߳�ֻ�ܹ�ִ��һ��start()
	//6.����ͨ��Threadʵ��������run()������һ���߳�
	
	st.start();
	
	st2.start();
	for(int i=1;i<=100;i++){
		System.out.println(Thread.currentThread().getName()+":"+i);	
		}
}
}
