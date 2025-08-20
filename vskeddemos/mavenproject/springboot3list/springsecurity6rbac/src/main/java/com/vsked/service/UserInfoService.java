package com.vsked.service;

import com.vsked.jpa.model.SysRole;
import com.vsked.jpa.model.SysUser;
import com.vsked.jpa.repository.SysRoleRepository;
import com.vsked.jpa.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;
    @Autowired
    private SysRoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.builder().username(sysUser.getName()).password(sysUser.getPassword()).authorities(getAuthorities(sysUser)).build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(SysUser user) {
        List<SysRole> roles=roleRepository.findRolesByUserId(user.getId());
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId()+""))
                .collect(Collectors.toList());
    }
}
