package com.application.modul3.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "administration")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private int year;

	@Column(name = "isbn")
	private String isbn;

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected int getYear() {
		return year;
	}

	protected void setYear(int year) {
		this.year = year;
	}

	protected String getIsbn() {
		return isbn;
	}

	protected void setIbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
