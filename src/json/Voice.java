package src.json;

public class Voice {
  private String cmd_type = null;
  private String target = null;
  private String voice = null;
  private Integer rate = null;
  private Integer volume = null;
  public Voice(){
  }

  public String getCmdType(){
    return this.cmd_type;
  }

  public String getText(){
    return this.voice;
  }
}
