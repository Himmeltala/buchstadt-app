package com.buchstadt.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.exception.JdbcErrorException;
import com.buchstadt.mapper.AdminMapper;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.IAdminService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/8/25
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    private final AdminMapper mapper;

    @Override
    public R<PageInfo<Admin>> queryAll(Integer pageSize, Integer currPage) {
        PageHelper.startPage(currPage, pageSize);
        List<Admin> list = super.query().list();
        PageInfo<Admin> pageInfo = new PageInfo<>(list, pageSize);
        return R.build(Http.OK, pageInfo);
    }

    @Transactional
    public R<Integer> deleteOne(Integer id) {
        try {
            boolean f = super.removeById(id);
            if (!f) return R.build(Http.NO, "删除管理员失败！");

            return R.build(Http.OK, "删除管理员成功！", 1);
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    @Transactional
    @Override
    public R<Integer> updateOne(Admin data) {
        try {
            UpdateWrapper<Admin> wrapper = new UpdateWrapper<>();
            wrapper.eq("id", data.getId());
            boolean f = super.update(data, wrapper);

            if (!f) return R.build(Http.NO, "更新管理员信息失败！", 0);
            return R.build(Http.OK, "更新管理员信息成功！", 1);
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    private boolean isExist(Admin data) {
        Admin admin = super.query().eq("username", data.getUsername()).one();
        return !Objects.isNull(admin);
    }

    @Transactional
    @Override
    public R<Integer> insertOne(Admin data) {
        try {
            if (isExist(data)) return R.build(Http.NO, "已经存在该管理员！");

            boolean f = super.save(data);
            if (!f) R.build(Http.OK, "添加管理员失败！", 0);
            return R.build(Http.OK, "添加管理员成功！", 1);
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

}
