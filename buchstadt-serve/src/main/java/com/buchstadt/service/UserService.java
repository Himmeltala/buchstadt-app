package com.buchstadt.service;

import com.buchstadt.mapper.UserMapper;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.vo.UpdatePwdVo;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Resource
    private UserMapper mapper;

    public R<List<User>> queryAll() {
        return R.build(Http.OK, mapper.queryAll());
    }

    public R<User> queryOne(User data) {
        return R.build(Http.OK, mapper.queryOne(data));
    }

    @Transactional
    public R<Integer> insertOne(User user) {
        User exist = mapper.isExist(user);
        if (!Objects.isNull(exist)) return R.build(Http.NO, "已经存在该用户！不可以添加");
        return R.build(Http.OK, "添加用户成功！", mapper.insertOne(user));
    }

    @Transactional
    public R<Integer> updateOne(User user) {
        return R.build(Http.OK, "更新成功！", mapper.updateOne(user));
    }

    @Transactional
    public R<Void> deleteOne(User user) {
        if (mapper.deleteOne(user) == 1)
            return R.build(Http.OK, "删除成功");
        return R.build(Http.NO, "删除失败");
    }

    @Transactional
    public R<Void> updatePwd(UpdatePwdVo vo, Integer uid) {
        try {
            User user = new User();
            user.setId(uid);
            User dbUser = mapper.isExist(user);

            if (Objects.isNull(dbUser))
                return R.build(Http.NO, "该用户不存在！");

            if (dbUser.getPassword().equals(vo.getNewPasswd()))
                return R.build(Http.NO, "原始密码和新密码是一致的，请确认后再修改！");

            if (!dbUser.getPassword().equals(vo.getOldPasswd()))
                return R.build(Http.NO, "原始密码错误，请确认后再继续！");

            user.setPassword(vo.getNewPasswd());
            Integer f = mapper.updatePwd(user);

            if (f == 0)
                return R.build(Http.NO, "重置密码失败！操作数据库错误。");

            return R.build(Http.OK, "重置密码成功！");
        } catch (Exception e) {
            throw new RuntimeException("操作数据库出错！");
        }
    }

}
