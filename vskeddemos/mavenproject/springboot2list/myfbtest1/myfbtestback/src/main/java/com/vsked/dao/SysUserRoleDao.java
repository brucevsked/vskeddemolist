package com.vsked.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface SysUserRoleDao {
    @Select("select * from sysuserrolet a left join sysrolet b on a.sysroleid=b.sysroleid where a.sysuserid=#{sysuserid}")
    List<Map<String, String>> getSysUserRolesByUserId(String sysuserid);
}
