package com.application.modul3.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

public Book getBookById(Integer id) {
	Optional<Book> bookOpt = bookRepository.findById(id);
	if (bookOpt.isPresent()) {
		return bookOpt.get();
	}
	return null;
}

	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}
}
