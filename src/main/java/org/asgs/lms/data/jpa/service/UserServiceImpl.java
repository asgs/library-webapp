package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.BookUser;
import org.asgs.lms.data.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
  @Autowired UserRepository userRepository;
  @Autowired BookRepository bookRepository;
  @Autowired BookUserRepository bookUserRepository;

  public List<User> getAllUsers() {
    List<User> users = userRepository.findAll(null).getContent();
    for (User user : users) {
      List<BookUser> bookUsers = bookUserRepository.findByUserId(user.getId(), null).getContent();
      System.out.println("BookUser size is " + bookUsers.size());

      List<Book> books =
          bookUsers
              .stream()
              .map(bookUser -> findBookUsingBookUser(bookUser))
              .collect(Collectors.toList());
      System.out.println("Book size is " + books.size());
      user.setBooksBorrowed(books);

      List<BookUser> bookUsersDefaulted =
          bookUserRepository.findByUserIdAndStatus(user.getId(), 'B', null).getContent();
      books =
          bookUsersDefaulted
              .stream()
              .map(bookUser -> findBookUsingBookUser(bookUser))
              .collect(Collectors.toList());
      user.setBooksOverdueForReturn(books);
    }
    return users;
  }

  public List<User> getTopUsers() {
    return null; // Need to write a custom query to find the top 10 users.
  }

  private Book findBookUsingBookUser(BookUser bookUser) {
    return bookRepository.findById(bookUser.getBookId());
  }
}
