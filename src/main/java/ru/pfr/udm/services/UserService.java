package ru.pfr.udm.services;

import java.util.List;

import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.User;

public interface UserService {
	public List<Mfc> getDistrict(User user);
}
