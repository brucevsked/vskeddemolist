package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserDao {
	
	@Select("select a.*,c.`name` rolename  from webUserT a left join webUserRoleT b on a.uid=b.userid left join webRoleT c on b.roleid=c.id  where a.username=#{username}")
	Map<String, Object> getWebUserByUserName(String username);
	
	@Select("<script>select a.*,c.`name` rolename,c.id roleid from webUserT a left join webUserRoleT b on a.uid=b.userid left join webRoleT c on b.roleid=c.id where a.uid=#{fuid}  </script>")
	Map<String, Object> getById(String fuid);
	
	@Select("select GROUP_CONCAT(rol.code) as roles from webUserT usr join appUserRoleT uro on usr.uid=uro.userid join appRoleT rol on uro.roleid=rol.id where usr.phone=#{phone}")
	String selectUserRoles(String phone);
	
	@Select("<script>select count(0) from webUserT a left join webUserRoleT b on a.uid=b.userid left join webRoleT c on b.roleid=c.id <where> <if test=\"isagent!=null and isagent!='' \"> and a.isagent =#{isagent} </if> <if test=\"phone!=null\"> and a.phone like concat('%',#{phone},'%')  </if> <if test=\"username!=null\"> and a.username like concat('%',#{username},'%')  </if> </where> order by a.addtime desc </script>")
	int getWebUserCount(Map<String, Object> m);
	
	@Select("<script>select a.*,c.`name` rolename,c.id roleid from webUserT a left join webUserRoleT b on a.uid=b.userid left join webRoleT c on b.roleid=c.id <where> <if test=\"isagent!=null and isagent!='' \"> and a.isagent =#{isagent} </if> <if test=\"phone!=null\"> and a.phone like concat('%',#{phone},'%')  </if> <if test=\"username!=null\"> and a.username like concat('%',#{username},'%')  </if> </where> order by a.addtime desc </script>")
	List<Map<String, Object>> getWebUserList(Map<String, Object> m);
	
	@Insert("insert into webUserT(uid,username,userpass,phone,status) values(#{uid},#{username},#{userpass},#{phone},1)")
	int webUserAdd(Map<String, Object> m);
	
	@Update("update webUserT set userpass=#{userpass} where uid=#{fuid}")
	int passReset(Map<String, Object> m);
	
	@Update("update webUserT set username=#{username},phone=#{phone}  where uid=#{fuid}")
	int update(Map<String, Object> m);

}
