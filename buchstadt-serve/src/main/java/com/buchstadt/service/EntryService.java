package com.buchstadt.service;

import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.mapper.EntryMapper;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private final EntryMapper mapper;

    public EntryService(EntryMapper mapper) {
        this.mapper = mapper;
    }

    public R<User> userSignin(User user) {
        User dbUser = mapper.queryUser(user);
        if (dbUser == null) {
            return R.build(Status.NO, "没有该用户");
        } else {
            if (user.getPassword().equals(dbUser.getPassword())
                    && user.getUsername().equals(dbUser.getUsername())
            ) {
                dbUser.setPassword("");
                return R.build(Status.OK, "登录成功", dbUser);
            } else {
                return R.build(Status.NO, "用户名或密码错误");
            }
        }
    }

    public R<Admin> adminSignin(Admin admin) {
        Admin dbAdmin = mapper.queryAdmin(admin);
        if (dbAdmin == null) {
            return R.build(Status.NO, "没有该用户");
        } else {
            if (admin.getPassword().equals(dbAdmin.getPassword())
                    && admin.getUsername().equals(dbAdmin.getUsername())
            ) {
                dbAdmin.setPassword("");
                return R.build(Status.OK, "登录成功", dbAdmin);
            } else {
                return R.build(Status.NO, "用户名或密码错误");
            }
        }
    }

    public R<User> userSignup(User user) {
        try {
            User dbUser = mapper.queryUser(user);
            if (dbUser == null) {
                Integer flag = mapper.insertUser(user);
                if (flag == 1) {
                    return R.build(Status.OK, "注册成功！", user);
                }
                return R.build(Status.NO, "注册失败！");
            }
            return R.build(Status.NO, "注册失败，已有该用户");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误，请重试！");
        }
    }
}
