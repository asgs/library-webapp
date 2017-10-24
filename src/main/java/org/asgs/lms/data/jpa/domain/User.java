package org.asgs.lms.data.jpa.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
  // TODO - add necessary JPA annotations after finalizing the DB Schema.
  private String id;
  private String name;
  private String age;
  private Integer totalCountOfBooksEligibleToBorrow;
  private List<Book> booksBorrowed;
  private List<Book> booksOverdueForReturn;
}
