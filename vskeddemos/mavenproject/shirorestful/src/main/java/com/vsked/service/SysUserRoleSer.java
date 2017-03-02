package com.vsked.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.SysUserRoleDao;



@Service
@Transactional
public class SysUserRoleSer extends BaseService {
	
	public Logger log = Logger.getLogger(this.getClass());

	@Resource
	SysUserRoleDao sysUserRoleDao;


	public List<Map<String, Object>> getSysUserRoleListBySuId(String suId) {
		return sysUserRoleDao.getSysUserRoleListBySuId(suId);
	}

	/**
	 * 跳转用户分配页面，把角色ID存入
	 * 
	 * */
	public String getSysUserRoleBySrId(String srId) {
		Session session = getSession();
		session.setAttribute("srId", srId);
		return "system/sysUserAddOrEdit";
	}

	/**
	 * 跳转角色分配页面，把用户ID存入
	 * 
	 * */
	public String getSysUserRoleBySuId(String suId) {
		Session session = getSession();
		session.setAttribute("suId", suId);
		return "system/sysRoleAddOrEdit";
	}



	public Set<String> getSysUserRoleNameSetBySuId(String suId) {
		List<Map<String, Object>> sourceList = getSysUserRoleListBySuId(suId);
		Set<String> targetSet = new HashSet<String>();
		for (Map<String, Object> sysUserRole : sourceList) {
			targetSet.add((String) (sysUserRole.get("srName")));
		}
		return targetSet;
	}

	/**
	 * 
	 * 角色关联到用户
	 * */
	public String sysRoleAddOrEdit(HttpServletRequest req) {
		boolean flag = false;
		try {
			Map<String, Object> myData = getMaps(req);
			String suId = (String) myData.get("suId");
			String object = (String) myData.get("hasRoleIds");
			String[] srId = object.split(",");
			List<Map<String, Object>> userRole = sysUserRoleDao
					.getSysUserRoleListBySuId(suId);
			if (userRole.size() > 0) {
				int row = sysUserRoleDao.sysUserRoleDelBySuId(suId);
				if (row > 0) {
					for (int i = 0; i < srId.length; i++) {
						String sid = srId[i];
						myData.put("suId", suId);
						myData.put("srId", sid);
						int row2 = sysUserRoleDao.sysUserRoleAdd(myData);
						if (row2 > 0) {
							flag = true;
						}
					}
				}
			} else {
				for (int i = 0; i < srId.length; i++) {
					String sid = srId[i];
					myData.put("suId", suId);
					myData.put("srId", sid);
					int row2 = sysUserRoleDao.sysUserRoleAdd(myData);
					if (row2 > 0) {
						flag = true;
					}
				}
			}
			Session session = getSession();
		} catch (Exception e) {
			getMyLog(e,log);
		}
		return "system/sysUserList";
	}
}
