package com.vsked.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.SysRolePermissionDao;



@Service
@Transactional
public class SysRolePermissionSer extends BaseService {
	
	public Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SysRolePermissionDao sysRolePermissionDao;
	
	public List<Map<String, Object>> getSysRolePermissionBySrId(String srId) {
		return sysRolePermissionDao.getSysRolePermissionBySrId(srId);
	}

	/**
	 * 存入角色ID，跳转权限分配页面
	 * */
	public String sysRolePermissionBySrId(String srId) {
		Session session = getSession();
		session.setAttribute("permissionSrId", srId);
		return "system/sysPermissionAssign";
	}
	
	
	/**
	 * 
	 * 添加权限给角色
	 * */
	public String sysPermissionAssign(HttpServletRequest req) {
		boolean flag = false;
		try {
			Map<String, Object> myData = getMaps(req);
			String srId = (String) myData.get("srId");
			String object = (String) myData.get("hasPermissionIds");
			String[] spId = object.split(",");
			List<Map<String, Object>> rolePermission = sysRolePermissionDao
					.getSysRolePermissionBySrId(srId);
			if (rolePermission.size() > 0) {
				int row = sysRolePermissionDao.sysRolePermissionDelBySrId(srId);
				if (row > 0) {
					for (int i = 0; i < spId.length; i++) {
						String sid = spId[i];
						myData.put("spId", sid);
						myData.put("srId", srId);
						int row2 = sysRolePermissionDao.sysRolePermissionAdd(myData);
						if (row2 > 0) {
							flag = true;
						}
					}
				}
			} else {
				for (int i = 0; i < spId.length; i++) {
					String sid = spId[i];
					myData.put("spId", sid);
					myData.put("srId", srId);
					int row2 = sysRolePermissionDao.sysRolePermissionAdd(myData);
					if (row2 > 0) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			getMyLog(e,log);
		}
		return "system/sysRoleList";
	}
}
