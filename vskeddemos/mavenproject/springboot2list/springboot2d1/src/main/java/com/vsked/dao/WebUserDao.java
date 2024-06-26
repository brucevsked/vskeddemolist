package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserDao {
	
	@Select("select * from webUserT a left join webUserRoleT b on a.uid=b.userid left join webRoleT c on b.roleid=c.id  where a.username=#{username}")
	Map<String, Object> getWebUserByUserName(String username);
	
	@Select("select * from webUserT  where id=#{id}")
	Map<String, Object> getWebUserById(String id);
	
	@Select("select GROUP_CONCAT(rol.code) as roles from webUserT usr join appUserRoleT uro on usr.uid=uro.userid join appRoleT rol on uro.roleid=rol.id where usr.phone=#{phone}")
	String selectUserRoles(String phone);
	
	@Select("<script>select count(0) from webUserT <where><if test=\"isagent!=null and isagent!='' \"> and isagent =#{isagent} </if> <if test=\"phone!=null \"> and phone like concat('%',#{phone},'%')  </if> <if test=\"username!=null\"> and username like concat('%',#{username},'%')  </if></where> </script>")
	int getWebUserCount(Map<String, Object> m);
	
	@Select("<script>select * from webUserT <where> <if test=\"isagent!=null and isagent!='' \"> and isagent =#{isagent} </if> <if test=\"phone!=null\"> and phone like concat('%',#{phone},'%')  </if> <if test=\"username!=null\"> and username like concat('%',#{username},'%')  </if> </where> order by addtime desc </script>")
	List<Map<String, Object>> getWebUserList(Map<String, Object> m);
	
	@Insert("insert into webUserT(uid,username,userpass,phone,status) values(#{uid},#{username},#{userpass},#{phone},1)")
	int add(Map<String, Object> m);
	
	

}
