package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.BookUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface BookUserRepository extends Repository<BookUser, Long> {
  Page<BookUser> findAll(Pageable pageable);

  Page<BookUser> findByUserId(String userId, Pageable pageable);

  Page<BookUser> findByStatus(Character status, Pageable pageable);

  Page<BookUser> findByUserIdAndStatus(String userId, Character status, Pageable pageable);
}
