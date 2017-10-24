package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.Book;
import org.asgs.lms.data.jpa.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class LmsController {

  @RequestMapping("/books")
  @Transactional(readOnly = true)
  public List<Book> getBooks() {
    return null; // TODO - Implement a service and call it.
  }

  @RequestMapping("/users")
  @Transactional(readOnly = true)
  public List<User> getUsers() {
    return null; // TODO - Implement a service and call it.
  }
}
