package com.vsked.shiro;


import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.service.SysFunctionSer;
import com.vsked.service.SysPermissionSer;
import com.vsked.service.SysRoleSer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *详细参考ini配置文件
 *
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    @Autowired
    SysFunctionSer sysFunctionService;
    
    @Autowired
    SysPermissionSer sysPermissionService;
    
    @Autowired
    SysRoleSer sysRoleService;

    //静态资源访问权限
    private String filterChainDefinitions = "/static/**=anon";

    public Ini.Section getObject() throws Exception {
    	List<Map<String, Object>> list = sysFunctionService.getSysFunctionList();
        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (Iterator<Map<String, Object>> it = list.iterator(); it.hasNext(); ) {
        	Map<String, Object> sysFunction = it.next();
        	String sfValue=(String)sysFunction.get("sfValue");
        	String sfType=(String)sysFunction.get("sfType");
        	String spId=(String)sysFunction.get("spId");
        	String srId=(String)sysFunction.get("srId");
        	
        	String spName="";
        	String srName="";
			if (StringUtils.isNotEmpty(spId)) {
				Map<String, Object> sysPermission = sysPermissionService.getSysPermissionBySpId(spId);
				spName = (String) sysPermission.get("spName");
			}

			if (StringUtils.isNotEmpty(srId)) {
				Map<String, Object> sysRole = sysRoleService.getSysRoleBySrId(srId);
				srName = (String) sysRole.get("srName");
			}
            //构成permission字符串
            if (StringUtils.isNotEmpty(sfValue) && StringUtils.isNotEmpty(sfType)) {
                String permission = "";
                switch(sfType){
                    case "anon":
                        permission = "anon";
                        break;
                    case "perms":
                        permission = "perms[" + spName + "]";
                        break;
                    case "roles":
                        permission = "roles[" + srName + "]";
                        break;
                    case "cusperm":
                    	permission = "cusperm[" + spName + "]";
                    	break;
                    default:
                        break;
                }
                section.put(sfValue, permission);
            }

        }
        
        //不拦截静态资源js与css
        section.put("/js/**", "anon");
        section.put("/css/**", "anon");
        
        section.put("/login.html", "anon");
        section.put("/page403", "anon");
        //所有资源的访问权限，必须放在最后
        section.put("/**", "authc");
        return section;
    }

    public Class<?> getObjectType() {
        return this.getClass();
    }

    public boolean isSingleton() {
        return false;
    }
}

