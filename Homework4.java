package xxx;

import java.util.Arrays;
import java.util.Scanner;

public class Homework4 {
	public static void main(String[] args) {
//		Homework4.getAvg();
//		Homework4.reverseString();
//		Homework4.vowel();
//		Homework4.borrowMoney();
//		Homework4.daysOfYear();
//		Homework4.highestScore();
	}

	// 有個一維陣列如下: {29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
	// 請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素 (提示:陣列,length屬性)
	public static void getAvg() {
		int[] array = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 };

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		double avg = (double) sum / array.length;

		String str = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] > avg) {
				str += array[i] + " ";
			}
		}
		System.out.printf("平均值為%.3f, \n大於平均值元素為%s\n", avg, str);
	}

	// • 請建立一個字串,經過程式執行後,輸入結果是反過來的
	// 例如String s = “Hello World”,執行結果即為dlroW olleH (提示:String方法,陣列)
	public static void reverseString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入測試字串: ");
		String str = sc.nextLine();
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println("");
	}

	// • 有個字串陣列如下 (八大行星):
	// {“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”,
	// “neptune”}
	// 請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)(提示:字元比對,String方法)

	public static void vowel() {
		String[] str = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
		int counter = 0;

		Arrays.sort(vowel);
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				if (Arrays.binarySearch(vowel, str[i].charAt(j)) >= 0) {
					counter++;
				}
			}
		}

		System.out.printf("母音一共:%d個\n", counter);
	}

	// 阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個,其員工編號與身上現金列表如下:
	// 請設計一個程式,可以讓阿文輸入欲借的金額後,便會顯示哪些員工編號的同事有錢可借他;
	// 並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的員工編號: 25 19 27 共 3 人!」
	// (提示:Scanner,二維陣列)

	public static void borrowMoney() {
		Scanner sc = new Scanner(System.in);
		int wanted$ = sc.nextInt();
		int[][] array = { { 25, 2500 }, { 32, 80 }, { 8, 500 }, { 19, 1000 }, { 27, 1200 } };
		String str = "";
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][1] > wanted$) {
				str += array[i][0] + " ";
				counter++;
			}
		}
		System.out.printf("有錢可借的員工編號: %s 共%d人!", str, counter);
	}

	// 請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
	// 例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」
	// (提示1:Scanner,陣列) (提示2:需將閏年條件加入) (提示3:擋下錯誤輸入:例如月份輸入為2,則日期不該超過29)
	public static void daysOfYear() {
		int[] monthDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner sc = new Scanner(System.in);
		int year = 0;
		int month = 0;
		int date = 0;
		while (true) {
			year = sc.nextInt();
			month = sc.nextInt();
			date = sc.nextInt();
			if (monthDays[month] < date && month > 12 && month < 0) {
				System.out.println("輸入不合理，請再輸一次");
				sc.nextLine();
				continue;
			} else if (year % 4 != 0 && month == 2 && date > 28) {
				System.out.println("輸入不合理，請再輸一次");
				sc.nextLine();
				continue;
			} else {
				break;
			}
		}
		
		int day = 0;
		if (month == 1) {
			day = date;
		} else {

			for (int i = 0; i < month - 1; i++) {
				day += monthDays[i];
			}
			day = day + date;

			if ((month > 2) && (year % 4 != 0)) {
				day -= 1;
			}
		}
		System.out.printf("輸入的日期為該年第%d天\n", day);
	}

	// 班上有8位同學,他們進行了6次考試結果如下: 請算出每位同學考最高分的次數(提示:二維陣列)
	public static void highestScore() {
		int[][] array = { { 10, 35, 40, 100, 90, 85, 75, 70 }, { 37, 75, 77, 89, 64, 75, 70, 95 },
						  { 100, 70, 79, 90, 75, 70, 79, 90 }, { 77, 95, 70, 89, 60, 75, 85, 89 },
						  { 98, 70, 89, 90, 75, 90, 89, 90 },  { 90, 80, 100, 75, 50, 20, 99, 75 } };
		int[] count = new int[8]; 
		for (int i = 0; i < array.length; i++) {
			int index = 0;
			int maxScore = array[i][0];
			for (int j = 0; j < array[i].length; j++) {   			
				if (maxScore < array[i][j]) {       
					maxScore = array[i][j];
					index = j;                 
				}
			}
			count[index]++;  //count 
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.printf("%d號: %d次 | ", i+1, count[i]);
		}
	}

}
