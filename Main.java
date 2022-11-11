package qlkh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		Product p1 = new Laptop();
		Product p2 = new SmartPhone();
		Product p3 = new SmartWatch();
		ProductList products = new ProductList();

//		products.add(p1);
//		products.add(p2);
//		products.add(p3);
		
		ReadFromFile r = new ReadFromFile();
		WriteToFile w = new WriteToFile();

//		ProductList[] products = new ProductList[4];
//		Product product1 = new Laptop("002", "Dell Inspiron", "Dell", "12/10/2003", "Cai", 12, 12.000, "Nvidia",
//				"Intel", "256gb", "Trang", 13.3, 2);
//		Product product2 = new SmartWatch("001", "Dell Inspiron", "Dell", "12/10/2003", "Cai", 12, 12.000, "Nvidia",
//				"Intel", "256gb", "Trang", 13.3, 2);
//		Product product3 = new SmartPhone("004", "Dell Inspiron", "Dell", "12/10/2003", "Cai", 12, 12.000, "Nvidia",
//				"Intel", "256gb", "Trang", 13.3, 2);
//		Product product4 = new Laptop("003", "Dell Inspiron", "Dell", "12/10/2003", "Cai", 12, 12.000, "Nvidia",
//				"Intel", "256gb", "Trang", 13.3, 2);
//		Product productTitle = new Product();
//		Details detailsTitle = new Details();
//
//		products[0] = new ProductList();
//		products[0].add(product1);
//		products[1] = new ProductList();
//		products[1].add(product2);
//		products[2] = new ProductList();
//		products[2].add(product3);
//		products[3] = new ProductList();
//		products[3].add(product4);
//
//		try {
//			// WriteFile
//			FileOutputStream outFile = new FileOutputStream(new File("products.txt"));
//			ObjectOutputStream out = new ObjectOutputStream(outFile);
//
//			productTitle.title();
//			detailsTitle.title();
//			out.writeObject(products[0]);
//			out.writeObject(products[1]);
//			out.writeObject(products[2]);
//			out.writeObject(products[3]);
//
//			out.close();
//			outFile.close();
//
//			// ReadFile
//			FileInputStream inFile = new FileInputStream(new File("products.txt"));
//			ObjectInputStream in = new ObjectInputStream(inFile);
//
//			ProductList p1 = (ProductList) in.readObject();
//			ProductList p2 = (ProductList) in.readObject();
//			ProductList p3 = (ProductList) in.readObject();
//			ProductList p4 = (ProductList) in.readObject();
//
//			p1.showAll();
//			p2.showAll();
//			p3.showAll();
//			p4.showAll();
//
//			in.close();
//			inFile.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File is not found!");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream!");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
