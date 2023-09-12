package com.buchstadt.service;

import com.buchstadt.pojo.User;
import com.buchstadt.pojo.vo.UpdatePwdVo;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IUserService {

    R<PageInfo<User>> queryAll(Integer pageSize, Integer currPage);

    R<User> queryOne(Integer id);


    R<Integer> insertOne(User user);

    R<Integer> updateOne(User user);

    R<Void> deleteOne(User user);

    R<Void> updatePwd(UpdatePwdVo vo, Integer uid);

}
