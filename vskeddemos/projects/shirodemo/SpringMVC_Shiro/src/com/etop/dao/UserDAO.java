package com.etop.dao;

import com.etop.basic.dao.BaseDAO;
import com.etop.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Jeremie on 2014/9/30.
 */
@Repository("UserDAO")
public class UserDAO extends BaseDAO<User> {
}
