package src.speaker.state;

public class State {
  private Boolean play = null;
  private Boolean pause = null;
  private Boolean stop = null;
  private Integer volume = null;
  private String text = null;

  public Boolean getPlay() {
    return play;
  }

  public void setPlay(Boolean play) {
    this.play = play;
  }
  
  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
