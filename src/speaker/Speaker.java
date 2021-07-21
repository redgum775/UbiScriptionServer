package src.speaker;

import com.google.gson.Gson;

import src.speaker.state.State;

public class Speaker {
  String  address = null;  // スピーカーのIPアドレス
  Integer port = null;     // スピーカーのポート番号

  State state = null;      // スピーカーの状態
  
  public Speaker(){
    address = "192.168.1.1";
    port = 5000;
  }

  public void sendData(){
    Gson gson = new Gson();
    String json = gson.toJson(state);
  }
}
