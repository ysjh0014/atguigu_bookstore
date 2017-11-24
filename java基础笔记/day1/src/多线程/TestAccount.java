package 多线程;
/*
 * 测试：
 *   银行有一个账户
 *   有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *   
 *   
 *   1.是否涉及到多线程？是，因为有两个储户(两种方式创建多线程)
 *   2.是否有共享数据？有！同一个账户
 *   3.考虑线程的同步。(两种方法处理线程的安全)
 *  
 *   
 *   拓展：实现二者交替打印，使用线程的通信
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
		//System.out.println("账户余额："+balance);
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
	t1.setName("储户一存入后余额为");
	t1.start();
	//Thread t2=new Thread(acc);
	Customer t2=new Customer(acc);
	t2.setName("储户二存入后余额为");
	t2.start();
	
	//Thread t3=new Thread(acc);
	//t3.setName("储户三存入后余额为");
	//t3.start();
}
}
