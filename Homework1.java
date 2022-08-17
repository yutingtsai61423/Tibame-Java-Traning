package xxx;

public class Homework1 {
	
	public static void main(String[] args) {
		/*First*/
		System.out.println("1st: 12 + 6 = " + (12 + 6) +", 12 * 6=" + (12 * 6));
	
		/*Second*/
		int dozen = 200/12;
		int several = 200%12;
		System.out.printf("2nd: 200顆雞蛋一共是%d打%d顆%n", dozen, several);
		
		/*third*/
		int target = 256559;
		int target_days = target / (24*60*60);
		int target_hours = (target % (24 * 60 * 60)) / (60 * 60);
		int target_minutes = (target % (60*60))/60;
		int target_seconds = target % 60;
		System.out.printf("3rd:　256559秒為%d天%d小時%d分%d秒%n", target_days, target_hours, target_minutes, target_seconds);
		
		/*forth*/
		final double PI = 3.1415;
		int radius = 5;
		System.out.printf("4th: 圓面積為%.3f, 圓周長為%.3f%n",PI*Math.pow(radius,2), 2*PI*radius);
		
		/*fifth*/
		int baseCash = 150_0000;
		int finalCash = (int)(baseCash*Math.pow((1+0.02),10));
		System.out.printf("5th: 本金加利息一共%d元%n", finalCash);
		
		/*sixth*/
		System.out.println("6th: " + (5 + 5));   //10 因整數相加 5+5=10
		System.out.println("     " + (5 + '5')); //55 5 + 5 的 ASCII CODE = 5+53 = 58
		System.out.println("     " + (5 + "5")); //55 因字串相接
	}

}
