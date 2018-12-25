package com.cn.jpa.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "user")
public class User implements org.springframework.security.core.userdetails.UserDetails {

    public User() {
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "userId", length = 32)
    private String userId;

    @Column(name = "username", unique = true, nullable = false, length = 32)
    private String username;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "enabled")
    @Type(type = "java.lang.Boolean")
    private boolean enabled = true;

    @Column(name = "accountNonExpired")
    @Type(type = "java.lang.Boolean")
    private boolean accountNonExpired = true;

    @Column(name = "accountNonLocked")
    @Type(type = "java.lang.Boolean")
    private boolean accountNonLocked = true;

    @Column(name = "credentialsNonExpired")
    @Type(type = "java.lang.Boolean")
    private boolean credentialsNonExpired = true;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Column(name = "createDate")
    @Type(type = "java.util.Date")
    private Date createDate = new Date();

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "authorityId", referencedColumnName = "authorityId"))
    private List<Role> authorities = new ArrayList<Role>();
}
