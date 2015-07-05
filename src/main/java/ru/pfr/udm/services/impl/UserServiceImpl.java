/**
 * 
 */
package ru.pfr.udm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.pfr.udm.services.UserService;
import ru.udm.pfr.dao.UserDao;
import ru.udm.pfr.models.User;

/**
 * @author wonderkot
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	@Override
	public List<User> findAll() {
		List<User> users = null;
		//userDao.findAll();
		return users;
	}
	
	public void msg() {
		System.out.println("test");
	}

}
