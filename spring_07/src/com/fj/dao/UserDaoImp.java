package com.fj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fj.domain.User;

/**
 * 这里为了方便我们直接在这里操作数据,而不是从service传递了
 * @author bigGreenPeople
 *
 */
public class UserDaoImp implements UserDao {
	
	//定义jdbc模板	使用注解的方式注入
	@Resource(name="jdbcTemplate")
	private JdbcTemplate JdbcTemplate;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?);";
		JdbcTemplate.update(sql, 7,"付静","man",22,456789123);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USER WHERE uname=?;";
		JdbcTemplate.update(sql, "付杰");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER SET uname=? WHERE uid=?;";
		JdbcTemplate.update(sql, "付杰",3);
	}

	@Override
	public void queryUser() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE uid=?";
		User user = JdbcTemplate.queryForObject(sql, new MyRowMapper(), 3);
		System.out.println(user);
	}

	@Override
	public void queryUserList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER";
		List<User> list = JdbcTemplate.query(sql, new MyRowMapper());
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	//写一个内部类
	class MyRowMapper implements RowMapper<User>{

		//这个方法实现我们的封装
		@Override
		public User mapRow(ResultSet rs, int num) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			
			user.setUid(rs.getInt("uid"));
			user.setUname(rs.getString("uname"));
			user.setUsex(rs.getString("usex"));
			user.setUage(rs.getInt("uage"));
			user.setUtel(rs.getString("utel"));
			
			return user;
		}
		
	}

}
