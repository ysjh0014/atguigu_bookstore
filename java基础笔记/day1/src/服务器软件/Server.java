package ���������;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String [] args) throws Exception{
	  //1.����ServerSocket
	  ServerSocket server=new ServerSocket(8888);
	  
	  System.out.println("��������������...");
	  while(true){
	  //2.���տͻ��˵�����
	  Socket socket=server.accept();
	  
	  //3.��ȡ���ص�test.html�ļ�
	  FileInputStream in=new FileInputStream(new File("c:/java��ҵ��ʼ�/����/4.ý���ǩ.html"));
	  
	  //4.��������ͨ��
	  OutputStream out=socket.getOutputStream();
	  
	  //5.��������
	  byte [] buf=new byte[1024];
	  int len=0;
	  while((len=in.read(buf))!=-1){
		 out.write(buf,0,len); 
	  }
	  
	  //6.�ر���Դ
	  out.close();
	  in.close();
  }
  }
}
