package xxx;

public class HomeworkExt{
	public static void main(String[] args) {
		Pen[] pen = new Pen[2];
		pen[0] = new Pencil("pental 鉛筆", 50);
		pen[1] = new InkBrush("王羲之 毛筆", 500000);
		
		for (int i = 0; i < pen.length; i++) {
			System.out.println("品牌: " + pen[i].getBrand() + " 實際售價: "+pen[i].getPrice());
			pen[i].write();
		}
	}
}



abstract class Pen {
	private String brand;
	private int price;
	
	public Pen() {
		
	}
	
	public Pen(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public abstract void write();
	
}

class Pencil extends Pen{
	public Pencil() {
		super();
	}
	
	public Pencil(String brand, int price) {
		super(brand, price);
	}
	
	public void write() {
		System.out.println("削鉛筆再寫");
	}
	
	public int getPrice() {
		return (int)(super.getPrice()*0.8);
	}
}

class InkBrush extends Pen{
	public InkBrush() {
		super();
	}
	
	public InkBrush(String brand, int price) {
		super(brand, price);
	}
	
	public void write() {
		System.out.println("沾墨汁再寫");
	}
	
	public int getPrice() {
		return (int)(super.getPrice()*0.9) ;
	}
}
