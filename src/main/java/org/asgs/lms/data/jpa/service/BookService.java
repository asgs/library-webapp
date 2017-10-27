package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.Book;

import java.util.List;

public interface BookService {
  List<Book> getAllBooks();

  List<Book> getAvailableBooks();

  List<Book> getTopBooks();
}
