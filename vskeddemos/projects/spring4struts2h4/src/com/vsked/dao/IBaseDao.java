package com.vsked.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.vsked.util.PagerModel;


public interface IBaseDao {
	
	public <T> T get(Class<T> clazz, Serializable id);
    public <T> void save(T entity);
    public <T> void saveOrUpdate(T entity);
    public <T> void update(T entity);
    public <T> void merge(T entity);
    public <T> void delete(T entity);
    public <T> void deleteById(Class<T> clazz, Serializable id);
    public int batchExecute(final String hql,Object[] params);
    public <T> List<T> findByHql(String hql);
    public <T> List<T> findByHql(String hql, Object param);
	public <T> List<T> findByHql(String hql, Object[] params);
	public <T> List<T> findAll(Class<T> clazz);
	public <T> List<T> findByCriterion(Class<T> clazz,Order order);
	public <T> List<T> findByCriterion(Class<T> clazz,Order order,Criterion... criterions);
    public int count(String hql, Object[] params);
	public <T> PagerModel<T> findPageByCriterion(Class<T> clazz,int offset,int pagesize,Order order,Criterion... criterions);
	public <T> PagerModel<T> findPageByHql(String hql,Object[] params,int offset,int pagesize);
}
