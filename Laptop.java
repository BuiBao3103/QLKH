package qlkh;

import java.util.Scanner;

import org.w3c.dom.html.HTMLTitleElement;

public class Laptop extends Product {
	private Details detail;

	public Laptop(String id, String name, String brand, String manufacturingDate, String unit, long amount,
			double price, String graphics, String cpu, String sizeMemory, String color, double sizeScreen,
			double weight) {
		this.id = id;
		this.name = name;
		this.type = "LapTop";
		this.brand = brand;
		this.manufacturingDate = manufacturingDate;
		this.unit = unit;
		this.amount = amount;
		this.price = price;
		this.detail = new Details(graphics, cpu, sizeMemory, color, sizeScreen, weight);
	}

	public Laptop() {
	}

	public int enter() {
		super.enter();
		detail.enter();
		return 0;
	}

	public void title() {
		super.title();
		detail.title();
	}

	@Override
	public String toString() {
		return super.toString() + detail.toString();
	}

	public void display() {
		super.display();
		detail.display();
	}

	public Details getDetail() {
		return detail;
	}

	public void setDetail(Details detail) {
		this.detail = detail;
	}
}
