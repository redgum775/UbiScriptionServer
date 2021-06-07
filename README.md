# UbiScription Server
MediaPipeによる指文字認識を用いたコマンド操作のサーバープログラム．  
### **操作対応機器**  
- [x] Hue ライト

### **ビルド方法**
---
**本プロジェクトのビルド方法について**  
- VS CodeのRun機能を使用する  
- Bazelを使用する (開発環境では```bazel version: 3.7.0```)

コマンド例  
```
$ bazel run src/ubiscription:server
```
上記の二通りがあります．
