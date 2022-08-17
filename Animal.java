package xxx;

public class Animal {
	
	private int age;
	private float weight;
	
	public Animal() {
		
	}
	
	public Animal (int age, float weight) {
		this.setWeight(weight);
		this.setAge(age);
	}
	
	public void setWeight (float weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
	public void setAge (int age) {
		if (age > 0) {
			this.age = age;
		}
	}
	
	public int getAge() {
		return age;
	}

	public float getWeight() {
		return weight;
	}

	public void speak() {
		System.out.printf("age: %d\nweight: %.3f\n", this.age, this.weight);
	}
	
	/*
	 *  建立一個class，名為Animal.java
 		此類別有兩個成員變數分別為age(年紀 - 型別int)、weight(體重 - 型別float)
		宣告有參數的建構子
 	
		有一成員方法名為speak()，用以列印上述兩個值
		
		再新增一個AnimalTest.java
		在main()裡藉由建構子產生一個Animal，同時初始化該物件的年紀和體重
		分別為2歲、5.0公斤，並呼叫speak方法得到此Animal的成員變數值
	
	 * */

}
