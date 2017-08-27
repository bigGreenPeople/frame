package com.fj.mapper;

import java.util.List;

import com.fj.po.QueryVo;
import com.fj.po.User;

public interface UserMapper {
	//查询用户列表
	public List<User> findUserList(User user);
	//查询在list里面的id
	public List<User> findUserListId(QueryVo queryVo);
}
