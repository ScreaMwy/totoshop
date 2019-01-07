package org.totoshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;

import org.apache.ibatis.annotations.Param;

import org.totoshop.pojo.User;
import org.totoshop.pojo.Pager;

@Repository("userDao")
@Scope(scopeName = "singleton")
public interface UserDao {
	List<User> find();

	User findById(@Param("uId") String uId, @Param("uPassword") String uPassword);
	
	User findByName(@Param("uName") String uName, @Param("uPassword") String uPassword);

	int add(@Param("user") User user);

	int update(@Param("user") User user);

	int delete(@Param("uId") String uId);
}
