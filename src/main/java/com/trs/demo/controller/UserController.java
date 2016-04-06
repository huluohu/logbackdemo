package com.trs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trs.demo.data.domain.User;
import com.trs.demo.data.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/index")
	public String index() {
		log.info("this is logback info output test");
		return "hello world";
	}
	
	@RequestMapping(value = "/list")
	public List<User> list() {
		log.info("output all users");
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/add")
	public User add(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		User user = new User(username, username, password);
		return userRepository.save(user);
	}
	
	@RequestMapping(value = "/delete")
	public String delete(
			@RequestParam(value = "id") long id) {
		try {
			userRepository.delete(id);
		} catch (Exception e) {
			log.error("delete user is error:" + e.getMessage());
			return "delete false";
		}
		return "delete success";
	}
}
