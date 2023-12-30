package com.jat.system.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class User implements UserDetails {

    private Long id;
    private String userName;
    private String password;

    private boolean accountNonExpired;
    private boolean accountNonLock;
    private boolean credentialsNonExpired;
    private boolean enable;

    private List<Role> roles;

    private Certificate certificate;

    Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=new LinkedList<>();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public User(Long id, String userName, String password, boolean accountNonExpired, boolean accountNonLock, boolean credentialsNonExpired, boolean enable, List<Role> roles,Certificate certificate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLock = accountNonLock;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enable = enable;
        this.roles = roles;
        this.certificate=certificate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


    public void setAccountNonLock(boolean accountNonLock) {
        this.accountNonLock = accountNonLock;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLock;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enable;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public void logout(){
        this.certificate=null;
    }

}
