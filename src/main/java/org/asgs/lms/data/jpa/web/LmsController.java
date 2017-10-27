package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.BookUser;
import org.asgs.lms.data.jpa.domain.User;
import org.asgs.lms.data.jpa.service.BookRepository;
import org.asgs.lms.data.jpa.service.BookUserRepository;
import org.asgs.lms.data.jpa.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class LmsController {

  @Autowired UserRepository userRepository;
  @Autowired BookRepository bookRepository;
  @Autowired BookUserRepository bookUserRepository;

  @RequestMapping("/books")
  @Transactional(readOnly = true)
  public List<Book> getBooks() {
    return bookRepository.findAll(null).getContent();
  }

  @RequestMapping("/users")
  @Transactional(readOnly = true)
  public List<User> getUsers() {
    List<User> users = userRepository.findAll(null).getContent();
    for (User user : users) {
      List<BookUser> bookUsers = bookUserRepository.findByUserId(user.getId(), null).getContent();
      System.out.println("BookUser size is " + bookUsers.size());

      List<Book> books =
          bookUsers.stream().map(bookUser -> findBookById(bookUser)).collect(Collectors.toList());
      System.out.println("Book size is " + books.size());
      user.setBooksBorrowed(books);

      /*user.setBooksBorrowed(
      bookUserRepository
          .findByIdAndStatus(new BookUserKey(user.getId(), null), 'B', null)
          .getContent()
          .toArray(new Book[users.size()]));*/
    }
    return users;
  }

  private Book findBookById(BookUser bookUser) {
    return bookRepository.findById(bookUser.getBookId());
  }
}
