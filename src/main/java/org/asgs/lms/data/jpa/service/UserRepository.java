package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
  Page<User> findAll(Pageable pageable);

  User findById(String userId);

  Page<User> findByName(String name, Pageable pageable);
}
