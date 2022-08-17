package xxx;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Homework7 {
	public static void main(String[] args) {
		Homework7 hw7 = new Homework7();
//		hw7.readSampleTxt();
//		hw7.dataTxt();
//		hw7.copyFile(".\\Sample.txt", ".\\SampleCopy.txt");
//		hw7.dogCat();
		hw7.readObject();
		
	}

	public void readSampleTxt() {
		// 請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
		// Sample.txt檔案共有xxx個位元組 ,yyy個字元 , zzz列資料
		/* 建立File類別存路徑 接低階 接高階 程式是中文字 所以接Reader/writer類別 */

		try {
			File file = new File("Sample.txt");
			FileInputStream fin = new FileInputStream(file);
			FileReader frd = new FileReader(file);
			BufferedReader brd = new BufferedReader(frd);

			// count bytes inputstream read() +counter
			int countBytes = 0;
			while (fin.read() != -1) {
				countBytes++;
			}

			int countLines = 0;
			brd.mark(1000);
			while (brd.readLine() != null) {
				if (countLines == 0) {

				}
				countLines++;
			}
			brd.reset();
			int countChar3 = 0;
			while (brd.read() != -1) {
				if (countChar3 == 0) {

				}
				countChar3++;
			}
			brd.close();
			frd.close();
			fin.close();
			System.out.printf("Sample.txt檔案共有%d個位元組,%d個字元,%d列資料", countBytes, countChar3, countLines);

			// try other way
//		byte[] a = new byte[10];
//		int c = 0;
//		int countBytes2 = 0;
//
//		while ((c = fin.read(a)) != -1) {
//			countBytes2 += c;
//		}
//		System.out.println(countBytes2);

			// count char FileReader read() + counter
//		int countChar = 0; 
//		int countLine2 = 0;
//		int temp = 0; 
//		while ((temp = frd.read()) != -1) {
//			countChar++;
//			if(temp == 10) {
//				countLine2++;
//			}
//		}
//		System.out.println(countChar +" " + (countLine2 + 1));

//		int countChar2 = 0;
//		int a1 = 0; 
//		char[] charArr = new char[10];
//		while((a1 = frd.read(charArr)) != -1) {
//			countChar2 += a1;
//		}
//		System.out.println(countChar2);

			// count Lines 第二節水管要和第一節拿，所以不能frd讀完又讓brd讀 不然會讀不到 顯示0line
			// BufferedReader readline() + counter

		} catch (FileNotFoundException e) {
			System.out.println("FileFail");
		} catch (IOException eio) {
			System.out.println("IOFail");
			eio.printStackTrace();
		}

	}

	public void dataTxt() {
		// 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用append功能讓每次執行結果都能被保存起來)
		File dir = new File(".\\aaa\\bbb\\ccc");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			File data = new File(dir, "data.txt");
			FileWriter fw = new FileWriter(data, true);
			PrintWriter pw = new PrintWriter(fw);

			// way1
			for (int i = 0; i < 10; i++) {
				int num = (int) (Math.random() * 1000 + 1);
				pw.println(num);
			}
			pw.flush();

//			//way2
//			for(int i = 0; i < 10; i++) {
//			String num = Integer.toString((int)(Math.random()*1000+1));
//			char[] arr = num.toCharArray();
//			char ln = 10;
//			fw.write(arr);
//			fw.write(ln);
//			}
//			fw.flush();

			pw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileOrigin, String fileCopy) {
		// 請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所代表的檔案會複製到第二個參數代表的檔案
		File fileIn = new File(fileOrigin);
		File fileOut = new File(fileCopy);
		try (FileReader frd = new FileReader(fileIn);
				BufferedReader brd = new BufferedReader(frd);
				FileWriter fwt = new FileWriter(fileOut);
				PrintWriter pwt = new PrintWriter(fwt);) {
			String str;
			while ((str = brd.readLine()) != null) {
				pwt.println(str);
			}
			pwt.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void dogCat() {
		//請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。
		//注	意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾
		Object[] array = { new Cat("white cat"), new Cat("black cat"), new Dog("flower dog"), new Dog("little dog")};
		File dir = new File("C:\\data");
		boolean b = dir.exists()? true : dir.mkdir();
		File file = new File(dir, "Object.ser");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for (int i = 0; i < array.length; i++) {
				oos.writeObject(array[i]);
			}
			oos.flush();
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readObject() {
		//承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 (請利用多型簡化本題的程式設計)
		File file = new File("C:\\data\\Object.ser");
		
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			try {
				while(true) {
					Animal obj = (Animal)ois.readObject();
					obj.speak();
				}	
			}catch (EOFException e){
				System.out.println("====end of file====");
			}
			
			
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
