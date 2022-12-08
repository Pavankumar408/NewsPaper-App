package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="newspaperdetails")
@NamedQuery(name="NewspaperObject",query="from Newspaper where newspapername=:Newspapername")
@NamedQuery(name="NewspaperObject2",query="from Newspaper")
@NamedQuery(name="NewspaperObject3",query="from Newspaper where newspapername=:Newspapername")
public class Newspaper {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="abc")
	@GenericGenerator(name="abc",strategy="increment")
	private int id;
	@Column(name="Newspapername")
	private String newspapername;
	@Column(name="Price")
	private double price;
	@Column(name="Language")
	private String language;
	@Column(name="Noofpages")
	private int noofpages;
	public Newspaper() {
		// TODO Auto-generated constructor stub
	}
	public Newspaper(String newspapername, double price, String language, int noofpages) {
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
		return "Newspaper [newspapername=" + newspapername + ", price=" + price + ", language=" + language
				+ ", noofpages=" + noofpages + "]";
	}
	
}
