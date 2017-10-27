package org.asgs.lms.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "book_users")
public class BookUser implements Serializable {
  @EmbeddedId private BookUserKey id;

  @Column(name = "book_id", insertable = false, updatable = false)
  private String bookId;

  @Column(name = "user_id", insertable = false, updatable = false)
  private String userId;

  @Column(name = "borrowed_date")
  private Long borrowedDateInEpoch;

  @Column(name = "expiry_date")
  private Long expiryDateInEpoch;

  private Character status;

  public Long getBorrowedDateInEpoch() {
    return borrowedDateInEpoch;
  }

  public Long getExpiryDateInEpoch() {
    return expiryDateInEpoch;
  }

  public Character getStatus() {
    return status;
  }

  public String getBookId() {
    return bookId;
  }

  public String getUserId() {
    return userId;
  }

  public BookUserKey getId() {
    return id;
  }
}
