package com.fj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.Customer;
import com.fj.domain.PageBean;
@SuppressWarnings("all")
public class CustomerDaoImp extends HibernateDaoSupport implements CustomerDao {
	//���ӿͻ�
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(customer);
	}
	//��ѯ���пͻ�
	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}
	//�޸Ŀͻ�
	@Override
	public void updCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(customer);
	}
	//ɾ���ͻ�
	@Override
	public void delCustomer(int cid) {
		// TODO Auto-generated method stub
		//�Ȳ�ѯ��ɾ��
		Customer customer = this.getHibernateTemplate().get(Customer.class, cid);
		this.getHibernateTemplate().delete(customer);
	}
	//��ҳ�б�
	@Override
	public List<Customer> listCustomerPage(int pageNow,int pageSize){
		// TODO Auto-generated method stub
		//��������ʹ�����߲�ѯ
		//�õ����߶���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//�õ���ҳ���
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, pageNow, pageSize);
		
		return list;
	}
	//�õ���¼
	@Override
	public int getCount(int currentPage) {
		// TODO Auto-generated method stub
		List<Long> list = (List<Long>) this.getHibernateTemplate().find("SELECT COUNT(*) FROM Customer");
		//�����Ϊ��
		if(list.size()!=0 && list!=null){
			//�������ǵļ�¼��
			return list.get(0).intValue();
		}
		return 0;
	}
	//��ѯ�����û�
	@Override
	public Customer getCustomerByID(int cid) {
		// TODO Auto-generated method stub
		Customer customer = this.getHibernateTemplate().get(Customer.class, cid);
		//�����Ϊ�յĻ�
		if(customer!=null){
			return customer;
		}
		return null;
	}
	//�����û�
	@Override
	public List<Customer> findCustomer(String custName) {
		// TODO Auto-generated method stub
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().
				find("from Customer where custName like ?", "%"+custName+"%");
		
		return list;
	}
}