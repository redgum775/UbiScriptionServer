package src.voice;

import com.google.gson.annotations.Expose;

public class Voice{
  @Expose
  private String target = "voice";  // 操作機器
  @Expose
  private String cmd_type = null;          // スピーカーに対する操作
  @Expose
  private Integer volume = null;             // 音の大きさ
  @Expose
  private Integer rate = null;              // 音の速さ
  @Expose
  private String text = null;       // 再生したいテキスト

  public Voice(String cmd_type){
    this.cmd_type = cmd_type;
  }

  public Voice(String cmd_type, String text){
    this.cmd_type = cmd_type;
    this.text = text;
  }

  public Voice(String cmd_type, int volume, int rate){
      this.cmd_type = cmd_type;
      this.volume = volume;
      this.rate = rate;
  }
}
