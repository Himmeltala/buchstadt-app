package com.buchstadt.service;

import com.buchstadt.mapper.UserMapper;
import com.buchstadt.pojo.User;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper mapper;

    public R<List<User>> queryAll() {
        return R.build(HttpCodes.OK, mapper.queryAll());
    }

    public R<User> query(Map<String, Object> data) {
        return R.build(HttpCodes.OK, mapper.query(data));
    }

    public R<Object> insert(User user) {
        return R.build(HttpCodes.OK, mapper.insert(user));
    }

    public R<Object> update(User user) {
        return R.build(HttpCodes.OK, "更新成功！", mapper.update(user));
    }

    public R<Object> delete(User user) {
        Integer flag = mapper.delete(user);
        if (flag == 1)
            return R.build(HttpCodes.OK, "删除成功");
        return R.build(HttpCodes.NO, "删除失败");
    }

}
