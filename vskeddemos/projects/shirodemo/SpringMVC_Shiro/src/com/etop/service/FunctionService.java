package com.etop.service;

import com.etop.dao.FunctionDAO;
import com.etop.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 网页过滤服务，与dao进行对接
 * <p/>
 * Created by Jeremie on 2014/10/1.
 */
@Service("FunctionService")
public class FunctionService implements Serializable {

    @Autowired
    private FunctionDAO functionDAO;

    /**
     * 查找所有权限过滤信息
     *
     * @return
     */
    public List<Function> findAll() {
        return functionDAO.find("from Function f");
    }
}
