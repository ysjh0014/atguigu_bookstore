package 枚举与注解;
//自定义枚举类
public class TestSeason {
public static void main(String []args){
	Season SPRING=Season.Spring;
	System.out.println(SPRING);
	SPRING.show();
	System.out.println(SPRING.getSeasonName());
}
}
//枚举类
class Season{
	//提供类的属性，声明为private final
	private final String seasonName;
	private final String seasonDesc;
	//声明为final的属性，在构造器中初始化
	private Season(String seasonName,String seasonDesc){
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
	//4.创建枚举类的对象:将类的对象声明为public final
	public static final Season Spring=new Season("spring","春暖花开");
	public static final Season Summer=new Season("summer","夏日炎炎");
	public static final Season Autumn=new Season("autumn","秋高气爽");
	public static final Season Winter=new Season("winter","白雪皑皑");
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	public void show(){
		System.out.println("这是一个季节");
	}
	}