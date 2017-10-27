package org.asgs.lms.data.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
  @Id private String id;
  private String name;

  private String age;

  @Column(name = "max_book_borrow_count")
  private Integer totalCountOfBooksEligibleToBorrow;

  @Transient private List<Book> booksBorrowed;
  @Transient private List<Book> booksOverdueForReturn;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAge() {
    return age;
  }

  public Integer getTotalCountOfBooksEligibleToBorrow() {
    return totalCountOfBooksEligibleToBorrow;
  }

  public List<Book> getBooksBorrowed() {
    return booksBorrowed;
  }

  public void setBooksBorrowed(List<Book> booksBorrowed) {
    this.booksBorrowed = booksBorrowed;
  }

  public List<Book> getBooksOverdueForReturn() {
    return booksOverdueForReturn;
  }

  public void setBooksOverdueForReturn(List<Book> booksOverdueForReturn) {
    this.booksOverdueForReturn = booksOverdueForReturn;
  }
}
