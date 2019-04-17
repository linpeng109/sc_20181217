package com.cn.elastic.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.annotation.Generated;

@Data
@Document(indexName = "company", type = "employee", shards = 1, replicas = 0, refreshInterval = "-1")
public class Employee {
    @Id
    public String id;
    @Field
    public String firstName;
    @Field
    public String lastName;
    @Field
    public String about;
}
