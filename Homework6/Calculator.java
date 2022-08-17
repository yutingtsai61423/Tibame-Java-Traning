package xxx;

import java.util.Scanner;

public class Calculator {
	private Scanner sc = new Scanner(System.in);
	private int x;
	private int y;
	
	public Calculator() {
		setXY();
	}
		
	public int power(int x, int y) throws CalException  {	
		checkValue(x, y);
		int answer = (int)Math.pow(x, y);
		return answer ;
	}
	
	public void setXY() {
		while(true) {
			System.out.println("請輸入X的值:");
			String strX = sc.nextLine();
			String template = "[-+]{0,1}[0-9]{1,}";
			
			if (strX.matches(template)) {
				x = Integer.parseInt(strX);
			} else {
				System.out.println("輸入格式不正確");
				continue;
			} 
			
			System.out.println("請輸入Y的值:");
			String strY = sc.nextLine();
			if (strY.matches(template)) {
				y = Integer.parseInt(strY);
				
			} else {
				System.out.println("輸入格式不正確");
				continue;
			}
			
			try {
				int finalAns = power(x, y);
				System.out.printf("%d的%d次方等於%d",this.x, this.y,finalAns);
				break;
			} catch (CalException e) {
				System.out.println(e.getMessage()); 
			} catch ( IllegalArgumentException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
	
	
	
	public void checkValue(int x, int y) throws CalException{
		if (x == 0 && y == 0) {
			throw new CalException("0的0次方沒有意義!");
			
		} else if (y < 0) {
			throw new IllegalArgumentException("次方為負值，結果回傳不為整數!");
		} 
	}
	
	public void closeSc() {
		sc.close();
	}

}
