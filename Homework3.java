package xxx;

import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Homework3.triangle();
//		Homework3.guessnum_easy();
//		Homework3.guessnum_hard();
//		Homework3.lottery();
//		Homework3.lotteryAdvance();
		
		sc.close();

	}

	//請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰	三角形、直角三角形、其它三角形或不是三角形
	public static void triangle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入三個整數：");		
		int[] edge = new int [3];
		for (int i = 0; i < edge.length; i++) {
				int a = sc.nextInt();
				edge[i] = a;
		}
		
		Arrays.sort(edge);
		int a = edge[0], b = edge[1], c = edge[2];
		
		if ((a + b > c && a + c > b && b + c > a) && (c - b < a && c - a < b && b-a < c)){
			if ( a == b && b == c) {
				System.out.println("正三角形");
			} else if (a == b || a == c || b == c) {
				System.out.println("等腰三角形");
			} else if ( a * a + b * b == c * c ) {
				System.out.println("直角三角形");
			} else {
				System.out.println("其他三角形");
			}
		}else {
			System.out.println("不是三角形");
		}

	}
	
	//請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜對則顯示正確訊息
	public static void guessnum_easy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("開始猜數字吧！");
		int key = (int)(Math.random()*10);
		while (true) {
			int input = sc.nextInt();
			if (input == key) {
				System.out.println("答對了！答案就是"+ key);
				break;
			}else {
				System.out.println("猜錯囉，再輸入一次");
			}
		}

	}
	
	//進階功能:產生0~100亂數,每次猜就會提示你是大於還是小於正確答案
	public static void guessnum_hard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("開始猜數字吧！");
		int key = (int)(Math.random()*101);

		while (true) {
			int answer = sc.nextInt();
			if (answer > key) {
				System.out.println("你比答案大唷！");
			}else if (answer < key) {
				System.out.println("你比答案小唷！");
			}else {
				System.out.println("答對囉！答案就是" + key);
				break;
			}
			
		}
	}
	
	//阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討厭哪個數字,
	//請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇的號碼與總數,
	public static void lottery() {
		System.out.println("阿文...請輸入你討厭哪個數字?");
		Scanner sc = new Scanner(System.in);
		
		int hateNum = 0;
		while (true) {
			if (sc.hasNextInt()) {
				hateNum = sc.nextInt();	
				break;
			} else {
				System.out.println("不是數字，請再一次");	
				sc.nextLine();
			}
		}
		
		int counter = 0;
		for (int i = 1; i <= 49; i++) {
			if ((i / 10 != hateNum) && (i % 10 != hateNum)) {
				System.out.print(i+"\t");
				counter++;
			}
			if (counter % 6 == 0) {
				System.out.println();
			}
		}
		System.out.printf("總共有%d數字可選\n", counter);		
	}
	
	//進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重複
	public static void lotteryAdvance() {
		System.out.println("阿文...請輸入你討厭哪個數字?");
		Scanner sc = new Scanner(System.in);
		
		int hateNum = 0;
		while (true) {
			if (sc.hasNextInt()) {
				hateNum = sc.nextInt();	
				break;
			} else {
				System.out.println("不是數字，請再一次");	
				sc.nextLine();
			}
		}
			
		int counter = 0;
		int[] array = new int[49];
		for (int i = 1; i <= 49; i++) {
			if ((i / 10 != hateNum) && (i % 10 != hateNum)) {
				array[counter++] = i;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			int random = (int)(Math.random()*(counter-i)+i);
			int tmp = array[i];
			array[i] = array[random];
			array[random] = tmp;
			System.out.print(array[i] + " ");
		}	
	}	
}
