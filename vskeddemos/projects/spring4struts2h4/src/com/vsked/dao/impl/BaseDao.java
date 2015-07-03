package com.vsked.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vsked.dao.IBaseDao;
import com.vsked.util.PagerModel;


@Repository
public class BaseDao implements IBaseDao {

	@Autowired
	private SessionFactory sessionFactory;  
  
    public Session getSession() {  
        return sessionFactory.getCurrentSession();  
    }  
    
    @SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Serializable id)
    {
    	return (T) getSession().get(clazz, id);
    }
    
    public <T> void save(T entity)
    {
    	getSession().save(entity);
    }
  
    public <T> void saveOrUpdate(T entity)
    {
    	getSession().saveOrUpdate(entity);
    }
    
    public <T> void update(T entity)
    {
    	getSession().merge(entity);  //update merge qubie
    	getSession().flush();
    }
    
    public <T> void merge(T entity)
    {
    	getSession().merge(entity);
    	getSession().flush();
    }
    
    public <T> void delete(T entity)
    {
    	getSession().delete(entity);
    	getSession().flush();
    }
    
    public <T> void deleteById(Class<T> clazz, Serializable id)
    {
    	getSession().delete(get(clazz,id));  //get load qubie
    	getSession().flush();
    }
   
    public int batchExecute(final String hql,Object[] params) 
    {     
    	Query query = getSession().createQuery(hql);  
    	if(params!=null && params.length > 0)
    	{
	        for (int i = 0; i < params.length; i++) {  
	            query.setParameter(i, params[i]);  
	        } 
    	}
    	return query.executeUpdate();         
    } 
    
    public <T> List<T> findByHql(String hql)
    {
    	return findByHql(hql, new Object[] {});
    }
    
    public <T> List<T> findByHql(String hql, Object param)
    {
    	return findByHql(hql, new Object[] { param });
    }
  
    @SuppressWarnings("unchecked")
	public <T> List<T> findByHql(String hql, Object[] params)
    {
    	Query query = getSession().createQuery(hql);  
        for (int i = 0; i < params.length; i++) {  
            query.setParameter(i, params[i]);  
        }  
        return query.list(); 
    }
    
    @SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz)
    {
    	return getSession().createCriteria(clazz).list();
    }
    
    @SuppressWarnings("unchecked")
	public <T> List<T> findByCriterion(Class<T> clazz,Order order)
    {
    	return getSession().createCriteria(clazz).addOrder(order).list();
    }
    
    @SuppressWarnings("unchecked")
	public <T> List<T> findByCriterion(Class<T> clazz,Order order,Criterion... criterions)
    {
    	Criteria criteria = getSession().createCriteria(clazz);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		if (order != null) {
			criteria.addOrder(order);
		}
		return criteria.list();
    }
  
    public int count(String hql, Object[] params)
    {
    	Query query = getSession().createQuery(hql);  
    	if(params!=null && params.length > 0)
    	{
	        for (int i = 0; i < params.length; i++) {  
	            query.setParameter(i, params[i]);  
	        } 
    	}
        return Integer.parseInt(query.uniqueResult().toString());
    }
    
	@SuppressWarnings("unchecked")
	public <T> PagerModel<T> findPageByCriterion(Class<T> clazz,int offset,int pagesize,Order order,Criterion... criterions)
	{
		Criteria criteria = getSession().createCriteria(clazz);
		if (criterions!=null) {
			for (Criterion c : criterions) {
				criteria.add(c);
			}
		}
		if (order != null) {
			criteria.addOrder(order);
		}
		int total = criteria.list().size();
		//获得当前页的结果集
 		criteria.setFirstResult(offset);
		criteria.setMaxResults(pagesize);
		List<T> list = criteria.list();
		PagerModel<T> pm = new PagerModel<T>();
		pm.setTotal(total);
		pm.setList(list);
		
		return pm;
	}
	@SuppressWarnings("unchecked")
	public <T> PagerModel<T> findPageByHql(String hql,Object[] params,int offset,int pagesize)
	{
		//获取总记录数
		String countHql = getCountQuery(hql);
		Query query = getSession().createQuery(countHql);
		if(query != null && params != null && params.length > 0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}		
		int total = ((Long)query.uniqueResult()).intValue();
		
		//获得当前页的结果集
		query = getSession().createQuery(hql);
		if(query != null && params != null && params.length > 0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pagesize);
		List<T> list = query.list();
		PagerModel<T> pm = new PagerModel<T>();
		pm.setTotal(total);
		pm.setList(list);
		
		return pm;
	}
	
	private static String getCountQuery(String hql) {
		int index = hql.indexOf("from");
		int end = hql.indexOf("order");
		if(index != -1){
			return "select count(*)" + hql.substring(index,end);
		}
		throw new RuntimeException("无效的HQL查询语句!");
	}
}
