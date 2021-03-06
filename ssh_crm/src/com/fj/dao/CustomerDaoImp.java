package com.fj.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.cglib.core.Transformer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.Customer;
import com.fj.domain.Dict;
import com.fj.domain.PageBean;
@SuppressWarnings("all")
public class CustomerDaoImp extends BaseDaoImp<Customer> implements CustomerDao {
	//多条件组合查询
	public List<Customer> findMoreCondition(Customer customer) {
		//定义好我们的hql语句
		/*String hql = "from Customer where 1=1";
		//p是我们所有条件的集合
		List<Object> p = new ArrayList<Object>();
		//p里面是存放我们的参数（也就是说customer属性有值就放入进去）
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			//连接hql语句
			hql+=" and custName=?";
			p.add(customer.getCustName());
		}
		if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())){
			//连接hql语句
			hql+=" and custLevel=?";
			p.add(customer.getCustLevel());
		}
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())){
			//连接hql语句
			hql+=" and custSource=?";
			p.add(customer.getCustSource());
		}
		System.out.println(hql);
		for (Object object : p) {
			System.out.print(object.toString()+"   ");
		}
		System.out.println();
		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());*/
		
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//添加好参数
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
		if(customer.getDict()!=null && !"0".equals(customer.getDict().getDid())){
			criteria.add(Restrictions.eq("dict.did", customer.getDict().getDid()));
		}
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())){
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		//交给模板去执行
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		
	}
	
	//根据来源统计查询
	//复杂的查询还是要使用到sql语句
	@Override
	public List<Map> findCountSource() {
		// TODO Auto-generated method stub
		//先得到session对象(默认就是与线程绑定的)
		Session session = this.getSessionFactory().getCurrentSession();
		//得到SQLQuery对象
		SQLQuery sQLQuery = session.createSQLQuery("SELECT COUNT(*) num,custSource FROM t_customer GROUP BY custSource");
		//设置SQLQuery返回的list里面对象类型
		//里面填写我们要转换成值(原来是数组)
		sQLQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sQLQuery.list();
		return list;
	}
	//根据等级统计
	@Override
	public List<Map> findCountLevel() {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		String sql = "SELECT t.num,t_dict.dname FROM t_dict,(SELECT COUNT(*) num,did FROM t_customer GROUP BY did) t WHERE t.did=t_dict.did";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		return sqlQuery.list();
	}
	
//	使用离线对象多条件组合查询
	public PageBean multiSelect(Integer currentPage, Customer customer) {
		//PageBean pageBean = 
		return null;
	}

	//分页列表
	@Override
	public List<Customer> listCustomerPage(int pageNow,int pageSize){
		// TODO Auto-generated method stub
		//这里我们使用离线查询
		//得到离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//得到分页后的
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, pageNow, pageSize);
		
		return list;
	}
	//得到记录
	@Override
	public int getCount(int currentPage) {
		// TODO Auto-generated method stub
		List<Long> list = (List<Long>) this.getHibernateTemplate().find("SELECT COUNT(*) FROM Customer");
		//如果不为空
		if(list.size()!=0 && list!=null){
			//返回我们的记录数
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//查找用户
	@Override
	public List<Customer> findCustomer(String custName) {
		// TODO Auto-generated method stub
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().
				find("from Customer where custName like ?", "%"+custName+"%");
		
		return list;
	}
	
	//所有的字典数据
	@Override
	public List<Dict> findAllDict() {
		// TODO Auto-generated method stub
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}
}
