package com.tz.phonecode.sysmanage.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Md5 {
	 /*
	  * 
	  *   md5加密
	  *   
	  */
	 public static String MD5(String...args){
		 
		 StringBuilder sb=new StringBuilder();
		 StringBuilder result=new StringBuilder();
		 if(args==null||args.length==0){
			 return "";
		 }else{
			 for(String string:args){
				 sb.append(string);
			 }
			 try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
			    byte[] bytes = digest.digest(sb.toString().getBytes());
			    //
			    for(byte b:bytes){
			    	String hex=Integer.toHexString(b&0xff);//转换成16进制值
			    	if(hex.length()==1){
			    		result.append("0"+hex);
			    	}else{
			    		result.append(hex);
			    	}
			    	
			    }
			 
			 } catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 return result.toString();
	 }
	   @Test
	   public void test(){
		   String md5=MD5("你好");
		   System.out.println(md5);
	   }
}
