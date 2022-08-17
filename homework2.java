package xxx;

public class homework2 {
	public static void main(String[] args) {
		//請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum = 0;
		for (int i = 1; 2*i <=1000; i++) {
			sum += 2*i;
		}
		System.out.println("2 + 4 + 6 + 8 + ... + 1000 = " + sum);
		
		System.out.println("---------------------------------------");
		
		//請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int sum2 = 1;
		for (int i = 1; i <= 10; i++) {
			sum2 *= i;
		}
		System.out.println("1 * 2 * 3 * ... * 10 = " + sum2);
		
		System.out.println("---------------------------------------");	
		
		//請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int sum3 = 1;
		int count = 1;
		while (count <= 10) {
			sum3 *= count;
			count++;
		}
		System.out.println("1 * 2 * 3 * ... * 10 = " + sum3);
		
		System.out.println("---------------------------------------");
		
		//請設計一隻Java程式,輸出結果為以下: 1 4 9 16 25 36 49 64 81 100
		for (int i = 1; i <= 10; i++) {
			System.out.print((int)Math.pow(i, 2) + "  ");
		}
		System.out.println();
		
		System.out.println("---------------------------------------");
		
		//阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。
		//請設計一隻程式,輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		int count2 = 0;
		System.out.print("Numbers you can choose : ");
		for (int i = 1; i <= 49; i++) {
			if( i / 10 != 4 && i % 10 != 4) {
				System.out.print(i+ "  ");
				count2++;
			}
		}
		System.out.println();
		System.out.println("amount of numbers : " + count2);
		
		System.out.println("---------------------------------------");
		
		/*
		請設計一隻Java程式,輸出結果為以下:
		1 2 3 4 5 6 7 8 9 10
		1 2 3 4 5 6 7 8 9
		1 2 3 4 5 6 7 8
		1 2 3 4 5 6 7
		1 2 3 4 5 6
		1 2 3 4 5
		1 2 3 4
		1 2 3
		1 2
		1
		*/
		for (int i = 0; i <= 9; i++) { 
			for (int j = 1; j <= 10 - i; j++) { 
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------");
		
		/*
		請設計一隻Java程式,輸出結果為以下:
		A
		BB
		CCC
		DDDD
		EEEEE
		FFFFFF*/
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j <= i+1; j++) {
				System.out.print((char)(65 + i));
			}
			System.out.println();
		}		
	}
}
