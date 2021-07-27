package src.speaker.state;

public class State {
  private Integer volume = null;
  private Integer rate = null;
  private String text = null;
  
  public Integer getVolume() {
    return this.volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public Integer getRate() {
    return this.rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
