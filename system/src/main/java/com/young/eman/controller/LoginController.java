package com.young.eman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.young.eman.model.User;
import com.young.eman.service.LoginService;
@RestController
@RequestMapping("/system")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping("/login")
	public void login(String loginName, String password){
		User user = loginService.login(loginName, password);
		System.out.println(user.getLoginName()+"------"+user.getPassword());
	}
}
