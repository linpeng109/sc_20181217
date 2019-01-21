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
import java.util.ArrayList;
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

    @Test
    public void testAuthorityInit() {
        Role admin = new Role();
        admin.setAuthority("ROLE_ADMIN");
        grantedAuthorityDao.saveAndFlush(admin);

        Role guest = new Role();
        guest.setAuthority("ROLE_GUEST");
        grantedAuthorityDao.saveAndFlush(guest);

        Role user = new Role();
        user.setAuthority("ROLE_USER");
        grantedAuthorityDao.saveAndFlush(user);
    }

    @Test
    public void testSpecialUserInit() {
        User admin = new User();
        admin.setUsername("ADMIN");
        admin.setPassword("ADMIN");
        Role role_admin = grantedAuthorityDao.findByAuthority("ROLE_ADMIN");
        List<Role> role_admin_list = new ArrayList<Role>();
        role_admin_list.add(role_admin);
        admin.setAuthorities(role_admin_list);
        userDetailsDao.saveAndFlush(admin);

        User user = new User();
        user.setUsername("USER");
        user.setPassword("USER");
        Role role_user = grantedAuthorityDao.findByAuthority("ROLE_USER");
        List<Role> role_user_list = new ArrayList<Role>();
        role_user_list.add(role_user);
        user.setAuthorities(role_user_list);
        userDetailsDao.saveAndFlush(user);


        User guest = new User();
        guest.setUsername("GUEST");
        guest.setPassword("GUEST");
        Role role_guest = grantedAuthorityDao.findByAuthority("ROLE_GUEST");
        List<Role> role_guest_list = new ArrayList<Role>();
        role_guest_list.add(role_guest);
        guest.setAuthorities(role_guest_list);
        userDetailsDao.saveAndFlush(guest);
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
