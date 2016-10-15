package com.etop.basic.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jeremie on 14-2-12.
 */
public class BaseDAO<T> implements Serializable {

    protected transient Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> persistentClass;

    protected Class<T> getCurClass() {
        if (persistentClass == null) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistentClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected StatelessSession getStatelessSession() {
        return sessionFactory.openStatelessSession();
    }

    public void flush() {
        getSession().flush();
    }

    public void evict(T entity) {
        getSession().evict(entity);
    }

    public T get(long id) throws DataAccessException {
        log.debug("DAO:Get entity " + getCurClass().getSimpleName() + ":Id=" + id);
        return (T) getSession().get(getCurClass(), id);
    }

    public void save(T entity) throws DataAccessException {
        log.debug("DAO:Save entity " + entity.getClass().getSimpleName());
        getSession().save(entity);
    }

    public void update(T entity) throws DataAccessException {
        log.debug("DAO:Update entity " + entity.getClass().getSimpleName());
        getSession().clear();
        getSession().update(entity);
    }

    public void saveOrUpdate(T entity) throws DataAccessException {
        log.debug("DAO:Sava or Update entity " + entity.getClass().getSimpleName());
        getSession().clear();
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) throws DataAccessException {
        log.debug("DAO:delete entity " + getCurClass().getSimpleName());
        getSession().delete(entity);
    }

    public void deleteById(long id) throws DataAccessException {
        log.debug("DAO:delete entity " + getCurClass().getSimpleName() + ":Id=" + id);
        String queryString = "delete from " + getCurClass().getSimpleName() + " where id=" + id;
        this.excute(queryString);
    }

    public int excute(String queryString) throws DataAccessException {
        log.debug("DAO:Excute HQL update :" + queryString);
        Query query = getSession().createQuery(queryString);
        return query.executeUpdate();
    }

    public List<T> find(String queryString) throws DataAccessException {
        log.debug("DAO:Running HQL query :" + queryString);
        Query query = getSession().createQuery(queryString);
        query.setCacheable(true);
        return query.list();
    }

    private Query createQuery(String queryString, Map<String, Object> params, int startRow, int pageSize) {
        Query query = getSession().createQuery(queryString);
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String paramName = entry.getKey();
                Object obj = entry.getValue();
                log.info("DAO:set param:" + paramName + " with value:" + obj);
                if (obj instanceof List) {
                    query.setParameterList(paramName, (Collection) obj);
                } else if (obj instanceof Object[]) {
                    query.setParameterList(paramName, (Object[]) obj);
                } else {
                    query.setParameter(paramName, obj);
                }
            }
        }
        query.setCacheable(true);
        if (pageSize != -1) {
            query.setFirstResult(startRow).setMaxResults(pageSize);
        }
        return query;
    }

    private Query createQuery(String queryString) {
        return createQuery(queryString, null, 0, -1);
    }

    private Query createQuery(String queryString, Map<String, Object> params) {
        return createQuery(queryString, params, 0, -1);
    }

    public List<T> find(String queryString, int startRow, int pageSize) throws DataAccessException {
        log.debug("DAO:Running HQL query by page:" + queryString);
        Query query = createQuery(queryString, null, startRow, pageSize);
        return query.list();
    }

    public int getTotalCount(String queryString) throws DataAccessException {
        return getTotalCount(queryString, null);
    }

    public int getTotalCount(String queryString, Map<String, Object> params) throws DataAccessException {
        log.debug("DAO:Running HQL query for total count of records :" + queryString);
        queryString = "select count(t.id) " + queryString;
        Query query;
        if (params != null) {
            query = createQuery(queryString, params);
        } else {
            query = createQuery(queryString);
        }
        return ((Long) query.uniqueResult()).intValue();
    }

    public List findWithSelect(String queryString) throws DataAccessException {
        log.debug("DAO:Running HQL query with selections :" + queryString);
        Query query = createQuery(queryString);
        return query.list();
    }

    public List findWithSelect(String queryString, Map<String, Object> params) throws DataAccessException {
        log.debug("DAO:Running HQL query with parameters:" + queryString);
        Query query = createQuery(queryString, params);
        return query.list();
    }

    public List findWithSelect(String queryString, Map<String, Object> params, int startRow, int pageSize) throws DataAccessException {
        log.debug("DAO:Running HQL query by page :" + queryString);
        Query query = createQuery(queryString, params, startRow, pageSize);
        return query.list();
    }

    public List<T> find(String queryString, Map<String, Object> params) throws DataAccessException {
        log.debug("DAO:Running HQL query with parameters: " + queryString);
        Query query = createQuery(queryString, params);
        return query.list();
    }

    public List<T> find(String queryString, Map<String, Object> params, int startRow, int pageSize) throws DataAccessException {
        log.debug("DAO:Running HQL query with params by page :" + queryString);
        Query query = createQuery(queryString, params, startRow, pageSize);
        return query.list();
    }

    public T findUniqueResult(String queryString, Map<String, Object> params) throws DataAccessException {
        log.debug("DAO:Running HQL query with parameters:" + queryString);
        Query query = createQuery(queryString, params);
        return (T) query.uniqueResult();
    }

    public int excute(String queryString, Map<String, Object> params) throws DataAccessException {
        log.debug("DAO:Excute HQL update :" + queryString);
        Query query = createQuery(queryString, params);
        return query.executeUpdate();
    }
}


