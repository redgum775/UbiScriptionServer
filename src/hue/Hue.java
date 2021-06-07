package src.hue;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import src.hue.state.State;

/**
 * Hueに値を送信するためのクラス。自分のプログラムで使うときはこのクラスのみ利用すれば良い。
 * ライトのON/OFFと色相、彩度、輝度の値を持たせることができ、sendData()によって送信する。
 */
public class Hue {

	/**
	 * Hue(色相)値の範囲 0~63353
	 */
	static final int MAX_HUE = 65535;

	/**
	 * Sat(彩度)値の範囲 0~255
	 */
	static final int MAX_SAT = 255;

	/**
	 * Bri(輝度)値の範囲 0~255
	 */
	static final int MAX_BRI = 255;

	/**
	 * HueのIPアドレス
	 */
	private String address;

	/**
	 * ユーザーネーム
	 */
	private String username;

	/**
	 *  Hue番号
	 */
	private String num;

	private State state;	// コマンドクラス
	private Gson gson = new Gson();	// コマンドクラスをJSONにして書き出し

	// 固定値で初期化
	public Hue(){
		this.address = "392.168.1.27";
		this.username = "username";
		this.num = "1";
	}

	/**
	 * コンストラクタでHueの初期設定を行なう。
	 * @param address HueのIPアドレス
	 * @param username 開発者用のユーザーネーム
	 * @param num Hueの番号
	 */
	public Hue(String address, String username, int num){
		this.address = address;
		this.username = username;
		this.num = String.valueOf(num);
	}

	private URL makeURL(){
		String path = "http://" + address + "/api/" + username + "/lights/" + num + "/state";
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 設定した値をHueに送信する
	 */
	public void sendData(){
		try {
			HttpURLConnection con = (HttpURLConnection) makeURL().openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("PUT");
			con.connect();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(con.getOutputStream()));

			String cmd_json = gson.toJson(state);
			//System.out.println(json.toString());
			System.out.println(cmd_json);
			System.out.println(con.getURL().toString());

			//pw.println(json.toString());
			pw.println(cmd_json);
			pw.flush();
			pw.close();

			con.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showJson(){
		String cmd_json = gson.toJson(state);
		System.out.println(cmd_json);
	}

	public void newState(){
		state = new State();
	}

// ライトのON/OFFをセットする
	public void setOn(boolean on) {
		state.setOn(on);
	}

// 色相をセットする
	public void setHue(int hue) {
		state.setHue(hue);
	}

// 彩度をセットする
	public void setSat(int sat) {
		state.setSat(sat);
	}

// 輝度をセットする
	public void setBri(int bri) {
		state.setBri(bri);
	}

	public int getNum() {
		return Integer.parseInt(num);
	}

	/**
	 * 関連付けたHueの番号を変えるときに使う
	 * @param num Hueの番号
	 */
	public void setNum(int num) {
		this.num = String.valueOf(num);
	}


}
