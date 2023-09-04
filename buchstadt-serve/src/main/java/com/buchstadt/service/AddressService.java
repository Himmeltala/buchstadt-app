package com.buchstadt.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.exception.JdbcErrorException;
import com.buchstadt.exception.JdbcFailedException;
import com.buchstadt.mapper.AddressMapper;
import com.buchstadt.pojo.Address;
import com.buchstadt.pojo.vo.AddressVo;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> {

    @Resource
    private AddressMapper mapper;

    private boolean isDuplicateInsertAddressByDetail(AddressVo vo, Integer uid) {
        String detail = vo.getDetail();
        Address address = mapper.queryOneAddressByDetail(detail, uid);
        return !Objects.isNull(address);
    }

    private Address setAddress(AddressVo vo) {
        Address data = new Address();

        List<String> zone = vo.getZone();

        // province city
        data.setProvince(zone.get(0));
        data.setCity(zone.get(1));

        // area
        if (zone.size() > 2) {
            String area = zone.get(2);
            if (!Objects.isNull(area)) data.setArea(area);
        }

        // street
        if (zone.size() > 3) {
            String street = zone.get(3);
            if (!Objects.isNull(street)) data.setStreet(street);
        }

        data.setHolder(vo.getHolder());
        data.setDetail(vo.getDetail());
        data.setPhone(vo.getPhone());

        Timestamp timestamp = new Timestamp(new Date().getTime());
        data.setCreateDate(timestamp);
        data.setModifyDate(timestamp);

        return data;
    }

    @Transactional
    public R<Integer> insertOneAddress(AddressVo vo, Integer uid) {
        try {
            boolean isDuplicate = isDuplicateInsertAddressByDetail(vo, uid);
            if (isDuplicate) return R.build(Http.NO, "重复保存同一地区同一详细地址！");

            Address data = setAddress(vo);
            return R.build(Http.OK, "保存新地址成功！", mapper.insertOneAddress(data, uid));
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

    public R<List<Address>> queryAllAddresses(Integer uid) throws JdbcFailedException {
        try {
            return R.build(Http.OK, mapper.queryAllAddresses(uid));
        } catch (Exception e) {
            throw new JdbcFailedException(e.getCause());
        }
    }

    @Transactional
    public R<Integer> updateAddressIsDefault(Integer id, Integer uid) {
        try {
            // 查询该用户是否设置过默认地址
            Address defa = super.query()
                    .eq("is_default", 1)
                    .eq("user_id", uid)
                    .one();

            if (!Objects.isNull(defa)) {
                UpdateWrapper<Address> updateLastDefault = new UpdateWrapper<>();
                updateLastDefault
                        .eq("id", defa.getId())
                        .eq("user_id", uid)
                        .set("is_default", 0);
                super.update(updateLastDefault);
            }

            UpdateWrapper<Address> updateNewDefault = new UpdateWrapper<>();
            updateNewDefault
                    .eq("id", id)
                    .eq("user_id", uid)
                    .set("is_default", 1);
            super.update(updateNewDefault);

            return R.build(Http.OK, "更新地址成功！");
        } catch (Exception e) {
            throw new JdbcErrorException(e.getCause());
        }
    }

}
