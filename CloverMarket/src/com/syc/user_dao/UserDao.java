package com.syc.user_dao;

import com.syc.user_entity.User;

public interface UserDao {
	public void ins(User user);
	public void reg(Integer id,String username,String password);
}
