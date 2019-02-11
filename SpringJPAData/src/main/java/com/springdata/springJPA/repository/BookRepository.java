package com.springdata.springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.springJPA.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>  {

	public void addbook(Book book);
}
