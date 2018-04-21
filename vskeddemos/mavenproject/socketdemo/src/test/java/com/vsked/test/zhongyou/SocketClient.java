package com.vsked.test.zhongyou;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 中邮世纪原版本demo
 * @author brucevsked
 *
 */
public class SocketClient
{
  private String host = "localhost";
  private int port = 0;
  private int timeOut = 0;

  private Socket socket = null;
  private InputStream in = null;
  private DataOutputStream dos = null;


  public SocketClient(String host, int port, int timeOut)
  {
    this.host = host;
    this.port = port;
    this.timeOut = timeOut;
  }

  public String sendJson(String json) throws Exception {
    byte[] bytes;
    try {
      open();
      byte[] reqData = json.getBytes("utf-8");
      int length = reqData.length;
      byte[] reqLen = intToByteArray(length, 4, 0);
      byte[] inPack = new byte[length + 4];
      System.arraycopy(reqLen, 0, inPack, 0, 4);
      System.arraycopy(reqData, 0, inPack, 4, length);
      send(inPack);
      bytes = receive();
    }
    finally
    {
      close();
    }
    
    return new String(bytes, "utf-8");
  }

  private void open()
    throws IOException
  {
    this.socket = new Socket(this.host, this.port);
    if (this.socket != null) {
      this.socket.setSoTimeout(this.timeOut);
      this.in = this.socket.getInputStream();
      this.dos = new DataOutputStream(this.socket.getOutputStream());
    }
  }

  private void close()
    throws IOException
  {
    if (this.socket != null) {
      this.in.close();
      this.dos.close();
      this.socket.close();
    }
  }

  private void send(byte[] data)
    throws IOException
  {
    if ((data == null) || (data.length == 0)) {
      throw new IOException("指定的数据为空！");
    }
    this.dos.write(data);
    this.dos.flush();
  }

  private byte[] receive()
    throws Exception
  {
    byte[] headBuffer = new byte[4];
    int offset = 0;
    while (offset < 4) {
      int size = this.in.read(headBuffer, offset, 4 - offset);
      if (size == -1) {
        throw new IOException("[socket_client]读数据失败，read返回-1");
      }
      offset += size;
    }

    int length = byteArrayToInt(headBuffer, offset, 0);
    offset = 0;
    byte[] data = new byte[length];
    while (offset < length) {
      int size = this.in.read(data, offset, length - offset);
      if (size > 0) {
        offset += size;
      }
    }
    return data;
  }

  private static int byteArrayToInt(byte[] data, int length, int alignment)
    throws Exception
  {
    int value = 0;

    switch (alignment) {
    case 0:
      for (int i = 0; i < length; i++) {
        value <<= 8;
        value += toInt(data[i]);
      }
      break;
    case 1:
      for (int i = 0; i < length; i++) {
        value <<= 8;
        value += toInt(data[(length - i - 1)]);
      }
      break;
    default:
      throw new Exception("数据对齐方式非法！");
    }

    return value;
  }

  private static int toInt(byte b) {
    if (b >= 0) {
      return b;
    }
    return b + 256;
  }

  private byte[] intToByteArray(int value, int length, int alignment)
    throws Exception
  {
    byte[] data = new byte[length];

    switch (alignment) {
    case 0:
      for (int i = 0; i < length; i++) {
        data[(length - i - 1)] = (byte)(value & 0xFF);
        value >>>= 8;
      }
      break;
    case 1:
      for (int i = 0; i < length; i++) {
        data[i] = (byte)(value & 0xFF);
        value >>>= 8;
      }
      break;
    default:
      throw new Exception("数据对齐方式非法！");
    }

    return data;
  }

  public static void main(String[] args) throws Exception {
	 
	 //args[0] : ip
	 String tmp_ip = "127.0.0.1";
	 //args[1] : port
	 int tmp_port = 43001;
	 //args[2] : timeout
	 int tmp_timeout = 9000;
	 //args[3] : send_file
	 String tmp_send_file = "d:/send.txt";
	 //args[4] : recv_file_name
	 String tmp_recv_file_name = "d:/rec.txt";
	 
	 //获取文件内容
	 BufferedReader br = new BufferedReader(new FileReader(tmp_send_file));
	 StringBuilder sb = new StringBuilder();
	 String line = null;
     while ((line = br.readLine()) != null)
       sb.append(line); 
    
    System.out.println(String.format("send content : %s\n", sb.toString()));     
    SocketClient socket = new SocketClient(tmp_ip, tmp_port, tmp_timeout);
    String retMsg = socket.sendJson(sb.toString());
    System.out.println(String.format("retrun content : %s\n", retMsg));
    
    BufferedWriter bw = new BufferedWriter(new FileWriter(tmp_recv_file_name));
    
    //写入结果文件
    bw.write(String.format("%s : %s\n", tmp_send_file, retMsg));
    
    br.close();
    bw.close();
  }
  
}
