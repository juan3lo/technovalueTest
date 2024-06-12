package tech.devjc.api.prueba.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.devjc.api.prueba.entity.Book;
import tech.devjc.api.prueba.repository.BookRepository;

/**
* @author juan3lo
* 
*/

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	public List<Book> findAll() {

		return  bookRepository.findAll();
	}
	
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}
	
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book postBook(Book book) {
		return bookRepository.save(book);
	}
	

}


