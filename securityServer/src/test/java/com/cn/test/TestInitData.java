package com.cn.test;

import com.cn.jpa.dao.GrantedAuthorityDao;
import com.cn.jpa.dao.UserDetailsDao;
import com.cn.jpa.entity.Role;
import com.cn.jpa.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class TestInitData {
    @Resource
    protected GrantedAuthorityDao grantedAuthorityDao;

    @Resource
    protected UserDetailsDao userDetailsDao;

//    @Test
    public void testAuthorityInit() {
        Role admin = new Role();
        admin.setAuthority("ROLE_ADMIN");
        grantedAuthorityDao.save(admin);

        Role guest = new Role();
        guest.setAuthority("ROLE_GUEST");
        grantedAuthorityDao.save(guest);

        Role user = new Role();
        user.setAuthority("ROLE_USER");
        grantedAuthorityDao.save(user);
    }

    @Test
    public void testGrantUserInit() {
        List<Role> authorityList = grantedAuthorityDao.findAll();
        for (int i = 0; i < 1000; ++i) {
            User user = new User();
            String randomStr = UUID.randomUUID()
                    .toString()
                    .replaceAll("-", "")
                    .substring(16, 24)
                    .toUpperCase();
            user.setUsername(randomStr);
            user.setPassword(randomStr);
            user.setAuthorities(authorityList);
            userDetailsDao.saveAndFlush(user);
        }
    }
}
