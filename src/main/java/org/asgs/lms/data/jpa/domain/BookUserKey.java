package org.asgs.lms.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table(name = "book_users")
public class BookUserKey implements Serializable {
  @Column(name = "book_id")
  private String bookId;

  @Column(name = "user_id")
  private String userId;

  public BookUserKey() {}

  public BookUserKey(String bookId, String userId) {
    this.bookId = bookId;
    this.userId = userId;
  }

  public String getBookId() {
    return bookId;
  }

  public String getUserId() {
    return userId;
  }
}
