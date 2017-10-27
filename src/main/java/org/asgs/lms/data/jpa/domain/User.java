package org.asgs.lms.data.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
  @Id private String id;
  private String name;

  private String age;

  @Column(name = "max_book_borrow_count")
  private Integer totalCountOfBooksEligibleToBorrow;

  @Transient private Book[] booksBorrowed;
  @Transient private Book[] booksOverdueForReturn;

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

  public Book[] getBooksBorrowed() {
    return booksBorrowed;
  }

  public Book[] getBooksOverdueForReturn() {
    return booksOverdueForReturn;
  }

  public void setBooksBorrowed(Book[] booksBorrowed) {
    this.booksBorrowed = booksBorrowed;
  }

  public void setBooksOverdueForReturn(Book[] booksOverdueForReturn) {
    this.booksOverdueForReturn = booksOverdueForReturn;
  }
}
