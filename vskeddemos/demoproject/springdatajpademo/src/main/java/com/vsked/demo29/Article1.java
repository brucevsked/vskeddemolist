package com.vsked.demo29;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "article1")
@Entity
public class Article1 implements Serializable {

	private static final long serialVersionUID = 7063500554305540082L;
	@Id
    private Long id;
    private String title;
    private String author;
    private Integer price;
    private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Article1() {
	}
	
	public Article1(Long id, String title, String author, Integer price, String content) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", content="
				+ content + "]";
	}

}
