/**
 * 
 */
package ru.pfr.udm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.udm.pfr.dao.UserDao;
import ru.udm.pfr.models.User;

/**
 * @author wonderkot
 *
 */
@Controller
public class TestController {
	
	@Autowired
	UserDao dao;
	
	@RequestMapping(value="/test") 
	public void test()
	{
		for (User user : dao.findAll()) {
			System.out.println(user.getName());
		}
	}
}
