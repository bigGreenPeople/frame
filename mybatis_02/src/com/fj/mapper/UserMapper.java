package com.fj.mapper;

import java.util.List;

import com.fj.po.QueryVo;
import com.fj.po.User;

public interface UserMapper {
	//��ѯ�û��б�
	public List<User> findUserList(User user);
	//��ѯ��list�����id
	public List<User> findUserListId(QueryVo queryVo);
}
