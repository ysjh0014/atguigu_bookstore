package 集合框架;

import java.util.Enumeration;
import java.util.StringTokenizer;

//Enumeration接口是Iterator迭代器的“古老版本”
public class TestEnumeration {
public static void main(String []args){
	Enumeration enu=new StringTokenizer("ab-c*-df-g","-");
	while(enu.hasMoreElements()){
		System.out.println(enu.nextElement());
	}
}
}
