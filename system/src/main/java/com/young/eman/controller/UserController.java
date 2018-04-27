package com.young.eman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.young.eman.model.User;
import com.young.eman.service.UserService;

@RestController
@RequestMapping("/system/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdateUserInfo(User user){
		userService.saveOrUpdate(user);
	} 
}
