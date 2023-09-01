package com.buchstadt.service;

import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.mapper.EntryMapper;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Resource
    private EntryMapper mapper;

    public R<User> userSignin(User user) {
        User dbUser = mapper.queryUser(user);
        if (dbUser == null) {
            return R.build(HttpCodes.NO, "没有该用户");
        } else {
            if (user.getPassword().equals(dbUser.getPassword())
                    && user.getUsername().equals(dbUser.getUsername())
            ) {
                dbUser.setPassword("");
                return R.build(HttpCodes.OK, "登录成功", dbUser);
            } else {
                return R.build(HttpCodes.NO, "用户名或密码错误");
            }
        }
    }

    public R<Admin> adminSignin(Admin admin) {
        Admin dbAdmin = mapper.queryAdmin(admin);
        if (dbAdmin == null) {
            return R.build(HttpCodes.NO, "没有该用户！");
        } else {
            if (admin.getPassword().equals(dbAdmin.getPassword())
                    && admin.getUsername().equals(dbAdmin.getUsername())
            ) {
                dbAdmin.setPassword("");
                return R.build(HttpCodes.OK, "登录成功！", dbAdmin);
            } else {
                return R.build(HttpCodes.NO, "用户名或密码错误！");
            }
        }
    }

    public R<Object> userSignup(User user) {
        try {
            User u = mapper.userIsExist(user.getUsername());
            if (u == null) {
                Integer flag = mapper.insertUser(user);
                if (flag == 1) {
                    return R.build(HttpCodes.OK, "注册成功！", user);
                }
                return R.build(HttpCodes.NO, "注册失败！");
            }
            return R.build(HttpCodes.NO, "注册失败，已有该用户");
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }
}
