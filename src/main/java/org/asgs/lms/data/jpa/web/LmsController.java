package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.User;
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

  @Autowired UserRepository repository;

  @RequestMapping("/books")
  @Transactional(readOnly = true)
  public List<Book> getBooks() {
    return null; // TODO - Implement a service and call it.
  }

  @RequestMapping("/users")
  @Transactional(readOnly = true)
  @ResponseBody
  public List<User> getUsers() {
    return repository.findAll(null).getContent();
  }
}
