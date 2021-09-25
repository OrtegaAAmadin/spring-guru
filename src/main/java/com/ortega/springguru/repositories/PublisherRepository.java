package com.ortega.springguru.repositories;

import com.ortega.springguru.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
