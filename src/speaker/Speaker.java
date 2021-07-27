package src.speaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import src.speaker.state.State;

public class Speaker {
  String  address = null;  // スピーカーのIPアドレス
  Integer port = null;     // スピーカーのポート番号

	Socket socket = null;
	BufferedReader reader = null;
	PrintWriter writer = null;

  State state = null;      // スピーカーの状態
  
  public Speaker(){
    address = "192.168.1.7";
    port = 5010;
  }

  public void connection(){
    try {
      socket = new Socket(address, port);
      writer = new PrintWriter(socket.getOutputStream(), true);
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void disconnection(){
      try {
        if(socket != null) socket.close();
        if(writer != null) writer.close();
        if(reader != null) reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  public void sendData(){
    if(state != null){
      Gson gson = new Gson();
      String json = gson.toJson(state);
      try{
        writer.println("[" + json + "]");
        System.out.println("Sended: [" + json + "]");
        System.out.println("Received: " + reader.readLine());
        writer.println("q^");
        System.out.println("sended: q^");
        System.out.println("Received: " + reader.readLine());
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  public void setPlayText(String text){
    state = new State();
    state.setText(text);
  }
}
