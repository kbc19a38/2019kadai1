package itecafe;

import java.util.Calendar;
import java.util.Scanner;

public class ITECafe {

    public static void main(String[] args) {
        
        Item[] items = {
            new Item (1,1, "ホットコーヒー", 280),
            new Item (1,2, "紅茶", 260),
            new Item(1,3,"アイスコーヒー",200),
            new Item(1,4, "アイスティー", 260),
            
            new Item (2,5, "ショートケーキ", 400),
            new Item(2,6, "チーズケーキ", 400),
            new Item(2,7, "チョコレートケーキ", 450),
            new Item(2,8, "チョコレートバナナパフェ", 390),
            new Item(2,9, "いちごパフェ", 390),
            
            new Item(3,10, "ミートパスタ", 650),
            new Item(3,11, "ミックスピザ", 700),
            
            new Item(4,12, "クロワッサン", 180),
            new Item(4,13, "トーストサンド", 200),
            new Item(4,14, "フレンチトースト", 210)
        };
        
        Category[] category = {
            new Category(1, "ドリンク"),
            new Category(2, "スイーツ"),
            new Category(3, "軽食"),
            new Category(4, "パン")
        };
        
        // 買い物かご
        ItemKago kago = new ItemKago();

        // 入力準備
        Scanner sc = new Scanner(System.in);

        //その他変数準備
        int goukeiKin = 0;  // 合計金額
        int goukeiKinKari = 0;
        Calendar cal = Calendar.getInstance();  // 売上日時記録用
        int kaikeiNo = 1;   // 会計NO
        
        
        // レジ全体のループ
        while (true) {
            // １会計のループ
            while (true) {
                        // １商品のループ
                while (true) {
            System.out.println("----------------------------------------------------------------------------------------");
        
         // 改行がおかしくならないようにする部分で使う変数
        int n = 0;
        int a = 0;
        int count = 0;
        
                    
        System.out.println("■■■■■■■■　ITEカフェ　～メニュー～　■■■■■■■■");
        
        // カテゴリ単位のループ
        for(int c = 0; c < category.length; c++)
        {
            // 《カテゴリ》
            System.out.println("◆《" + category[c].getCategory() + "》------------------------------");
            {
                
                // 1カテゴリ内の商品を出力するループ
                for(int i = 0; i < items.length; i++) {
                if(items[i].getCate() == c+1){
                    // 改行しない
                    if((i - count + 1) % 3 != 0){
                System.out.printf("%-25s", items[i].getNo() + ":" + items[i].getName() + "[" + items[i].getPrice() + "円]");
                n = 0;
                // 改行する
                } else {
                    System.out.printf("%-25s%n", items[i].getNo() + ":" + items[i].getName() + "[" + items[i].getPrice() + "円]");
                    n = 1; // 二重に改行しないように
                    }
                    // カテゴリに一致する商品[ if(items[i].getCate() == c+1) ]の数を仮に数えておく
                    a++;
                    
                }
            }
                // ループが終わったらループ条件のcountに代入
                count = a;
                
                // 改行チェッカー　n==0(改行していない)なら改行　n!=0(改行している)なら改行しない
            if (n == 0){ System.out.println();
            }else{n = 0;} }
        }
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.print("商品番号を入力してください >");
        
        try{
        int inputItemNo = Integer.parseInt(sc.next());
        
        while(true){
            System.out.println(items[inputItemNo - 1].getName() + ": 数量(+/-)を入力してください　/　取り消し=(c)ancel");
            System.out.print(">");
            String input = sc.next();
            if (input.charAt(0) == 'c') {System.out.println("キャンセルします");
            break;}
            
            else{
            try{
                int inputCount = Integer.parseInt(input);
                 // カゴに入れる
                    kago.inputKago(items[inputItemNo - 1], inputCount);

                    //合計金額を加算する
                    goukeiKin += items[inputItemNo - 1].getPrice() * inputCount;
                    
                    break;
            }
            catch(NumberFormatException e){
        System.out.println("【error: 有効な数値もしくは c を入力してください】");
    }}
        }}
        catch(NumberFormatException e){
        System.out.println("【error: 有効な数値を入力してください】");
    }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("【error: 1～" + items.length + "の数値を入力してください】");
        }
        
        // カゴの一覧を表示
                    System.out.println("---------- 注文一覧 ----------");
                    kago.dispKago();
                    System.out.println("------------------------------");
                    
                    
                    System.out.print("お会計=(k)aikei / 継続入力=(他キー)：");
                    String inputChar = sc.next();
                    if (inputChar.charAt(0) == 'k') {
                        break;
                    } else {
                        continue;
                    }
                }
                
                
                    System.out.println("割引チケットはお持ちですか？ (y)es / (n)o / それ以外を入力すると買い物に戻ります :");
                    
                    
                    boolean waribiki = false;
                    int nanwari = 0;
   
                    String inputChar = sc.next();
                    if (inputChar.charAt(0) == 'y'){ waribiki = true;
                }
                    else if(inputChar.charAt(0) == 'n'){}
                    else{continue;}
                    
                    if(waribiki == true){System.out.println("何割引？");
                    try{
                    String wari = sc.next();
                    nanwari = Integer.parseInt(wari);}
                    
                    catch(NumberFormatException e){
        System.out.println("【error: 有効な数値を入力してください　会計に進みます】");}
                    }
                    
                    
                // お会計処理
                // 合計金額の表示
                System.out.println("-------------------------------");
                System.out.println("小計     " + goukeiKin + "円");
                
                goukeiKinKari = goukeiKin;
                // goukeiKinKariを使わないと会計をキャンセルするたびに合計金が変動してしまうため。
                
                if(waribiki == true){
                    int waribikiKin = goukeiKinKari * nanwari / 10;
                    goukeiKinKari = goukeiKinKari - waribikiKin;
                    System.out.println(nanwari + "割引　　-" + waribikiKin + "円");}
                System.out.println("消費税    " + (int) (Math.floor(goukeiKinKari * 0.08)) + "円");
                goukeiKinKari = (int) (Math.floor(goukeiKinKari * 1.08));
                System.out.println("合計金額  " + goukeiKinKari + "円");
                System.out.println("-------------------------------");

                System.out.print("以上で宜しいですか？=(y)es / 取り消し=(r)eset / 前に戻る=(他キー) : ");
                inputChar = sc.next();
                if (inputChar.charAt(0) == 'y') {

                    break;

                } else if (inputChar.charAt(0) == 'r') {
                    // 合計金額を0にする
                    goukeiKin = 0;
                    // カゴを空にする
                    kago.clearKago();
                    System.out.println("リセットしました");
                    continue;
                }

            }

            // 代金預かり
            goukeiKin = goukeiKinKari;
            
            boolean b = true;
            while(b == true){
            
            System.out.println("-------------------------------");
            System.out.print("預り金を入力してください：");
            
            try{
            String azukariKin = sc.next();
            if(Integer.parseInt(azukariKin) < goukeiKin){
            System.out.println("【error: 預り金が足りません】");
            continue;
            }
            else{
            int turiKin = Integer.parseInt(azukariKin) - goukeiKin;
            System.out.println("釣銭：" + turiKin + "円");
            break;
            }
            }
            catch(NumberFormatException e){
        System.out.println("【error: 有効な数値を入力してください】");
    }
            }

            // 会計番号計算
            System.out.println(cal.get(Calendar.YEAR) + "年"
                    + cal.get(Calendar.MONTH) + "月"
                    + cal.get(Calendar.DATE) + "日"
                    + cal.get(Calendar.HOUR_OF_DAY) + "時"
                    + cal.get(Calendar.MINUTE) + "分");

            System.out.printf("お会計番号：%06d\n", kaikeiNo);
            kaikeiNo++;

            System.out.println("-------------------------------");

            System.out.println("ありがとうございました");

            // 合計金額を0にする
            goukeiKin = 0;
            // カゴを空にする
            kago.clearKago();
        
        
        
        
        
        
        }
    
    }
    
    }
    

