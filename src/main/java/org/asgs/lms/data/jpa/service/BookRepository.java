package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book, Long> {
    Page<Book> findAll(Pageable pageable);

    Book findById(String userId);

    Page<Book> findByName(String name, Pageable pageable);
}
