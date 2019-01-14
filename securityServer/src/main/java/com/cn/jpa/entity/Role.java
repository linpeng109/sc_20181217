package com.cn.jpa.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "authority")
public class Role implements GrantedAuthority {
    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityDescription() {
        return authorityDescription;
    }

    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authorityId", length = 32)
    private String authorityId;

    @Column(name = "authority", unique = true, nullable = false, length = 32)
    private String authority;

    @Column(name = "authorityDescription", length = 100)
    private String authorityDescription;

    @Override
    public String getAuthority() {
        return authority;
    }
}
