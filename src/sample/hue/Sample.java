package src.sample.hue;

public class Sample {
	static String address = "192.168.1.27";
	static String username = "bdgiXxlcWWgUr2go9YhQzc8JIXJMGt3saEAJB9Kq";


	public static void main(String[] args){

		// 1: インスタンス化
		Hue hue = new Hue(address, username, 1);

		// 2: 値の設定
		hue.newState();
		hue.setOn(true);
		hue.setHue(1);
		hue.setSat(1);
		hue.setBri(1);

		// 3: 値の送信
		//hue.sendData();
		hue.showJson();
	}
}
