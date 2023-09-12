package com.buchstadt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.exception.JdbcErrorException;
import com.buchstadt.mapper.AddressMapper;
import com.buchstadt.pojo.Address;
import com.buchstadt.service.IAddressService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @description: 有关用户地址的业务
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/9/4
 */
@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    private final AddressMapper mapper;

    private boolean isDuplicate(Address data, Integer uid) {
        String detail = data.getDetail();
        Address one = super.query().eq("detail", detail).eq("user_id", uid).eq("phone", data.getPhone()).one();
        return !Objects.isNull(one);
    }

    private void updateTimestamp(Address data, boolean upCreate) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        if (upCreate) data.setCreateDate(timestamp);
        data.setModifyDate(timestamp);
    }

    @Transactional
    @Override
    public R<Integer> insertOneAddress(Address data, Integer uid) {
        try {
            if (isDuplicate(data, uid))
                return R.build(Http.NO, "重复保存一个详细地址相同的手机号！可以更换其他手机号。");

            updateTimestamp(data, true);

            return R.build(Http.OK, "保存新地址成功！", mapper.insertOneAddress(data, uid));
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    private boolean handleHasDefaultAddress(Integer uid) {
        Address defa = super.query()
                .eq("is_default", 1)
                .eq("user_id", uid)
                .one();

        boolean f;

        if (!Objects.isNull(defa)) {
            UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
            wrapper
                    .eq("id", defa.getId())
                    .eq("user_id", uid)
                    .set("is_default", 0);
            f = super.update(wrapper);
        } else f = true;

        return f;
    }

    private boolean handleNewDefaultAddress(Integer id, Integer uid) {
        UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
        wrapper
                .eq("id", id)
                .eq("user_id", uid)
                .set("is_default", 1);
        return super.update(wrapper);
    }

    @Transactional
    @Override
    public R<Integer> updateAddressDefault(Integer id, Integer uid) {
        try {
            boolean f, a;
            a = handleHasDefaultAddress(uid);
            f = handleNewDefaultAddress(id, uid);

            if (!f && !a) return R.build(Http.OK, "更新默认地址失败！");

            return R.build(Http.OK, "更新默认地址成功！");
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }


    @Transactional
    @Override
    public R<Integer> updateOneAddress(Address data, Integer uid) {
        try {
            if (isDuplicate(data, uid))
                return R.build(Http.NO, "地址信息没有变更，如果不更新请关闭对话框！");

            updateTimestamp(data, false);

            UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
            wrapper.eq("user_id", uid).eq("id", data.getId());
            boolean f = super.update(data, wrapper);

            if (!f) return R.build(Http.NO, "更新地址数据失败！");

            return R.build(Http.OK, "更新地址成功！");
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    @Transactional
    @Override
    public R<Integer> deleteOneAddress(Integer id, Integer uid) {
        try {
            QueryWrapper<Address> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", uid).eq("id", id);
            boolean f = super.remove(wrapper);

            if (!f) return R.build(Http.NO, "删除地址失败！");
            return R.build(Http.OK, "删除地址成功！");
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    @Override
    public R<Address> queryOneAddress(Integer uid, Integer isDefault) {
        Address address = super.query()
                .eq("user_id", uid)
                .eq("is_default", isDefault)
                .one();

        return R.build(Http.OK, address);
    }

    @Override
    public R<PageInfo<Address>> queryAllAddressByUid(Integer uid, Integer pageSize, Integer currPage) {
        try {
            if (Objects.isNull(pageSize) && Objects.isNull(currPage)) {
                pageSize = 5;
                currPage = 1;
            }
            PageHelper.startPage(currPage, pageSize);
            List<Address> list = super.query().eq("user_id", uid).list();

            return R.build(Http.OK, new PageInfo<>(list, pageSize));
        } finally {
            PageHelper.clearPage();
        }
    }
}
