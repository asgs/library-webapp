package org.asgs.lms.data.jpa.service;

import org.asgs.lms.data.jpa.domain.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();

  List<User> getTopUsers();
}
