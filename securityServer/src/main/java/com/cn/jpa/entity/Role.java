package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "authority")
public class Role implements org.springframework.security.core.GrantedAuthority {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authorityId", length = 32)
    private String authorityId;

    @Column(name = "authority", unique = true, nullable = false, length = 32)
    private String authority;

    @Column(name = "authorityDescription", length = 100)
    private String authorityDescription;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authority;
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

}
