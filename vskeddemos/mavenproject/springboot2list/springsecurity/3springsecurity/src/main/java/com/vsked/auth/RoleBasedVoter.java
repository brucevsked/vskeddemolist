package com.vsked.auth;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

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
        //dynamic url and role controller

        log.debug("|"+url+"|");
        for(GrantedAuthority grantedAuthority:authentication.getAuthorities())
        log.debug("|"+grantedAuthority.getAuthority()+"|");

        //在这里进行权限判断 判断数据库里有url有角色名就可以返回ACCESS_GRANTED

        if(authentication == null) {
            return ACCESS_DENIED;
        }
        int result = ACCESS_ABSTAIN;
        Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);

        for (ConfigAttribute attribute : attributes) {
            if(attribute.getAttribute()==null){
                continue;
            }
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;

                // Attempt to find a matching granted authority
                for (GrantedAuthority authority : authorities) {
                    if (attribute.getAttribute().equals(authority.getAuthority())) {
                        log.debug("|"+attribute.getAttribute());
                        return ACCESS_GRANTED;
                    }
                }
            }
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
