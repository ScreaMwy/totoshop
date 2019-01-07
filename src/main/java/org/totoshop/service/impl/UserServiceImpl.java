package org.totoshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import org.totoshop.service.UserService;
import org.totoshop.dao.UserDao;
import org.totoshop.pojo.User;
import org.totoshop.pojo.Pager;

@Service("userService")
@Scope(scopeName = "singleton")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao", type = UserDao.class)
	private UserDao userDao;
	
	private List<User> userList;
	
	private Pager<User> userPager;
	
	private int result;
	
	public UserServiceImpl() {}

	@Transactional(transactionManager = "transactionManagement")
	@Override
	public Pager<User> findBySubList(User user, int pageSize, int currentPage) {
		userList = find();
		userPager = new Pager<User>(pageSize, currentPage, userList);
		return userPager;
	}
	 
	@Transactional(transactionManager = "transactionManagement")
	@Override
	public List<User> find() {
		userList = userDao.find();
		return (userList.size() > 0) ? userList : null;
	}

	@Transactional(transactionManager = "transactionManagement")
	@Override
	public User findUser(String id, String password) {
		User user = userDao.findById(id, password);
		return (null != user) ? user : null;
	}

	@Transactional(transactionManager = "transactionManagement")
	@Override
	public boolean add(User user) {
		result = userDao.add(user);
		return (result > 0) ? true : false;
	}

	@Transactional(transactionManager = "transactionManagement")
	@Override
	public boolean update(User user) {
		result = userDao.update(user); 
		return (result > 0) ? true : false;
	}

	@Transactional(transactionManager = "transactionManagement")
	@Override
	public boolean delete(String id) {
		result = userDao.delete(id);
		return (result > 0) ? true : false;
	}
}
