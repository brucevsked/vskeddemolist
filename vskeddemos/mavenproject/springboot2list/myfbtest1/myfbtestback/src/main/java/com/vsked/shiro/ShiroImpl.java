package com.vsked.shiro;

import com.vsked.dao.SysUserPermissionDao;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ShiroImpl {

	@Autowired
    SysUserPermissionDao sysUserPermissionDao;

    /**
     * 载入角色权限列表
     * @return
     */
    public Map<String, String> loadFilterChainDefinitions() {
        List<Map<String, String>> permissions = sysUserPermissionDao.getPermissionUriAndRole();
        // 权限uri控制map.从数据库获取
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        for (Map<String, String> permission : permissions) {
            // noSessionCreation的作用是用户在操作session时会抛异常
            filterChainDefinitionMap.put(permission.get("uri"), "noSessionCreation,jwt[" + permission.get("needroles") + "]");
        }
        List<Map<String, String>> permissionscode = sysUserPermissionDao.getPermissionCodeAndRole();
        // 权限code控制map.从数据库获取
        for (Map<String, String> permission : permissionscode) {
            // noSessionCreation的作用是用户在操作session时会抛异常
            filterChainDefinitionMap.put(permission.get("code"), "noSessionCreation,jwt[" + permission.get("needroles") + "]");
        }


        filterChainDefinitionMap.put("/apia/v1/user/login", "anon");//登录不拦截
        filterChainDefinitionMap.put("/apia/v1/user/logout", "anon");//退出

        filterChainDefinitionMap.put("/apia/**", "noSessionCreation,jwt");//指定app端过滤器
        filterChainDefinitionMap.put("/static/**", "anon");//匿名访问静态资源
        
        // 配置全局过滤
        filterChainDefinitionMap.put("/**", "jwt");
        return filterChainDefinitionMap;
    }

    /**
     * 更新角色权限信息
     * @param shiroFilterFactoryBean
     */
    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean) {
    	//TODO when appRolePermissionT changed reload
        synchronized (this) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
            	log.error(e.getMessage(),e);
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
        log.debug("reloadRolePermission------------------------------ok");
    }
}
