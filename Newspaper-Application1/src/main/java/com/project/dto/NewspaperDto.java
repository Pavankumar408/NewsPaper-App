package com.project.dto;

public class NewspaperDto {
	private String newspapername;
	private double price;
	private String language;
	private int noofpages;
	public NewspaperDto() {
		// TODO Auto-generated constructor stub
	}
	public NewspaperDto(String newspapername, double price, String language, int noofpages) {
		super();
		this.newspapername = newspapername;
		this.price = price;
		this.language = language;
		this.noofpages = noofpages;
	}
	public String getNewspapername() {
		return newspapername;
	}
	public void setNewspapername(String newspapername) {
		this.newspapername = newspapername;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNoofpages() {
		return noofpages;
	}
	public void setNoofpages(int noofpages) {
		this.noofpages = noofpages;
	}
	@Override
	public String toString() {
		return "NewspaperDto [newspapername=" + newspapername + ", price=" + price + ", language=" + language
				+ ", noofpages=" + noofpages + "]";
	}
	
	

}
