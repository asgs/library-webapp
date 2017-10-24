package org.asgs.lms.data.jpa.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
  // TODO - add necessary JPA annotations after finalizing the DB Schema.
  private String id;
  private String name;
  private String author;
  private String edition;
  private Double price;
}
