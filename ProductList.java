package qlkh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileWriter;
import javax.swing.border.TitledBorder;

import org.w3c.dom.css.CSSRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ProductList {
	private int size = 0;
	private static Product[] product;
	private String filePath = "products.txt";
	static Scanner sc = new Scanner(System.in);

	// ------Constructor------
	public ProductList(int size, Product[] product) {
		this.size = size;
		this.product = product;
	}

	public ProductList() throws IOException {
		// product = new Product[0];
		// readFromFile();
	}

	// -----Add product-----
	public void add(Product element) {
		this.size = product.length;
		product = Arrays.copyOf(product, product.length + 1);
		product[this.size] = element;
		this.size++;
	}

	// -----Delete product-----
	public int delete(Product element) {
		int check = -1;
		System.out.println("Nhap id san pham can xoa: ");
		String id = sc.nextLine();
		int index = findIndex(id);
		if (index == -1) {
			System.out.println("Khong co san pham trong danh sach");
			return check;
		}
		for (int i = this.product.length - 1; i > index; i--)
			this.product[i - 1] = this.product[i];
		this.size = this.product.length;
		this.product = Arrays.copyOf(this.product, this.product.length - 1);
		check = 0;
		return check;
	}

	// public int delete() {
	// int check = -1;
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return check;
	// }
	// System.out.println("-----XOA SAN PHAM-----");
	// System.out.println("Nhap id san pham muon xoa: ");
	// String id = sc.nextLine();
	// int index = findProduct3(id);
	//
	// if (index == -1) {
	// System.out.println("Khong co san pham trong danh sach.");
	// return check;
	// }
	//
	// for (int i = this.product.length - 1; i > index; i--)
	// this.product[i - 1] = this.product[i];
	// size = this.product.length;
	// this.product = Arrays.copyOf(this.product, this.product.length - 1);
	// check = 0;
	//
	// if (check == 0)
	// System.out.println("Xoa san pham thanh cong.");
	// else
	// System.out.println("Xoa san pham khong thanh cong!");
	//
	// return check;
	// }

	// -----Modify product-----
	public int modify(Product element) {
		int check = -1;
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return check;
		}
		System.out.println("Nhap id sp muon thay doi: ");
		String id = sc.nextLine();
		System.out.println("Nhap ten muon thay doi: ");
		String name = sc.nextLine();
		for (Product x : this.product)
			if (x.getId().equalsIgnoreCase(id)) {
				x.setName(name);
				check = 0;
			}
		return check;
	}

	public int modify() {
		int check = -1;
		int index = -1;
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return check;
		}

		System.out.println("Nhap id sp muon thay doi: ");
		String id = sc.nextLine();

		if (index == findIndex(id)) {
			System.out.println("Khong co san pham trong danh sach");
			return check;
		}

		System.out.println("Chon thong tin thay doi: ");
		System.out.println("(1) Ten : ");
		System.out.println("(2) Phan loai: ");
		System.out.println("(3) Thuong hieu: ");
		System.out.println("(4) Ngay san xuat: ");
		System.out.println("(5) Don vi tinh: ");
		System.out.println("(6) So luong tong: ");
		System.out.println("(7) Gia thanh: ");
		String choice = sc.nextLine();
		switch (Integer.parseInt(choice)) {
			case 1: {
				System.out.println("Nhap ten muon thay doi: ");
				String name = sc.nextLine();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setName(name);
						check = 0;
					}
				break;
			}
			case 2: {
				System.out.println("Nhap phan loai muon thay doi: ");
				String type = sc.nextLine();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setType(type);
						check = 0;
					}
				break;
			}
			case 3: {
				System.out.println("Nhap thuong hieu muon thay doi: ");
				String brand = sc.nextLine();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setBrand(brand);
						check = 0;
					}
				break;
			}
			case 4: {
				System.out.println("Nhap ngay(dd/mm/yyyy) san xuat muon thay doi: ");
				String date = sc.nextLine();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setManufacturingDate(date);
						check = 0;
					}
				break;
			}
			case 5: {
				System.out.println("Nhap don vi tinh muon thay doi: ");
				String unit = sc.nextLine();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setUnit(unit);
						check = 0;
					}
				break;
			}
			case 6: {
				System.out.println("Nhap so luong muon thay doi: ");
				int amount = sc.nextInt();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setAmount(amount);
						check = 0;
					}
				break;
			}
			case 7: {
				System.out.println("Nhap gia muon thay doi: ");
				double price = sc.nextDouble();
				for (Product x : this.product)
					if (x.getId().equalsIgnoreCase(id)) {
						x.setPrice(price);
						check = 0;
					}
				break;
			}
			default:
				System.out.println("Khong hop le!");
		}

		if (check == 0)
			System.out.println("Thay doi thanh cong.");
		else
			System.out.println("Thay doi khong thanh cong");

		return check;
	}

	// -----Find product: console-----
	public void findProduct1() {
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return;
		}

		System.out.println("Nhap id san pham can tim: ");
		String id = sc.nextLine();
		for (Product x : this.product)
			if (x.getId().equalsIgnoreCase(id))
				x.display();
	}

	// -----Find product: console-----
	public Product findProduct2() {
		Product temp = null;
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return null;
		}

		System.out.println("Nhap id san pham can tim: ");
		String id = sc.nextLine();
		for (Product x : this.product)
			if (x.getId().equalsIgnoreCase(id))
				temp = x;
		return temp;
	}

	// -----Find product: index-----
	public int findIndex(String id) {
		int index = -1;
		for (int i = 0; i < this.product.length; i++)
			if (this.product[i].getId().equalsIgnoreCase(id)) {
				index = i;
			}
		return index;
	}

	// -----Sort by ID-----
	public void sort() {
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return;
		}

		Arrays.sort(product);
		for (Product x : this.product)
			x.display();
	}

	// ---Hien thi danh sach san pham--------------------------------------------
	// (DONE)
	// public void showList() {
	// System.out.println("---XEM SAN PHAM---");
	// System.out.println("(1) Tat ca cac san pham");
	// System.out.println("(2) Loc theo id");
	// System.out.println("(3) Loc theo ten");
	// System.out.println("(4) Loc theo phan loai");
	// System.out.println("(5) Loc theo thuong hieu");
	// System.out.println("(6) Loc theo ngay san xuat(dd/mm/yyyy)");
	// System.out.println("(7) Loc theo don vi tinh");
	// System.out.println("(8) Loc theo so luong");
	// System.out.println("(9) Loc theo gia");
	// System.out.println("(10) Thoat");
	// System.out.print("Vui long nhap 1 so (0->9): ");
	// String choice = sc.nextLine();
	// while (!isInteger(choice) || Integer.parseInt(choice) < 1 ||
	// Integer.parseInt(choice) > 10) {
	// System.out.println("Nhap sai! Vui long nhap lai 1 so (1->10)");
	// choice = sc.nextLine();
	// }
	// switch (Integer.parseInt(choice)) {
	// case 1: {
	// showAll();
	// break;
	// }
	// case 2: {
	// showById();
	// break;
	// }
	// case 3: {
	// showByName();
	// break;
	// }
	// case 4: {
	// showByType();
	// break;
	// }
	// case 5: {
	// showByBrand();
	// break;
	// }
	// case 6: {
	// showByDate();
	// break;
	// }
	// case 7: {
	// showByUnit();
	// break;
	// }
	// case 8: {
	// showByAmount();
	// break;
	// }
	// case 9: {
	// showByPrice();
	// break;
	// }
	// default:
	// System.out.println("Thoat!");
	// System.exit(0);
	// }
	// }

	// -----Show product: console-----
	public void showAll() {
		if (this.product.length == 0) {
			System.out.println("Khong co san pham nao trong danh sach");
			return;
		}

		for (int i = 0; i < product.length; i++)
			product[i].display();
		// for (Product x : this.product)
		// x.display();
	}

	// public void showById() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap id san pham: ");
	// String id = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getId().equalsIgnoreCase(id))
	// x.display();
	// }
	//
	// public void showByName() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap ten san pham: ");
	// String name = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getName().equalsIgnoreCase(name))
	// x.display();
	// }
	//
	// public void showByType() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap phan loai san san pham: ");
	// String type = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getType().equalsIgnoreCase(type))
	// x.display();
	// }
	//
	// public void showByBrand() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap thuong hieu san pham: ");
	// String brand = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getBrand().equalsIgnoreCase(brand))
	// x.display();
	// }
	//
	// public void showByDate() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap ngay(dd/mm/yyyy) san pham: ");
	// String date = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getManufacturingDate().equalsIgnoreCase(date))
	// x.display();
	// }
	//
	// public void showByUnit() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap don vi tinh san pham: ");
	// String unit = sc.nextLine();
	//
	// for (Product x : this.product)
	// if (x.getUnit().equalsIgnoreCase(unit))
	// x.display();
	// }
	//
	// public void showByAmount() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap so luong san pham: ");
	// double amount = sc.nextDouble();
	//
	// for (Product x : this.product)
	// if (x.getAmount() == amount)
	// x.display();
	// }
	//
	// public void showByPrice() {
	// if (this.product.length == 0) {
	// System.out.println("Khong co san pham nao trong danh sach");
	// return;
	// }
	//
	// System.out.println("Nhap gia san pham: ");
	// double price = sc.nextDouble();
	//
	// for (Product x : this.product)
	// if (x.getPrice() == price)
	// x.display();
	// }

	// -----Write to file-----
	public boolean writeToFile() {
		// File outFile = null;
		// FileOutputStream out = null;
		// try {
		// outFile = new File(filePath);
		// out = new FileOutputStream(outFile);
		// // -----Generate file if does not exist-----
		// if (!outFile.exists())
		// outFile.createNewFile();

		// for (Product x : this.product) {
		// byte[] temp = x.toString().getBytes();
		// out.println(x.toString());
		// out.flush();
		// }
		// return true;
		// } catch (Exception e) {
		// return false;
		// } finally {
		// try {
		// if (out != null)
		// out.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		try {
			FileWriter myWriter = new FileWriter(filePath);
			for (int i = 0; i < product.length; i++)
				myWriter.write(product[i].toString() + "\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return true;
	}

	// Product [id=003, name=Dell Inspiron, type=LapTop, brand=Dell,
	// manufacturingDate=12/10/2003, unit=Cai, amount=12, price=12.0,
	// graphics=Nvidia, cpu=Intel, sizeMemory=256gb, color=Trang, sizeScreen=13.3,
	// weight=2.0]

	public static String cutString(String str, String beginString, String endString) {
		int beginIndex = str.indexOf(beginString) + beginString.length();
		int endIndex = str.indexOf(endString, beginIndex);
		return str.substring(beginIndex, endIndex);
	}

	public Product dataToObject(String data) {
		Product newProduct = null;
		switch (cutString(data, "type=", ",")) {
			case "LapTop" -> {
				newProduct = new Laptop();
				newProduct.setId(cutString(data, "id=", ","));
				newProduct.setName(cutString(data, "name=", ","));
				newProduct.setType(cutString(data, "type=", ","));
				newProduct.setBrand(cutString(data, "brand=", ","));
				newProduct.setManufacturingDate(cutString(data, "manufacturingDate=", ","));
				newProduct.setUnit(cutString(data, "unit=", ","));
				newProduct.setAmount(Long.parseLong(cutString(data, "amount=", ",")));
				newProduct.setPrice(Double.parseDouble(cutString(data, "price=", ",")));
				Details newDetails = new Details();
				newDetails.setGraphics(cutString(data, "graphics=", ","));
				newDetails.setCpu(cutString(data, "cpu=", ","));
				newDetails.setSizeMemory(cutString(data, "sizeMemory=", ","));
				newDetails.setColor(cutString(data, "color=", ","));
				newDetails.setSizeScreen(Double.parseDouble(cutString(data, "sizeScreen=", ",")));
				newDetails.setWeight(Double.parseDouble(cutString(data, "weight=", "]")));
				((Laptop) newProduct).setDetail(newDetails);
			}
			case "SmartPhone" -> {
				newProduct = new SmartPhone();
				newProduct.setId(cutString(data, "id=", ","));
				newProduct.setName(cutString(data, "name=", ","));
				newProduct.setType(cutString(data, "type=", ","));
				newProduct.setBrand(cutString(data, "brand=", ","));
				newProduct.setManufacturingDate(cutString(data, "manufacturingDate=", ","));
				newProduct.setUnit(cutString(data, "unit=", ","));
				newProduct.setAmount(Long.parseLong(cutString(data, "amount=", ",")));
				newProduct.setPrice(Double.parseDouble(cutString(data, "price=", ",")));
				newProduct.setPrice(Double.parseDouble(cutString(data, "price=", ",")));
				Details newDetails = new Details();
				newDetails.setGraphics(cutString(data, "graphics=", ","));
				newDetails.setCpu(cutString(data, "cpu=", ","));
				newDetails.setSizeMemory(cutString(data, "sizeMemory=", ","));
				newDetails.setColor(cutString(data, "color=", ","));
				newDetails.setSizeScreen(Double.parseDouble(cutString(data, "sizeScreen=", ",")));
				newDetails.setWeight(Double.parseDouble(cutString(data, "weight=", "]")));
				((SmartPhone) newProduct).setDetail(newDetails);
			}
			case "SmartWatch" -> {
				newProduct = new SmartWatch();
				newProduct.setId(cutString(data, "id=", ","));
				newProduct.setName(cutString(data, "name=", ","));
				newProduct.setType(cutString(data, "type=", ","));
				newProduct.setBrand(cutString(data, "brand=", ","));
				newProduct.setManufacturingDate(cutString(data, "manufacturingDate=", ","));
				newProduct.setUnit(cutString(data, "unit=", ","));
				newProduct.setAmount(Long.parseLong(cutString(data, "amount=", ",")));
				newProduct.setPrice(Double.parseDouble(cutString(data, "price=", ",")));
				Details newDetails = new Details();
				newDetails.setGraphics(cutString(data, "graphics=", ","));
				newDetails.setCpu(cutString(data, "cpu=", ","));
				newDetails.setSizeMemory(cutString(data, "sizeMemory=", ","));
				newDetails.setColor(cutString(data, "color=", ","));
				newDetails.setSizeScreen(Double.parseDouble(cutString(data, "sizeScreen=", ",")));
				newDetails.setWeight(Double.parseDouble(cutString(data, "weight=", "]")));
				((SmartWatch) newProduct).setDetail(newDetails);
			}
		}
		return newProduct;
	}

	public boolean readFromFile() throws IOException {
		ProductList ob = new ProductList();
		try {
			File myObj = new File(filePath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				ob.add(ob.dataToObject(data));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// Default productsw
		ProductList ob = new ProductList();
		product = new Product[0];
		// product[0] = new Laptop("002", "Dell Inspiron", "Dell", "12/10/2003", "Cai",
		// 12, 12.000, "Nvidia",
		// "Intel", "256gb", "Trang", 13.3, 2);
		// product[1] = new SmartWatch("001", "Dell Inspiron", "Dell", "12/10/2003",
		// "Cai", 12, 12.000, "Nvidia",
		// "Intel", "256gb", "Trang", 13.3, 2);
		// product[2] = new SmartPhone("004", "Dell Inspiron", "Dell", "12/10/2003",
		// "Cai", 12, 12.000, "Nvidia",
		// "Intel", "256gb", "Trang", 13.3, 2);
		// product[3] = new Laptop("003", "Dell Inspiron", "Dell", "12/10/2003", "Cai",
		// 12, 12.000, "Nvidia",
		// "Intel", "256gb", "Trang", 13.3, 2);
		ob.readFromFile();
		ob.showAll();
		// System.out.println(ob.writeToFile());
		// ob.readFromFile();
	}

	// --Private-method-function-----------------------------------------------------
	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// --Get-Set---------------------------------------------------------------------
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}

}
