package org.totoshop.service;

import java.util.List;

import org.totoshop.pojo.User;
import org.totoshop.pojo.Pager;

public interface UserService {
	Pager<User> findBySubList(User user, int pageSize, int currentPage);
	
	List<User> find();
	
	User findUser(String id, String password);
	
	boolean add(User user);
	
	boolean update(User user);
	
	boolean delete(String uid);
}
