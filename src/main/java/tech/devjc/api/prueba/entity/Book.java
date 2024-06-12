package tech.devjc.api.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
* @author juan3lo
* 
*/


@Data
@Table(name="book")
@Entity
public class Book {
	
	@Id
	private int id;
	@Column(name = "tittle")
	private String tittle;
	@Column(name = "author")
	private String author;
	@Column(name = "isbn")
	private String isbn;

}


