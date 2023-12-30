package com.jat.config;

import com.jat.system.model.Menu;
import com.jat.system.model.Role;
import com.jat.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.List;

public class RoleBasedVoter implements AccessDecisionVoter<Object> {

    private static final Logger log = LoggerFactory.getLogger(RoleBasedVoter.class);

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();


        log.debug("|" + url + "|");
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities())
            log.debug("|" + grantedAuthority.getAuthority() + "|");

        //在这里进行权限判断 判断数据库里有url有角色名就可以返回ACCESS_GRANTED

        if (authentication == null) {
            return ACCESS_DENIED;
        }
        int result = ACCESS_ABSTAIN;  //弃权
        Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);

        for (ConfigAttribute attribute : attributes) {
            if (attribute.getAttribute() == null) {
                continue;
            }
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;  //拒绝

                // Attempt to find a matching granted authority
                for (GrantedAuthority authority : authorities) {
                    if (attribute.getAttribute().equals(authority.getAuthority())) {
                        log.debug("|" + attribute.getAttribute());
                        return ACCESS_GRANTED;  //同意
                    }
                }
            }
        }

        //dynamic url and role controller
        Object tempUser=authentication.getPrincipal();
        log.info("{}",tempUser);
        //不为null且不是匿名用户
        if(tempUser!=null && !"anonymousUser".equals(tempUser)){
            User user= (User) tempUser;
            List<Role> roles=user.getRoles();
            //遍历角色
            for(Role role:roles){
                List<Menu> menus=role.getMenus();
                for(Menu menu:menus){
                    if(url.equals(menu.getUrl())){
                        return ACCESS_GRANTED;  //同意
                    }
                }
            }
            return ACCESS_DENIED;
        }

        return result;
    }

    Collection<? extends GrantedAuthority> extractAuthorities(
            Authentication authentication) {
        return authentication.getAuthorities();
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }
}
