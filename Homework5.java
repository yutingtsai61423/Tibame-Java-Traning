package xxx;

import java.util.Arrays;
import java.util.Scanner;

public class Homework5 {
	public static void main(String[] args) {
		Homework5 homework5 = new Homework5();
		
//		使用者鍵盤輸入寬與高時,即會印出對應的*長方形
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入寬與高:");
		int width = sc.nextInt();
		int height = sc.nextInt();
		homework5.starSquare(width, height);
		sc.close();
		
		//亂數
//		homework5.randAvg();
		
		//overloading二維陣列
//		int[][] intArray = {
//				{1, 6, 3},
//				{9, 5, 2}
//		};
//		double[][] doubleArray = {
//				{1.2, 3.5, 2.2},
//				{7.4, 2.1, 8.2}
//		};
//		System.out.println(homework5.maxElement(intArray));
//		System.out.println(homework5.maxElement(doubleArray));
		
		//驗證碼
//		System.out.println(homework5.genAuthCode());
		
		

	}
	
	//請設計一個方法為starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形
	public void starSquare(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值,如圖:
	public void randAvg() {
		int sum = 0;
		System.out.println("本次亂數結果: ");
		for (int i = 0; i < 10; i++) {
			int num = (int)(Math.random()*101);
			sum += num;
			System.out.print(num+" ");
		}
		System.out.println("\n" + sum/10.0);
	}
	
	//利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
	//可以找出二維陣列的最大值並回傳,如圖:
	public int maxElement(int[][] x) {
		int[] x0 = Arrays.copyOf(x[0], x[0].length);
		Arrays.sort(x0);
		int[] x1 = Arrays.copyOf(x[1], x[1].length);
		Arrays.sort(x1);
		
		int max = 0;
		if (x1[x1.length-1] >= x0[x0.length-1]) {
			max = x1[x1.length-1];
		} else {
			max = x0[x0.length-1];
		}
		return max;
	}
	
	public double maxElement(double[][] x) {
		double[] allIn = new double[x[0].length + x[1].length];
		for (int i = 0; i < allIn.length; i++) {
			if ( i < x[0].length) {
			allIn[i] = x[0][i];
			} else {
				allIn[i] = x[1][i-x[0].length];
			}
		}
		Arrays.sort(allIn);
		return allIn[allIn.length-1];
	}
	
	/*身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
	genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
	與數字的亂數組合,如圖:
	*/
	public String genAuthCode() {
		int[] array = new int[8];
		
		for (int i = 0; i < 8; i++) {
			int num = 0;
			int oneThird = (int)(Math.random()*3);
			if (oneThird == 0) {
				num = (int)(Math.random()*(57-47) + 48);
			} else if (oneThird == 1) {
				num = (int)(Math.random()*(90-64) + 65);
			} else {
				num = (int)(Math.random()*(122-96) + 97);
			}
			array[i] = num;
		}
		
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str += (char)array[i];
		}
		return str;
	}
	
}

//*請設計一個類別MyRectangle:
class MyRectangle{
	
	//有兩個double型態的屬性為width, depth
	private double width;
	private double depth;
	
	//void setWidth(double width): 將收到的引數指定給width屬性
	public void setWidth(double width) {
		this.width = width;
	}
	
	//void setDepth(double depth): 將收到的引數指定給depth屬性	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	//double getArea(): 能計算該長方形的面積
	public double getArea() {
		return width*depth;
	}
	
	//public MyRectangle(): 不帶參數也無內容的建構子
	public MyRectangle() {
		
	}
	
	//public MyRectangle(double width, double depth): 傳入的兩個引數會指定給對應的屬性
	public MyRectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}
	
}