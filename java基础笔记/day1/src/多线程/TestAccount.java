package ���߳�;
/*
 * ���ԣ�
 *   ������һ���˻�
 *   �����������ֱ���ͬһ���˻���3000Ԫ��ÿ�δ�1000����3�Ρ�ÿ�δ����ӡ�˻���
 *   
 *   
 *   1.�Ƿ��漰�����̣߳��ǣ���Ϊ����������(���ַ�ʽ�������߳�)
 *   2.�Ƿ��й������ݣ��У�ͬһ���˻�
 *   3.�����̵߳�ͬ����(���ַ��������̵߳İ�ȫ)
 *  
 *   
 *   ��չ��ʵ�ֶ��߽����ӡ��ʹ���̵߳�ͨ��
 */
//1.
/*class Account implements Runnable{
 	double  account;
 	public void run(){
 		for(int i=0;i<3;i++){
	show(1000);
}
}

 	public synchronized void show(double number){
	account+=number;
	try {
		Thread.currentThread().sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println(Thread.currentThread().getName()+" "+1000);
	System.out.println(Thread.currentThread().getName()+" "+account);
 	}

}*/
//2.
class Account{
	double balance;
	public Account(){
		
	}
	public synchronized void deposit(double amt) {
		balance+=amt;
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+balance);
		//System.out.println(Thread.currentThread().getName()+":"+amt);
		//System.out.println("�˻���"+balance);
	}

	}
class Customer extends Thread{
	Account account;
	 
	public Customer(Account account){
		this.account=account;
	}
	public void run(){
		for(int i=0;i<3;i++){
			account.deposit(1000);
		}
	}
}
public class TestAccount {
public static void main(String []args){
	Account acc=new Account();
	//Thread t1=new Thread(acc);
	Customer t1=new Customer(acc);
	t1.setName("����һ��������Ϊ");
	t1.start();
	//Thread t2=new Thread(acc);
	Customer t2=new Customer(acc);
	t2.setName("��������������Ϊ");
	t2.start();
	
	//Thread t3=new Thread(acc);
	//t3.setName("��������������Ϊ");
	//t3.start();
}
}
