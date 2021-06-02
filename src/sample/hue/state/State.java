package src.sample.hue.state;

//import java.util.List;

public class State {
  private boolean on;
  private int bri;  // 0~255
  private int hue;  // 0-65535
  private int sat;  // 0~255
  //private List<float> xy;
  private int ct;
  private String alert;
  private String effect;
  private int transitiontime;
  private int bri_inc; // -254 to 254
  private int sat_inc; // -254 to 254
  private int hue_inc; // -65534 to 65534
  private int ct_inc;
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
