package cn.my12306.dao;

import java.util.ArrayList;

import cn.my12306.bean.User;

public interface UserDao {
	
	int add(User user);
	int update(User user);
	
	User getUser(String name,String pwd);
	User getUser(int id);
	ArrayList<User> getUsers();
 }
