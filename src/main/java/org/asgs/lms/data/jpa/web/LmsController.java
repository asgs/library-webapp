package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.User;
import org.asgs.lms.data.jpa.service.BookService;
import org.asgs.lms.data.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class LmsController {

  @Autowired UserService userService;

  @Autowired BookService bookService;

  @RequestMapping("/books")
  @Transactional(readOnly = true)
  public List<Book> getBooks() {
    return bookService.getAllBooks();
  }

  @RequestMapping("/users")
  @Transactional(readOnly = true)
  public List<User> getUsers() {
    return userService.getAllUsers();
  }
}
