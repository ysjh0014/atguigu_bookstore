package ���Ͽ��;

import java.util.Enumeration;
import java.util.StringTokenizer;

//Enumeration�ӿ���Iterator�������ġ����ϰ汾��
public class TestEnumeration {
public static void main(String []args){
	Enumeration enu=new StringTokenizer("ab-c*-df-g","-");
	while(enu.hasMoreElements()){
		System.out.println(enu.nextElement());
	}
}
}
