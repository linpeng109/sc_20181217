package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authority")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class Authority implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authorityId", length = 32)
    public String authorityId;

    @Column(name = "authorityString", length = 32, unique = true, nullable = false)
    public String authorityString;

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable = true;
}
