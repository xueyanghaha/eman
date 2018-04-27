package com.young.eman.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 4127951884486613902L;
	
	private Long id;

	/**
	 * 真实姓名
	 */
	private String userName;

	/**
	 * 登录名称
	 */
	private String loginName;

	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 邮件
	 */
	private String mail;
	/**
	 * 电话号码
	 */
	private String telephone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
