package com.buchstadt.service;

import com.buchstadt.mapper.UserMapper;
import com.buchstadt.pojo.User;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<User> queryAll() {
        return mapper.queryAll();
    }

    public User query(Map<String, Object> map) {
        return mapper.query(map);
    }

    public Integer insert(User user) {
        return mapper.insert(user);
    }

    public Integer update(User user) {
        return mapper.update(user);
    }

    public R<Object> delete(User user) {
        Integer flag = mapper.delete(user);
        if (flag == 1) {
            return R.build(Status.OK, "删除成功");
        }
        return R.build(Status.NO, "删除失败");
    }

}
