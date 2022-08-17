package xxx;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Homework10 {

	public static void main(String[] args) {
		Homework10 homework10 = new Homework10();
		homework10.isPrime();
		homework10.inputMath();
		homework10.date();
	}
	
//	請設計一隻程式,用亂數產生5個介於1~100之間的整數,而輸出結果可以判斷出這5個整數為是否為質數 (提示:Math類別)
	public void isPrime() {
		for (int i = 0; i < 5; i++) {
			int num = (int)(Math.random()*100)+1;
			
			double div = 2;
			boolean isPrime = true;
			while (div <= Math.sqrt(num)) {
				if (num % div == 0) {
					isPrime = false;
					break;
				}
				div++;
			}
			StringBuilder sb = new StringBuilder("");
			if (isPrime) {
				sb.replace(0,0,"是");
			} else {
				sb.replace(0, 0, "不是");
			}
			System.out.println(num +""+ sb + "質數");
		}
	}
	
//	 請設計一隻程式,讓使用者可以輸入一個任意數後,可以選擇要以下列何種表示方法顯示(1)千分位(2)百分比(3)科學記號,
//	而輸入非任意數會顯示提示訊息如圖 (提示: TestFormatter.java, Java API文件, 判斷數字可用正規表示法)
//	補充 (依此類推):
//		輸入12345,千分位為12,345,輸入123,千分位為123
//		輸入0.75,百分比為75%,輸入1,結果為100%
	public void inputMath() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(true) {
			System.out.println("請輸入數字: ");
			str = sc.next();
			if(!str.matches("[0-9]{0,}[.]{0,1}[0-9]{0,}")) {
				System.out.println("數字格式不正確，請再輸入一次");
				continue;
			}
			break;
		}
		double newnum = Double.parseDouble(str);
		System.out.println("欲格式化成(1)千分位(2)百分比(3)科學記號");
		int num = sc.nextInt();
		switch (num) {
			case 1 :
				Format fm = new DecimalFormat("###,###,###.####");
				System.out.println(fm.format(newnum));
				break;
			case 2 :
				Format fm2 = new DecimalFormat("0.#######%");
				System.out.println(fm2.format(newnum));
				break;
			case 3 :
				Format fm3 = new DecimalFormat("0.#####E00");
				System.out.println(fm3.format(newnum));
				break;
		}
	}
	

//	請設計一隻程式,讓使用者輸入日期(年月日,例如:20110131)後,可以轉成想要的輸出格式化成(1)年/月/日(2)月/日/年(3)日/月/年三選一,而輸入非指定日期數字格式會顯示出提示訊息如圖
	 public void date() {
		 Scanner sc = new Scanner(System.in);
		 String str = "";
		 while (true) {
			 System.out.println("請輸入日期(年月日,例如:20110131)");
			 str = sc.next();
			 if (!str.matches("[0-9]{8}")) {
				 System.out.println("日期格式不正確，請再輸入一次");
				 continue;
			 }
			 break;
		 }
		 StringBuilder sb = new StringBuilder(str);
		 sb.insert(4,"-").insert(7, "-");
		 java.util.Date newdate = java.sql.Date.valueOf(sb.toString());
		 
		 System.out.println("欲格式化成(1)年/月/日(2)月/日/年(3)日/月/年三選一");
		 int choice = sc.nextInt();
		 switch (choice) {
		 	case 1:
		 		Format fm = new SimpleDateFormat("yyyy/MM/dd");
		 		System.out.println(fm.format(newdate));
		 		break;
		 	case 2:
		 		Format fm2 = new SimpleDateFormat("MM/dd/yyyy");
		 		System.out.println(fm2.format(newdate));
		 		break;
		 	case 3:
		 		Format fm3 = new SimpleDateFormat("dd/MM/yyyy");
		 		System.out.println(fm3.format(newdate));
		 		break;
		 }
	 }
	
}
