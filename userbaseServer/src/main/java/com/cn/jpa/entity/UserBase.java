package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "userbase")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class UserBase implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "userId", length = 32)
    public String userId;

    @Column(name = "username", length = 32, unique = true, nullable = false)
    public String username;

    @Column(name = "password", length = 32)
    public String password;

    @Column(name = "createTime")
    @Type(type = "java.util.Date")
    public Date createTime = new Date();

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable = true;

    @Column(name = "locked")
    @Type(type = "java.lang.Boolean")
    public boolean locked = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "userbase_authority",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "authorityId", referencedColumnName = "authorityId")})
    public List<Authority> authorityList = new ArrayList<Authority>();
}
