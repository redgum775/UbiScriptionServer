package src.ubiscription;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import src.json.Command;

import java.net.ServerSocket; //ServerSocket Class are defined

public class Server {
  Command cmd = new Command();
  public Server(){
    ServerSocket serverSoc = null;
    try {
      // ポート番号は、5000
      //ソケットを作成
      serverSoc = new ServerSocket(5000);
      boolean flag = true;

      //クライアントからの接続を待機するaccept()メソッド。
      //accept()は、接続があるまで処理はブロックされる。
      //もし、複数のクライアントからの接続を受け付けるようにするには
      //スレッドを使う。
      //accept()は接続時に新たなsocketを返す。これを使って通信を行なう。
      System.out.println("Waiting for Connection. ");
      while(flag){
        Socket socket=null;
        socket = serverSoc.accept();
        //accept()は、クライアントからの接続要求があるまでブロックする。
        //接続があれば次の命令に移る。
        //スレッドを起動し、クライアントと通信する。
        new SrvThread(socket).start();
        System.out.println("Waiting for New Connection. ");
      }
    }
    catch (IOException e) {
      System.out.println("IOException!");
      e.printStackTrace();
    }
    finally{
      try{
        if (serverSoc != null){
          serverSoc.close();
        }
      }
      catch (IOException ioex) {
        ioex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new Server();
  }

  class SrvThread extends Thread{
    private Socket soc;
    private String line;
    public SrvThread(Socket sct){
      soc=sct;
      System.out.println("Thread is Generated.  Connect to " + soc.getInetAddress());
    }

    public void run(){
      int idx=0;
        try{
          //socketからのデータはInputStreamReaderに送り、さらに
          //BufferedReaderによってバッファリングする。
          BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
          //Clientへの出力用PrintWriter
          PrintWriter sendout = new PrintWriter(soc.getOutputStream(), true);
          while(true){
            if((line = reader.readLine()) != null){
            	//データ読み取りと表示。
            	System.out.println("[" + idx + "]" + line);
              // json 形式だったら解析
              if(cmd.isJson(line)){
                cmd.readCommand(line);
              }
            	//Clientにメッセージ送信
            	sendout.println("Message is received.");
            }else{
            	System.out.println("[" + idx + "] no message");
            }
            idx++;
          }
        }
        catch(IOException ioex){
          ioex.printStackTrace();
        }
      finally{
        try{
          if(soc != null){
            soc.close();
          }
        }
        catch (IOException ioex){
          ioex.printStackTrace();
        }
      }
    }
  }
}
