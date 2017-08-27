package com.fj.mapper;

import java.util.List;

import com.fj.po.QueryVo;
import com.fj.po.User;

public interface UserMapper {
	//id��ѯ
	public User findUserById(int id);
	//name��ѯ
	public List<User> findUserByUsername(String name);
	//ɾ��
	public void deleteUserById(int id);
	//����
	public void updateUser(User user);
	//��ѯ�û��б�
	public List<User> findUserList(QueryVo queryVo);
	//�õ��б�����
	public int findUserCount(User user);
}
