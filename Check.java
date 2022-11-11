package qlkh;

import java.util.Scanner;

public class Check {
	Scanner sc = new Scanner(System.in);

	public String checkString() {
		String input;
		while (true) {
			input = sc.nextLine();
			input = input.trim();
			if (input != null)
				return input;
			else
				System.out.println("Vui long nhap thong tin: ");
		}
	}

	public long checkLong() {
		long input;
		while (true) {
			try {
				input = Integer.parseInt(sc.nextLine());
				return input;
			} catch (Exception e) {
				System.out.println("Kieu du lieu khong dung! Nhap lai: ");
			}
		}
	}

	public double checkDouble() {
		double input;
		while (true) {
			try {
				input = Double.parseDouble(sc.nextLine());
				return input;
			} catch (Exception e) {
				System.out.println("Kieu du lieu khong dung! Nhap lai: ");
			}
		}
	}

	public String checkDate() {
		String date;
		while (true) {
			date = sc.nextLine();
			date = date.trim();
			if (date.charAt(2) == '/' && date.charAt(5) == '/')
				return date;
			else
				System.out.println("Khong dung dinh dang ngay! Nhap lai: ");
		}
	}

	public static void main(String[] args) {
		Check check = new Check();
		String date = check.checkDate();
		System.out.println(date);
	}
}
