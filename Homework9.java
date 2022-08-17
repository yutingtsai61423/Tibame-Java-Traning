package xxx;

public class Homework9 {

	public static void main(String[] args) {
		Eat mantal = new Eat("饅頭人");
		Eat james = new Eat("詹姆士");

		Thread t1 = new Thread(mantal);
		Thread t2 = new Thread(james);
		System.out.println("----大胃王比賽開始----");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("----大胃王快食比賽結束----");
		
		
		
		Bank bank = new Bank();
		Mom mom = new Mom(bank);
		Bear bear = new Bear(bank);
		
		mom.start();
		bear.start();
		
		try {
			mom.join();
			bear.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}

class Eat implements Runnable {
	int count = 1;
	String name;

	public Eat(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		while (count <= 10) {
			System.out.println(name + "吃第" + count + "碗飯");
			if (count == 10) {
				System.out.println(name + "吃完了!");
			}
			count++;
			try {
				Thread.sleep((int) (Math.random() * (3000 - 499)) + 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class Bank {
	private int totalMoney = 0;
	public Bank() {
	}


	synchronized public void addMoney() {
		while (totalMoney <= 3000) {
			totalMoney += 2000;
			System.out.printf("媽媽存了2000，帳戶共有:%d\n", totalMoney);
		}
		System.out.println("媽媽看到餘額在3000以上，暫停匯款");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("媽媽被要求匯款!");
		notify();
	}

	synchronized public void removeMoney() {
		System.out.println("熊大被老媽告知帳戶已經有錢!");
		while (totalMoney >= 1000) {
			totalMoney -= 1000;
			System.out.println("熊大領了1000，帳戶共有:" + totalMoney);
		
			if (totalMoney <= 2000) {
			System.out.println("熊大看到餘額在2000以下，要求匯款");
			notify();
			}
		}

		if (totalMoney < 1000) {
			System.out.println("熊大看到帳戶沒錢，暫停提款");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}

class Mom extends Thread{
	Bank bank;
	public Mom(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run(){
		for (int i = 0; i < 10; i++) {
			bank.addMoney();
		}
	}
}

class Bear extends Thread{
	Bank bank;
	public Bear (Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		bank.removeMoney();
	}
}

