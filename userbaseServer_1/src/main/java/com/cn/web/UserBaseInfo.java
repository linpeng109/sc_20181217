package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.jpa.entity.UserBase;
import com.cn.web.service.AuthorityService;
import com.cn.web.service.UserBaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userbaseinfo")
public class UserBaseInfo {
    @Autowired
    public UserBaseService userBaseService;

    @Autowired
    public AuthorityService authorityService;

    @ApiOperation(value = "不分页查询所有用户")
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @ApiOperation(value = "分页查询所有用户", notes = "page=数据页；size=数据页大小")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "数据页", dataType = "Integer"), @ApiImplicitParam(name = "size", value = "数据页大大小", dataType = "Integer")})
    @RequestMapping(value = "/findall/{page}/{size}", method = RequestMethod.GET)
    public Page<UserBase> findAll(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userBaseService.findAll(pageRequest);
    }

    @RequestMapping("/init/{num}")
    @ApiIgnore
    public String init(@PathVariable(name = "num") int num) {
        List<Authority> authorityList = authorityService.findAll();
        for (int i = 0; i < num; ++i) {
            String uuid = UUID.randomUUID().toString().substring(0, 7);
            UserBase userBase = new UserBase();
            userBase.username = uuid;
            userBase.password = uuid;
            userBase.authorityList = authorityList;
            userBaseService.save(userBase);
        }
        return "Test is finished!";
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "统计用户总数", notes = "无条件统计用户总数")
    public long count() {
        return userBaseService.count();
    }
}
