package com.ram.repository;

import com.ram.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rams0516
 *         Date: 4/17/2018
 *         Time: 2:38 PM
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}