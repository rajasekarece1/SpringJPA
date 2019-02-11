package com.springdata.springJPA.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Books")
public class Book {
	@Id
	@Column(name="book_id")
	long BookId;
	
	@Column(name="book_title")
	String title;
	
	@Column(name="book_price")
	double price;
	
	@Column(name="book_vol")
	int volume;
	
	@Temporal(TemporalType.DATE)
	@Type(type="Date")
	@Column(name="book_pub_date")
	Date PublishDate;

	public Book() {
		super();
	}

	public Book(long bookId, String title, double price, int volume, Date publishDate) {
		super();
		BookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		PublishDate = publishDate;
	}

	public long getBookId() {
		return BookId;
	}

	public void setBookId(long bookId) {
		BookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", PublishDate=" + PublishDate + "]";
	}
	
	
	
	
	
}
