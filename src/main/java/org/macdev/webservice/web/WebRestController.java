package org.macdev.webservice.web;

import java.util.ArrayList;
import java.util.List;

import org.macdev.webservice.dao.UserDao;
import org.macdev.webservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebRestController.class);

	@Autowired
	UserDao userDao;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World spring boot !!";
	}

	@GetMapping("/home")
	public User home() {
		User user = new User("john");
		return user;
	}
	
	@RequestMapping("/add")
	public User add(User hello) {

		User helloData = userDao.save(hello);

		return helloData;
	}

	@GetMapping("/list")
	public List<User> list(Model model) {

		List<User> helloList = new ArrayList<User>();
		userDao.findAll().forEach(user -> {
			logger.info(user.toString());
			helloList.add(user);
		});

		logger.info(helloList.toString());
		return helloList;
	}

}