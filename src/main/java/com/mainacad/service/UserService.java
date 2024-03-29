package com.mainacad.service;

import com.mainacad.dao.UserDAO;
import com.mainacad.model.User;

public class UserService {

	public static User getByLoginAndPassword(String login, String password) {
		return UserDAO.getByLoginAndPassword(login, password);
	}
	
	public static User getById(Integer id) {
		return UserDAO.getById(id);
	}
	
	public static User save(User user) {
		return UserDAO.save(user);
	}
	
	public static User update(User user) {
		return UserDAO.update(user);
	}
	
	public static void delete(Integer id) {
		UserDAO.delete(id);
	}
}
