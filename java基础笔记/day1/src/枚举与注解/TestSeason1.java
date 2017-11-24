package ö����ע��;
/*
 *  ö���ࣺ����ĸ����ǹ̶���
 *  1.����Զ���ö����(1.5��ǰ)
 *  2.���ʹ��enum�ؼ��ֶ���ö����
 *    >���õķ�����values()  valueOf(String name)
 *    >�����ö����ʵ�ֽӿ�:�����ò�ͬ��ö����Ķ�����ñ���д�ĳ��󷽷���ִ�е�Ч����ͬ�� (�൱����ÿ��������д���󷽷�)
 */
public class TestSeason1 {
	public static void main(String []args){
		Season1 SPRING=Season1.Spring;
		System.out.println(SPRING);
		SPRING.show();
		System.out.println(SPRING.getSeasonName());
		//1. values():�ܹ���������������ʽ����
		Season1 [] seasons=Season1.values();
		for(int i=0;i<seasons.length;i++){
		System.out.println(seasons[i]);
		}
		//2.valuesOf(String name)��Ҫ������β�name��ö������������
		//���򣬻ᱨjava.lang.IllegalArgumentException�쳣
		Season1 sea=Season1.valueOf("Spring");
		System.out.println(sea);
		
		
		//���߳�
		Thread.State[] states=Thread.State.values();
		for(int i=0;i<states.length;i++){
			System.out.println(states[i]);
		}
		 
		sea.show();
	}
}

interface Info{
	void show();
}
//ö����
enum Season1 implements Info{
 Spring("spring","��ů����"){
	 public void show(){
		 System.out.println("���������");
	 }
 },
 Summer("summer","��������"){
	 public void show(){
		 System.out.println("�����Ļ�");
	 }
 },
 Autumn("autumn","�����ˬ"){
	 public void show(){
		 System.out.println("���");
	 }
 },
 Winter("winter","��ѩ����"){
	 public void show(){
		 System.out.println("�������һ�ѻ�");
	 }
 };
	//�ṩ������ԣ�����Ϊprivate final
	private final String seasonName;
	private final String seasonDesc;
	//����Ϊfinal�����ԣ��ڹ������г�ʼ��
	private Season1(String seasonName,String seasonDesc){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	//3.ͨ�������ķ�������������
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	/*public void show(){
		System.out.println("����һ������");
	}*/
	}