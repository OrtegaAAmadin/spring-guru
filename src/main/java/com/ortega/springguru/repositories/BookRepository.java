package com.ortega.springguru.repositories;

import com.ortega.springguru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
