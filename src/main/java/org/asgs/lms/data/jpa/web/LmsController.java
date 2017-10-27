package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.User;
import org.asgs.lms.data.jpa.service.BookRepository;
import org.asgs.lms.data.jpa.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class LmsController {

  @Autowired UserRepository userRepository;
  @Autowired BookRepository bookRepository;

  @RequestMapping("/books")
  @Transactional(readOnly = true)
  public List<Book> getBooks() {
    return bookRepository.findAll(null).getContent();
  }

  @RequestMapping("/users")
  @Transactional(readOnly = true)
  public List<User> getUsers() {
    return userRepository.findAll(null).getContent();
  }
}
