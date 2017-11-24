package com.tz.phonecode.sysmanage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;

/*
 * 
 * 类描述：发送验证码工具
 * 
 */

public class SendCode{
	  public static String ACCOUNT_SID;
	   public static String AUTH_TOKEN;
	   public static String REST_URL;
	   
	 static{
		  
		   loadConfig();
	 }
		/*
		 * 
		 * 
		 *    读取配置文件名
		 *    
		 *    
		 */
	  public static void loadConfig(){
		   InputStream in=SendCode.class.getResourceAsStream("/action.properties");
		   Properties pro=new Properties();  //注意不能导错包
		 try {
			pro.load(in);//读取配置文件
			ACCOUNT_SID=pro.getProperty("ACCOUNT_SID");
			AUTH_TOKEN=pro.getProperty("AUTH_TOKEN");
			REST_URL=pro.getProperty("REST_URL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}   
	   }
	  
	  
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
		   public void test1(){
			   String md5=MD5("你好");
			   System.out.println(md5);
		   }
	   
	
	 
	
}