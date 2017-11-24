package com.tz.phonecode.sysmanage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;



public class GetTime {
	/*
	 * 
	 * 获取时间戳
	 * 
	 */
	
	  public  String getTimetamp(){
		   Date date=new Date();
		  SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
		   String format = simpleDateFormat.format(date);
		  System.err.println(format);
		   
		   return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	   }
	   @Test
	   public void test(){
		   getTimetamp();
	   }
	   
}