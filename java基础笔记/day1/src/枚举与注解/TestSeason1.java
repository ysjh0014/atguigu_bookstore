package 枚举与注解;
/*
 *  枚举类：对象的个数是固定的
 *  1.如何自定义枚举类(1.5以前)
 *  2.如何使用enum关键字定义枚举类
 *    >常用的方法：values()  valueOf(String name)
 *    >如何让枚举类实现接口:可以让不同的枚举类的对象调用被重写的抽象方法，执行的效果不同。 (相当于让每个对象重写抽象方法)
 */
public class TestSeason1 {
	public static void main(String []args){
		Season1 SPRING=Season1.Spring;
		System.out.println(SPRING);
		SPRING.show();
		System.out.println(SPRING.getSeasonName());
		//1. values():能够将对象以数组形式返回
		Season1 [] seasons=Season1.values();
		for(int i=0;i<seasons.length;i++){
		System.out.println(seasons[i]);
		}
		//2.valuesOf(String name)：要求传入的形参name是枚举类对象的名字
		//否则，会报java.lang.IllegalArgumentException异常
		Season1 sea=Season1.valueOf("Spring");
		System.out.println(sea);
		
		
		//多线程
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
//枚举类
enum Season1 implements Info{
 Spring("spring","春暖花开"){
	 public void show(){
		 System.out.println("春天在哪里？");
	 }
 },
 Summer("summer","夏日炎炎"){
	 public void show(){
		 System.out.println("生如夏花");
	 }
 },
 Autumn("autumn","秋高气爽"){
	 public void show(){
		 System.out.println("秋分");
	 }
 },
 Winter("winter","白雪皑皑"){
	 public void show(){
		 System.out.println("冬天里的一把火");
	 }
 };
	//提供类的属性，声明为private final
	private final String seasonName;
	private final String seasonDesc;
	//声明为final的属性，在构造器中初始化
	private Season1(String seasonName,String seasonDesc){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	//3.通过公共的方法来调用属性
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
		System.out.println("这是一个季节");
	}*/
	}