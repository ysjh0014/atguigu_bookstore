package com.tz.phonecode.sysmanage.utils;

import java.util.Random;

import org.junit.Test;



/*
 * 
 * 获取随机数
 * 
 */
public class RandUtils {
	public static String getRandom(){
     String ran=new Random().nextInt(1000000)+" ";
     if(ran.length()!=7){
    	return getRandom(); //利用递归方式判断是否为6位数的验证码
     }
     return ran;
}

	
	@Test
	public void randTest(){
		for(int i=0;i<10;i++){
		System.err.println(getRandom());
		}
	}
	

}
