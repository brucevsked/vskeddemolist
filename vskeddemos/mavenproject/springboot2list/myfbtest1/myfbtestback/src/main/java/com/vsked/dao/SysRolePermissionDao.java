package com.vsked.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRolePermissionDao {
    @Select("select * from sysrolepermissiont a left join syspermissiont b on a.syspermissionid=b.syspermissionid where a.sysroleid=#{sysroleid}")
    List<Map<String, Object>> getSysPermissionByRoleId(Object roleid);
}
