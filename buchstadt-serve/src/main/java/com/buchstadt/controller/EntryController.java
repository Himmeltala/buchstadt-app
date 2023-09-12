package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.dto.TokenDto;
import com.buchstadt.pojo.vo.SignUpVo;
import com.buchstadt.service.IEntryService;
import com.buchstadt.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/entry")
@RequiredArgsConstructor
public class EntryController {

    private final IEntryService service;

    @PostMapping("/public/user-signin")
    public R<TokenDto> userSignIn(@RequestBody User user) {
        return service.userSignIn(user);
    }

    @PostMapping("/public/admin-signin")
    public R<TokenDto> adminSignIn(@RequestBody Admin admin) {
        return service.adminSignIn(admin);
    }

    @PostMapping("/public/user-signup")
    public R<Void> userSignup(@Validated @RequestBody SignUpVo vo) {
        return service.userSignUp(vo);
    }

}
