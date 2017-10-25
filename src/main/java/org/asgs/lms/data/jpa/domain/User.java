package org.asgs.lms.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
  // TODO - add necessary JPA annotations after finalizing the DB Schema.
  @Id
  private String id;
  private String name;
  private String age;
  private Integer totalCountOfBooksEligibleToBorrow;
  private Book[] booksBorrowed;
  private Book[] booksOverdueForReturn;
}
