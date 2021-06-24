# Hueのサンプルコード

## 初期設定

HueのIPアドレスを確認  
```url:url
https://discovery.meethue.com/
```
  
得たIPアドレスを使って，下のURLにアクセス  
```url:rul
http://<ip address>/debug/clip.html
```
  
以下のコマンドを入力してPOSTをする  

```url:url
/api
```

```json:Message Body
{"devicetype":"my_hue_app#iphone peter"}
```

下のようなレスポンスが帰ってくる
```json:Command Response
[
	{
		"success": {
			"username": <user name>
		}
	}
]
```

この流れで得た`<ip address>`及び`<user name>`を使用する．

POSTしたのにusernameが得られないときは，ブリッジのPHILIPSボタンを押して，もう一度POSTすること．

IPアドレス及びusernameは`src/hue/Hue.java`の55行目から56行目で設定する．