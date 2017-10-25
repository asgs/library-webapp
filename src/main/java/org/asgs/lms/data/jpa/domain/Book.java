package org.asgs.lms.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
  // TODO - add necessary JPA annotations after finalizing the DB Schema.
  @Id private String id;
  private String name;
  private String author;
  private String edition;
  private Double price;
}
