package ru.udm.pfr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.udm.pfr.models.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public List<User> findByName(String name);
}
