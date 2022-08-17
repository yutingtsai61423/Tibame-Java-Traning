package xxx;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class Homework8 { 
	public static void main(String[] args) {
		Homework8 hw8 = new Homework8();
//		hw8.collectionTest();
		Train[] trains = {
							new Train(202, "普悠瑪", "樹林", "花蓮", 400), 
							new Train(1254, "區間", "屏東", "基隆", 700), 
							new Train(118, "自強", "高雄", "台北", 500), 
							new Train(1288, "區間", "新竹", "基隆", 400), 
							new Train(122, "自強", "台中", "花蓮", 600), 
							new Train(1222, "區間", "樹林", "七堵", 300), 
							new Train(1254, "區間", "屏東", "基隆", 700)  };

		CollectionTrain control = new CollectionTrain();
//		請寫一隻程式,能印出不重複的Train物件
//		control.printNoRepeatTrain(trains);
//		請寫一隻程式,讓Train物件印出時,能以班次編號由大到小印出
//		control.printSortedTrain(trains);
//		承上,不僅能讓班次編號由大排到小印出, 還可以不重複印出Train物件
//		control.printSortedandNoRepeatTrain(trains);
	}

	
	public void collectionTest() {
		/*
		 * • 請建立一個Collection物件並將以下資料加入:Integer(100)、Double(3.14)、Long(21L)、Short("100")、
		 * Double(5.1)、"Kitty"、Integer(100)、Object物件、"Snoopy"、BigInteger("1000") •
		 * 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach) • 移除不是java.lang.Number相關的物件 •
		 * 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功
		 */
		ArrayList arrList = new ArrayList();
		Object[] arr = { Integer.valueOf(100), Double.valueOf(3.14), Long.valueOf(21L), Short.valueOf("100"),
				Double.valueOf(5.1), "Kitty", Integer.valueOf(100), new Object(), "Snoopy", new BigInteger("1000") };
		for (Object obj : arr) {
			arrList.add(obj);
		}

		// 印出
		Iterator it = arrList.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		for (int i = 0; i < arrList.size(); i++) {
			Object obj = arrList.get(i);
			System.out.print(obj + " ");
		}
		System.out.println();
		for (Object obj : arrList) {
			System.out.print(obj + " ");
		}

		// 移除
		Object[] target = new Object[arrList.size()];  
		for (int i = 0; i < arrList.size(); i++) {
			Object obj = arrList.get(i);
			if (!(obj instanceof Number)) {
				target[i] = obj;  					
			}
		}
		for (int i = 0; i < target.length; i++) {  
			if(target[i] != null) {
				arrList.remove(target[i]); 
				
			}
		}
		System.out.println();
		for (Object obj : arrList) {
			System.out.print(obj + " ");
		}
	}
}

class Train implements Comparable<Train>{
	/*
	 * 請設計一個Train類別,並包含以下屬性:
		- 班次 number,型別為int - 車種 type,型別為String - 出發地 start,型別為String
		- 目的地 dest,型別為String - 票價 price,型別為double
		• 設計對應的getter/setter方法,並在main方法裡透過建構子產生以下7個Train的物件,放到每小題
		需使用的集合裡
		- (202, "普悠瑪", "樹林", "花蓮", 400)
		- (1254, "區間", "屏東", "基隆", 700)
		- (118, "自強", "高雄", "台北", 500)
		- (1288, "區間", "新竹", "基隆", 400)
		- (122, "自強", "台中", "花蓮", 600)
		- (1222, "區間", "樹林", 七堵, 300)
		- (1254, "區間", "屏東", "基隆", 700)
	 * */
	private int number;
	private String type, start, dest;
	private double price;

	
	public Train() {
	}
	public Train(int number, String type, String start, String dest, double price) {
		this.setNumber(number);
		this.setType(type);
		this.setStart(start);
		this.setDest(dest);
		this.setPrice(price);
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	public String getStart() {
		return start;
	}
	public String getDest() {
		return dest;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		String str ="["+ this.getNumber() + ", " + this.getType() + ", " + this.getStart() + ", " + this.getDest() + ", " + this.getPrice() + "]"+ "\n";
		return str;
	}
	
	@Override
	public int compareTo(Train aTrain) {
		if (this.number > aTrain.number) {
			return 1;
		} else if (this.number == aTrain.number) {
			return 0;
		} else return -1;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dest, number, price, start, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return Objects.equals(dest, other.dest) && number == other.number
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(start, other.start) && Objects.equals(type, other.type);
	}
	
	
}

class CollectionTrain{
	private HashSet<Train> hs = new HashSet<Train>();
	private ArrayList<Train> al = new ArrayList<Train>();
	private TreeSet<Train> ts = new TreeSet<Train>();

	public void printNoRepeatTrain(Train[] arr) {
		for (Train train : arr) {
			hs.add(train);
		}
		
		Iterator<Train> it = hs.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
	}
	
	public void printSortedTrain(Train[] arr) {
		for (Train t : arr) {
			al.add(t);
		}
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i));
		}
	}
	
	public void printSortedandNoRepeatTrain(Train[] arr) {
		for (int i = 0; i < arr.length; i++) {
			ts.add(arr[i]);
		}
		for (Train train : ts) {
			System.out.print(train);
		}
		
	}

}
