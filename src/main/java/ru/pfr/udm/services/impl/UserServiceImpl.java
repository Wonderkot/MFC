/**
 * 
 */
package ru.pfr.udm.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.pfr.udm.services.UserService;
import ru.udm.pfr.dao.UserDao;
import ru.udm.pfr.models.Mfc;
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
	public List<Mfc> getDistrict(User user) {
		List<User> users = userDao.findByName(user.getName());
		List<Mfc> mfcs = new ArrayList<>();
		for (User tempUser : users) {
			mfcs.add(tempUser.getMfc());
		}
		return mfcs;
	}
}
