package com.buchstadt.service;

import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.dto.TokenDto;
import com.buchstadt.pojo.vo.SignUpVo;
import com.buchstadt.utils.R;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IEntryService {

    R<TokenDto> userSignIn(User data);

    R<TokenDto> adminSignIn(Admin data);

    R<Void> userSignUp(SignUpVo vo);

}
