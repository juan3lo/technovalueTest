package tech.devjc.api.prueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.devjc.api.prueba.entity.Book;

/**
* @author juan3lo
* 
*/

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}


