package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookServiceImpl implements BookService {
  @Autowired BookRepository bookRepository;
  @Autowired BookUserRepository bookUserRepository;

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll(null).getContent();
  }

  @Override
  public List<Book> getAvailableBooks() {
    List<Book> allBooks = getAllBooks();

    List<String> availableBookIds =
        bookUserRepository
            .findByStatus('R', null)
            .getContent()
            .stream()
            .map(bookUser -> bookUser.getBookId())
            .collect(Collectors.toList());

    return allBooks
        .stream()
        .filter(book -> availableBookIds.contains(book.getId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Book> getTopBooks() {
    return null; // Need to write a custom query to find the top 10 books.
  }
}
