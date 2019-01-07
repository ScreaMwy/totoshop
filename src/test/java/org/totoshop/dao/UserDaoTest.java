package org.totoshop.dao;

import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.totoshop.pojo.User;
import org.totoshop.util.AnnotationParse;
import org.totoshop.util.annotation.Values;
import org.totoshop.aspect.SuperAspect;

public class UserDaoTest {
	private static final String[] BASE_PACKAGE = new String[] {"org.totoshop.config.context", "org.totoshop.config.context.mybatis", "org.totoshop.config.aspect"}; 
	
	private AnnotationConfigApplicationContext ac;
	private UserDao userDao;
	private List<User> userList;
	private User user;
	SuperAspect sa;

	@Before
	public void init() {
		ac = new AnnotationConfigApplicationContext(UserDaoTest.BASE_PACKAGE);
		userDao = (UserDao) ac.getBean("userDao");
		sa = ac.getBean(SuperAspect.class);
	}
	
	@Test
	public void testAop() {
		sa.beforeAdvice();
	}
	
	@Test
	@Ignore
	public void testFind() {
		userList = userDao.find();
		Assert.assertEquals(1, userList.size());
	}

	@Test
	@Ignore
	public void testFindById() {
		user = userDao.findById("1", "123456789");
		Assert.assertEquals("1", user.getuId());
	}

	@Test
	@Ignore
	public void testAdd() {
		user = new User();
		user.setuId("2");
		
		int effection = 0;
		effection = userDao.add(user);
		Assert.assertEquals(1, effection);
	}

	@Test
	@Ignore
	public void testUpdate() {
		user = new User();
		user.setuId("2");
		
		int effection = 0;
		effection = userDao.update(user);
		Assert.assertEquals(1, effection);
	}

	@Test
	@Ignore
	public void testDelete() {
		int effection = 0;
		effection = userDao.delete("2");
		Assert.assertEquals(1, effection);
	}

}
