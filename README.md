# ellipsiSk
お試しでつくったSkアドオンです。
多分需要は0です。
## 追加する書式
### フォーマット
- 変数に1を加算
```yml
&#91;(e|ellipsisk)&#93; ++(%numbers%)
```
- 変数に-1を加算
```yml
&#91;(e|ellipsisk)&#93; --(%numbers%)
```
- 変数にオブジェクト(文字列、数値など)をセット
```yml
(e|ellipsisk) %objects% = %objects%
```
### 例
変数Aに1を加算します。
```yml
++{A}
```
変数Aに-1を加算します。
```yml
--{A}
```
変数Aに25をセットします。
```yml
e {A} = 25
```
