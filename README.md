# GameOfLife

This is one of my school project, a Java version of Conway's Game of Life.

これは私の学校の課題の一つで、コンウェイのライフゲームのJava版です。

Credit to the original inventor: Cambridge mathematician John Conway.

原作者であるケンブリッジ大学の数学者、ジョン・コンウェイに感謝します。

## Run

```powershell
javac *.java
java GameOfLife
```

## Buttons

- Start / Stop =シミュレーションの開始と一時停止
- Step =1世代だけ進める
- Random =ランダムにセルを配置する
- Clear =盤面をクリアする（すべて死滅状態にする）

## Files

- `GameOfLife.java` starts the program / プログラムの起動
- `GameWindow.java` creates the main window / メインウィンドウの作成
- `GameBoard.java` displays the cell table / セル盤面の描画
- `GameControls.java` handles the buttons / ボタンのイベント処理
- `LifeGrid.java` stores alive/dead cells / 生死セルのデータ保持
- `LifeRules.java` calculates the next generation / 次世代の計算ルール
- `GameStyle.java` stores colors, size, and speed / 色、サイズ、速度の設定を保持

## Reading Order

1. `GameOfLife.java`
2. `GameWindow.java`
3. `GameControls.java`
4. `GameBoard.java`
5. `LifeGrid.java`
6. `LifeRules.java`
7. `GameStyle.java`

=============================================
