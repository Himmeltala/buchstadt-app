package com.buchstadt.service;

import com.buchstadt.mapper.AdminMapper;
import com.buchstadt.pojo.Admin;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper mapper;

    public R<List<Admin>> queryAll() {
        return R.build(HttpCodes.OK, mapper.queryAll());
    }

    public R<Integer> delete(Admin admin) {
        return R.build(HttpCodes.OK, "删除管理员成功！", mapper.delete(admin));
    }

    public R<Integer> update(Admin admin) {
        return R.build(HttpCodes.OK, "更新管理员信息成功！", mapper.update(admin));
    }

    public R<Integer> insert(Admin admin) {
        return R.build(HttpCodes.OK,"添加管理员成功！", mapper.insert(admin));
    }

}
