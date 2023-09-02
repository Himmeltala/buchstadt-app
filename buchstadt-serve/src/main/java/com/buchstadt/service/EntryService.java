package com.buchstadt.service;

import com.buchstadt.constant.KeyVals;
import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.mapper.EntryMapper;
import com.buchstadt.pojo.dto.TokenDto;
import com.buchstadt.pojo.vo.SignUpVo;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.JwtUtil;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class EntryService {

    @Resource
    private EntryMapper mapper;

    public R<TokenDto> userSignIn(User user) {
        User isExists = mapper.queryUser(user);
        if (Objects.isNull(isExists))
            return R.build(Http.NO, "没有该用户！");

        if (user.getPassword().equals(isExists.getPassword())
                && user.getUsername().equals(isExists.getUsername())
        ) {

            Long expire = JwtUtil.getExpire();
            String uid = UUID.randomUUID().toString();
            String token = JwtUtil.createJwt(isExists.getUsername(), KeyVals.TOKEN_USER_TYPE, uid, expire);
            TokenDto dto = new TokenDto(token, KeyVals.TOKEN_USER_TYPE, isExists.getId(), isExists.getProfilePhoto());
            return R.build(Http.OK, "登录成功！", dto);
        } else return R.build(Http.NO, "用户名或密码错误！");
    }

    public R<TokenDto> adminSignIn(Admin admin) {
        Admin isExists = mapper.queryAdmin(admin);
        if (Objects.isNull(isExists))
            return R.build(Http.NO, "没有该用户！");
        if (admin.getPassword().equals(isExists.getPassword())
                && admin.getUsername().equals(isExists.getUsername())
        ) {
            Long expire = JwtUtil.getExpire();
            String uid = UUID.randomUUID().toString();
            String token = JwtUtil.createJwt(isExists.getUsername(), KeyVals.TOKEN_ADMIN_TYPE, uid, expire);
            TokenDto dto = new TokenDto(token, KeyVals.TOKEN_ADMIN_TYPE, isExists.getId(), isExists.getProfilePhoto());
            return R.build(Http.OK, "登录成功！", dto);
        } else return R.build(Http.NO, "用户名或密码错误！");
    }

    @Transactional
    public R<Void> userSignUp(SignUpVo vo) {
        try {
            User isExist = mapper.userIsExist(vo.getUsername());
            if (!Objects.isNull(isExist))
                return R.build(Http.NO, "注册失败，已有该用户！");

            if (!vo.getPassword().equals(vo.getRePasswd()))
                return R.build(Http.NO, "注册失败，两次密码不一致！");


            Integer f = mapper.insertUser(vo);
            if (f != 1)
                return R.build(Http.NO, "用户注册失败，插入数据库失败！");

            return R.build(Http.OK, "用户注册成功！");
        } catch (Exception e) {
            throw new RuntimeException("JDBC 操作出错，注册失败！");
        }
    }
}
