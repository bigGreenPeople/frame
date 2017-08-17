package com.fj.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDaoImp implements EmpDao {
	//×¢ÈëjdbcÄ£°å
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void outMoney(String from, int money) {
		// TODO Auto-generated method stub
		String sql = "UPDATE emp SET emp_sal=emp_sal-? WHERE emp_name=?;";
		jdbcTemplate.update(sql, money,from);
	}

	@Override
	public void inMoney(String to, int money) {
		// TODO Auto-generated method stub
		String sql = "UPDATE emp SET emp_sal=emp_sal+? WHERE emp_name=?;";
		jdbcTemplate.update(sql, money,to);
	}

}
