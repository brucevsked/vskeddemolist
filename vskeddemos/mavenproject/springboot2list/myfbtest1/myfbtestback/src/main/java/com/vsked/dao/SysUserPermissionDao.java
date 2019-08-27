package com.vsked.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserPermissionDao {

    @Select("select a.syspermissionuri uri,array_to_string(ARRAY(SELECT unnest(array_agg(c.sysrolename)) order by a.syspermissionuri),',') needroles from syspermissiont a left join sysrolepermissiont b on a.syspermissionid=b.syspermissionid left join sysrolet c on b.sysroleid=c.sysroleid group by a.syspermissionuri,a.syspermissionid")
    List<Map<String, String>> getPermissionUriAndRole();
}
