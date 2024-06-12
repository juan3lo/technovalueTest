package tech.devjc.api.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.devjc.api.prueba.entity.Book;
import tech.devjc.api.prueba.service.BookService;

/**
* @author juan3lo
* 
*/

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;	

	@GetMapping("/getBook")
	private List<Book> getBooks(){
		return bookService.findAll();
	}
	
	@GetMapping("/getBookById/{id}")
	private Optional<Book> getBooksById(@PathVariable Long id){
		return bookService.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	private void postBook(@PathVariable Long id) {
		
		bookService.deleteBook(id);
	}
	
	@PostMapping("/postBook")
	private ResponseEntity<Book> crearBook(@RequestBody Book book){
		
		  try {
			  Book nuevoBook = bookService.postBook(book);
	            return new ResponseEntity<>(nuevoBook, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		
	} 
	
	@PutMapping("/updateBook/{id}")
	private ResponseEntity<Book> updateProduct (@RequestBody Book book, @PathVariable Long id){
		Optional<Book> bookOptional = bookService.findById(id);
		
		 if (bookOptional.isPresent()) {
			 Book boookActualizado = bookOptional.get();
			 boookActualizado.setAuthor(book.getAuthor());
			 boookActualizado.setIsbn(book.getIsbn());
			 boookActualizado.setTittle(book.getTittle());
	            bookService.postBook(boookActualizado);
	            return new ResponseEntity<>(boookActualizado, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		
	}
	
	
}


