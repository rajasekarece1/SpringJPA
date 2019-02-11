package com.springdata.springJPA.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springdata.springJPA.models.Book;
import com.springdata.springJPA.repository.BookRepository;


public class BookServiceImplementation implements BookService{

	@Autowired BookRepository bookdao;
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.save(book);
	}

}
