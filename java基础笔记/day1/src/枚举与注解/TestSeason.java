package ö����ע��;
//�Զ���ö����
public class TestSeason {
public static void main(String []args){
	Season SPRING=Season.Spring;
	System.out.println(SPRING);
	SPRING.show();
	System.out.println(SPRING.getSeasonName());
}
}
//ö����
class Season{
	//�ṩ������ԣ�����Ϊprivate final
	private final String seasonName;
	private final String seasonDesc;
	//����Ϊfinal�����ԣ��ڹ������г�ʼ��
	private Season(String seasonName,String seasonDesc){
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
	//4.����ö����Ķ���:����Ķ�������Ϊpublic final
	public static final Season Spring=new Season("spring","��ů����");
	public static final Season Summer=new Season("summer","��������");
	public static final Season Autumn=new Season("autumn","�����ˬ");
	public static final Season Winter=new Season("winter","��ѩ����");
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	public void show(){
		System.out.println("����һ������");
	}
	}