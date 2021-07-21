package src.ubiscription;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import src.hue.Hue;

public class Command{
  private String target = null;       // コマンド操作のターゲット
  private Lighting lighting = null;   // ライト

  public Command(){
  }

  // Json文字列が正常かどうか確認
  public boolean isJson(String Json) {
    Gson gson = new Gson();
    try {
        gson.fromJson(Json, Object.class);
        Object jsonObjType = gson.fromJson(Json, Object.class).getClass();
        if(jsonObjType.equals(String.class)){
            return false;
        }
        return true;
    } catch (JsonSyntaxException ex) {
        return false;
    }
  }

  // Json文字列をオブジェクトクラスに変換
  public void readCommand(String json){
    Gson gson = new Gson();
    // Jsonの解析
    Command cmd = gson.fromJson(json, Command.class);
    // コマンドのターゲットがライト
    if(cmd.getTarget().equals("lighting")){
      // フィールド値の確認
      cmd.getLighting().showFilde();
      // Hueをオン
      if(cmd.getLighting().getCmdType().equals("on")){
        Hue hue = new Hue();
        hue.newState();
        hue.setOn(true);
        hue.sendData();
      // Hueをオフ
      }else if(cmd.getLighting().getCmdType().equals("off")){
        Hue hue = new Hue();
        hue.newState();
        hue.setOn(false);
        hue.sendData();
      // 色変更
      }else if(cmd.getLighting().getCmdType().equals("color")){
        Hue hue = new Hue();
        hue.newState();
        if(cmd.getLighting().getLightColor().equals("あか")){
          hue.setOn(true);
          hue.setHue(0);    // 色を指定
          hue.setBri(128);  // 明るさ
          hue.setSat(255);  // 色の濃さ
        }else if(cmd.getLighting().getLightColor().equals("あお")){
          hue.setOn(true);
          hue.setHue(45000);  // 色を指定
          hue.setBri(128);  // 明るさ
          hue.setSat(255);  // 色の濃さ
        }else if(cmd.getLighting().getLightColor().equals("きい")){
          hue.setOn(true);
          hue.setHue(16000);  // 色を指定
          hue.setBri(128);  // 明るさ
          hue.setSat(255);  // 色の濃さ
        }else if(cmd.getLighting().getLightColor().equals("みど")){
          hue.setOn(true);
          hue.setHue(28000);  // 色を指定
          hue.setBri(128);  // 明るさ
          hue.setSat(255);  // 色の濃さ
        }else if(cmd.getLighting().getLightColor().equals("しろ")){
          hue.setOn(true);
          hue.setHue(33000);  // 色を指定
          hue.setBri(128);  // 明るさ
          hue.setSat(255);  // 色の濃さ
        }
        hue.sendData();
      }else if(cmd.getLighting().getCmdType().equals("color_value")){
        Hue hue = new Hue();
        hue.newState();
        hue.setOn(true);
        hue.setHue(hue.getHue(cmd.getLighting().getLightColorValue()));  // 色を指定
        hue.sendData();
      }  
    }
    // コマンドのターゲットが…
    if(cmd.getTarget().equals("landmarks")){
    }
  }

  public String getTarget(){
    return this.target;
  }

  public Lighting getLighting(){
    return this.lighting;
  }
}
