package com.ortega.springguru.repositories;

import com.ortega.springguru.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
