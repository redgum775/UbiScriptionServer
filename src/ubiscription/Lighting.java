package src.ubiscription;

public class Lighting{
  private String target = "light";          // 操作機器
  private String cmd_type = null;           // ライトに対する操作
  private Integer light_id = null;          // ライトのid
  private String light_color = null;        // ライトの色
  private Integer light_brightness = null;  // ライトの明るさ

  public Lighting(String cmd_type){
    this.cmd_type = cmd_type;
  }

  public Lighting(String cmd_type, String light_color, int light_brightness){
    this.cmd_type = cmd_type;
    this.light_color = light_color;
    this.light_brightness = light_brightness;
  }

  public void showFilde(){
    System.out.println( "target: " + target + "\n"
                      + "cmd_type: " + cmd_type + "\n"
                      + "light_id: " + light_id + "\n"
                      + "light_color: " + light_color + "\n"
                      + "light_brightness: " + light_brightness);
  }

  // Getter & Setter
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getCmdType() {
    return cmd_type;
  }

  public void setCmdType(String cmd_type) {
    this.cmd_type = cmd_type;
  }

  public int getLightId() {
    return light_id;
  }

  public void setLightId(Integer light_id) {
    this.light_id = light_id;
  }

  public String getLightColor() {
    return light_color;
  }

  public void setLightColor(String light_color) {
    this.light_color = light_color;
  }

  public int getLightBrightness() {
    return light_brightness;
  }

  public void setLightBrightness(Integer light_brightness) {
    this.light_brightness = light_brightness;
  }
}
