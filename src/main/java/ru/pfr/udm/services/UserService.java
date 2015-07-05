package ru.pfr.udm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.udm.pfr.models.User;

public interface UserService {
	public List<User> findAll();
}
