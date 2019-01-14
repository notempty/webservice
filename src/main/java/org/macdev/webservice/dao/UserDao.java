package org.macdev.webservice.dao;

import java.util.List;

import org.macdev.webservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

	List<User> findByName(String name);
}
