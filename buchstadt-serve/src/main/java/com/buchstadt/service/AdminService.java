package com.buchstadt.service;

import com.buchstadt.mapper.AdminMapper;
import com.buchstadt.pojo.Admin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper mapper;

    public List<Admin> queryAll() {
        return mapper.queryAll();
    }

    public Integer delete(Admin admin) {
        return mapper.delete(admin);
    }

    public Integer update(Admin admin) {
        return mapper.update(admin);
    }

    public Integer insert(Admin admin) {
        return mapper.insert(admin);
    }

}
