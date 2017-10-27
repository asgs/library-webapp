package org.asgs.lms.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {
  @Id private String id;
  private String name;
  private String author;
  private String edition;
  private Double price;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  public String getEdition() {
    return edition;
  }

  public Double getPrice() {
    return price;
  }
}
