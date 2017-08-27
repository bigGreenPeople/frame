package com.fj.mapper;

import java.util.List;

import com.fj.po.QueryVo;
import com.fj.po.User;

public interface UserMapper {
	//id查询
	public User findUserById(int id);
	//name查询
	public List<User> findUserByUsername(String name);
	//删除
	public void deleteUserById(int id);
	//更新
	public void updateUser(User user);
	//查询用户列表
	public List<User> findUserList(QueryVo queryVo);
	//得到列表总数
	public int findUserCount(User user);
}
