package com.vsked.infrastructure.persistence.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.vsked.auth.infrastructure.persistence.jpa.PermissionDto;
import com.vsked.auth.infrastructure.persistence.jpa.RoleDto;
import com.vsked.auth.infrastructure.persistence.jpa.UserDto;
import com.vsked.auth.service.TestUserService;
import com.vsked.test.BaseTestWithTransactional;

public class UserRepositoryTest extends BaseTestWithTransactional {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

	@Autowired
	TestUserService testUserService;

	/**
	 * 第一位1代表用户数量
	 * 第二位1代表角色数量
	 * 第三位1代表权限数量
	 */
	@Test
	public void testTransactional111() {
		log.trace("UserRepositoryTest testTransactional111 start");
		Integer permissionId = new Integer(1);
		String permissionOperation = new String("上班");
		PermissionDto permissionDto = new PermissionDto(permissionId, permissionOperation);
		log.debug(permissionDto.toString());
		Set<PermissionDto> permission = new HashSet<PermissionDto>();
		permission.add(permissionDto);
		Integer roleId = new Integer(1);
		String rolename = new String("职员");
		RoleDto roleDto = new RoleDto(roleId, rolename, permission);
		log.debug(roleDto.toString());
		Set<RoleDto> role = new HashSet<RoleDto>();
		role.add(roleDto);
		Integer userId = new Integer(1);
		String username = new String("张三");
		UserDto userDto = new UserDto(userId, username, role);
		log.debug(userDto.toString());
		testUserService.test(userDto);
		log.trace("UserRepositoryTest testTransactional111 end");
	}
	
	/**
	 * 第一位1代表用户数量
	 * 第二位1代表角色数量
	 * 第三位2代表权限数量
	 */
	@Test
	public void testTransactional11N() {
		log.trace("UserRepositoryTest testTransactional11N start");
		Set<PermissionDto> permission = new HashSet<PermissionDto>();
		Integer permissionId = new Integer(2);
		String permissionOperation = new String("巡逻");
		PermissionDto permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		permissionId = new Integer(3);
		permissionOperation = new String("看大门");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		Integer roleId = new Integer(2);
		String rolename = new String("保安");
		RoleDto roleDto = new RoleDto(roleId, rolename, permission);
		Set<RoleDto> role = new HashSet<RoleDto>();
		role.add(roleDto);
		log.debug(roleDto.toString());
		Integer userId = new Integer(2);
		String username = new String("李四");
		UserDto userDto = new UserDto(userId, username, role);
		log.debug(userDto.toString());
		testUserService.test(userDto);
		log.trace("UserRepositoryTest testTransactional11N end");
	}
	
	@Test
	public void testTransactional1NN() {
		log.trace("UserRepositoryTest testTransactional1NN start");
		Set<PermissionDto> permission = new HashSet<PermissionDto>();
		Integer permissionId = new Integer(4);
		String permissionOperation = new String("送快递");
		PermissionDto permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		permissionId = new Integer(5);
		permissionOperation = new String("包快递");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		permissionId = new Integer(6);
		permissionOperation = new String("收快递");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		Integer roleId = new Integer(3);
		String rolename = new String("快递员");
		RoleDto roleDto = new RoleDto(roleId, rolename, permission);
		Set<RoleDto> role = new HashSet<RoleDto>();
		log.debug(roleDto.toString());
		role.add(roleDto);
		permission = new HashSet<PermissionDto>();
		permissionId = new Integer(7);
		permissionOperation = new String("送外卖");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		permissionId = new Integer(8);
		permissionOperation = new String("刷手机");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		permissionId = new Integer(9);
		permissionOperation = new String("等红灯");
		permissionDto = new PermissionDto(permissionId, permissionOperation);
		permission.add(permissionDto);
		log.debug(permissionDto.toString());
		roleId = new Integer(4);
		rolename = new String("送餐员");
		roleDto = new RoleDto(roleId, rolename, permission);
		log.debug(roleDto.toString());
		role.add(roleDto);
		Integer userId = new Integer(3);
		String username = new String("王五");
		UserDto userDto = new UserDto(userId, username, role);
		log.debug(userDto.toString());
		testUserService.test(userDto);
		log.trace("UserRepositoryTest testTransactional1NN end");
	}
	
	@Test
	public void findById() {
		log.trace("UserRepositoryTest findById start");
		Integer userId = new Integer(3);
		UserDto userDto=testUserService.findByid(userId);
        log.debug(userDto.toString());
        Set<RoleDto> roleDtoSet = userDto.getRoles();
        for(RoleDto roleDto : roleDtoSet) {
        	log.debug("|" + roleDto.toString());
        	Set<PermissionDto> permissionDtoSet = roleDto.getPermission();
        	for(PermissionDto permissionDto : permissionDtoSet) {
        		log.debug("||" + permissionDto.toString());
        	}
        }
        log.trace("UserRepositoryTest findById end");
	}
	
	@Test
	public void findAllBy() {
		log.trace("UserRepositoryTest findAllBy start");
		List<UserDto> uesrDtoList = testUserService.findAllBy();
		for (UserDto userDto : uesrDtoList) {
			log.debug("|" + userDto.idToString());
			for(RoleDto roleDto: userDto.getRoles()) {
				log.debug("||" +roleDto.idToString());
				for(PermissionDto permissionDto: roleDto.getPermission()) {
					log.debug("|||" +permissionDto.toString());
				}
			}
		}
		log.trace("UserRepositoryTest findAllBy end");
	}
	
}
