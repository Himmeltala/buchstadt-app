package com.buchstadt.service;

import com.buchstadt.mapper.AdminMapper;
import com.buchstadt.pojo.Admin;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper mapper;

    public R<List<Admin>> queryAll() {
        return R.build(Http.OK, mapper.queryAll());
    }

    public R<Integer> deleteOne(Admin data) {
        return R.build(Http.OK, "删除管理员成功！", mapper.deleteOne(data));
    }

    public R<Integer> updateOne(Admin data) {
        return R.build(Http.OK, "更新管理员信息成功！", mapper.updateOne(data));
    }

    public R<Integer> insertOne(Admin data) {
        return R.build(Http.OK,"添加管理员成功！", mapper.insertOne(data));
    }

}
