package com.buchstadt.service.impl;

import com.buchstadt.constant.KeyVals;
import com.buchstadt.exception.JdbcErrorException;
import com.buchstadt.mapper.EntryMapper;
import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.dto.TokenDto;
import com.buchstadt.pojo.vo.SignUpVo;
import com.buchstadt.service.IEntryService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.JwtUtil;
import com.buchstadt.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

/**
 * @description:
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/8/25
 */
@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements IEntryService {

    private final EntryMapper mapper;

    private TokenDto awardUserJwt(User user) {
        Long expire = JwtUtil.getExpire();
        String uid = UUID.randomUUID().toString();
        String value = JwtUtil.createJwt(user.getUsername(), KeyVals.TOKEN_USER_TYPE, uid, expire);

        return new TokenDto(value, KeyVals.TOKEN_USER_TYPE,
                user.getId(),
                user.getProfilePhoto(),
                user.getUsername());
    }

    @Override
    public R<TokenDto> userSignIn(User data) {
        User user = mapper.queryUser(data);

        if (Objects.isNull(user))
            return R.build(Http.NO, "没有该用户！");

        if (data.getPassword().equals(user.getPassword())
                && data.getUsername().equals(user.getUsername())
        ) {
            return R.build(Http.OK, "登录成功！", awardUserJwt(user));
        } else return R.build(Http.NO, "用户名或密码错误！");
    }

    private TokenDto awardAdminJwt(Admin admin) {
        Long expire = JwtUtil.getExpire();
        String uid = UUID.randomUUID().toString();
        String value = JwtUtil.createJwt(admin.getUsername(), KeyVals.TOKEN_ADMIN_TYPE, uid, expire);

        TokenDto dto = new TokenDto(value, KeyVals.TOKEN_ADMIN_TYPE,
                admin.getId(),
                admin.getProfilePhoto(),
                admin.getUsername());

        dto.setAuthority(admin.getAuthority());

        return dto;
    }

    @Override
    public R<TokenDto> adminSignIn(Admin data) {
        Admin admin = mapper.queryAdmin(data);

        if (Objects.isNull(admin))
            return R.build(Http.NO, "没有该用户！");

        if (admin.getPassword().equals(data.getPassword())
                && admin.getUsername().equals(data.getUsername())
        ) {
            return R.build(Http.OK, "登录成功！", awardAdminJwt(admin));
        } else return R.build(Http.NO, "用户名或密码错误！");
    }

    @Transactional
    @Override
    public R<Void> userSignUp(SignUpVo vo) {
        try {
            User user = mapper.userIsExist(vo.getUsername());
            if (!Objects.isNull(user))
                return R.build(Http.NO, "注册失败，已有该用户！");

            if (!vo.getPassword().equals(vo.getRePasswd()))
                return R.build(Http.NO, "注册失败，两次密码不一致！");

            Integer f = mapper.insertUser(vo);
            if (f != 1)
                return R.build(Http.NO, "用户注册失败，插入数据库失败！");

            return R.build(Http.OK, "用户注册成功！");
        } catch (Exception e) {
            throw new JdbcErrorException();
        }
    }
}
