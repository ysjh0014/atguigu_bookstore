package 服务器软件;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String [] args) throws Exception{
	  //1.创建ServerSocket
	  ServerSocket server=new ServerSocket(8888);
	  
	  System.out.println("服务器正在启动...");
	  while(true){
	  //2.接收客户端的连接
	  Socket socket=server.accept();
	  
	  //3.读取本地的test.html文件
	  FileInputStream in=new FileInputStream(new File("c:/java就业班笔记/代码/4.媒体标签.html"));
	  
	  //4.构建数据通道
	  OutputStream out=socket.getOutputStream();
	  
	  //5.发送数据
	  byte [] buf=new byte[1024];
	  int len=0;
	  while((len=in.read(buf))!=-1){
		 out.write(buf,0,len); 
	  }
	  
	  //6.关闭资源
	  out.close();
	  in.close();
  }
  }
}
