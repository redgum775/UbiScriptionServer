package src.hue.state;

//import java.util.List;

public class State {
  private Boolean on = null;
  private Integer bri = null;  // 0~255
  private Integer hue = null;  // 0-65535
  private Integer sat = null;  // 0~255
  //private List<float> xy;
  private Integer ct = null;
  private String alert = null;
  private String effect = null;
  private Integer transitiontime = null;
  private Integer bri_inc = null; // -254 to 254
  private Integer sat_inc = null; // -254 to 254
  private Integer hue_inc = null; // -65534 to 65534
  private Integer ct_inc = null;
  //private List<float> xy_inc; 

  public void setOn(boolean on){
    this.on = on;
  }

  public void setBri(int bri){
    this.bri = bri;
  }

  public void setHue(int hue){
    this.hue = hue;
  }

  public void setSat(int sat){
    this.sat = sat;
  }

  public void setCt(int ct){
    this.ct = ct;
  }
}
